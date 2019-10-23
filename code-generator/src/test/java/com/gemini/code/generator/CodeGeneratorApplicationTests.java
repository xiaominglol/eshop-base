package com.gemini.code.generator;

import com.gemini.code.generator.domain.DataBase;
import com.gemini.code.generator.domain.Dict;
import com.gemini.code.generator.domain.Table;
import com.gemini.code.generator.service.DictService;
import com.gemini.code.generator.service.MysqlService;
import com.gemini.code.generator.utils.CodeUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CodeGeneratorApplicationTests {


    @Autowired
    DictService dictService;

    @Autowired
    MysqlService mysqlService;

    @Test
    public void dict() throws Exception {
        List<Dict> list = dictService.find("gemini_portal.f_sys_dict");
        CodeUtils.generateDicts(list);
        for (Dict dict : list) {
            CodeUtils.generateEnums(dict);
        }
    }

    @Test
    public void generator() {

        /**
         * 必填项
         */
        // 数据库名称
        String dataBaseName = "product";
        // 需要去掉的表前缀
        String tablePrefix = "t_";
        // 作者名称
        String author = "小明不读书";
        // 代码生成的目录名称
        String basePath = System.getProperty("user.dir");
        File file = new File(basePath);
        basePath = file.getParent() + "/src";
        String catalog = basePath + "";
        // controller请求路径
        String requestMapping = "";
        // 模板路径
        String templatePath = "boot/";

        // 获取数据库的表名称和表注释
        List<DataBase> product = mysqlService.getTable(dataBaseName);
        // key=表名称，value=表注释
        Map<String, String> map = new HashMap<>();
        for (DataBase dataBase : product) {
            map.put(dataBase.getTableName(), dataBase.getTableComment());
        }

        // 生成代码
        for (String tableName : map.keySet()) {
            String moduleName = tableName.substring(tablePrefix.length());
            String[] moduleNames = moduleName.split("_");
            Table table = new Table(tableName, basePath, map.get(tableName), requestMapping, mysqlService.getColumn(new Table(tableName)), tablePrefix, author);
            CodeUtils.createModel(table, templatePath);
        }

//
//        Table table = new Table("b_r_file_info", basePath + "/file", "文件信息", "file/server", mysqlService.getColumn(new Table("b_r_file_info", "file")));
//        CodeUtils.createModel(table, "/risk/console");
//
//
//        CodeUtils.createModel(
//                new Table(
//                        "t_wallet_product",
//                        basePath + "/wallet",
//                        "產品信息",
//                        "wallet/product",
//                        mysqlService.getColumn(new Table("t_wallet_product", "macao"))),
//                "/risk/console"
//        );
//        CodeUtils.createModel(
//                new Table(
//                        "t_wallet_product_channel",
//                        basePath + "/wallet",
//                        "產品支付通道",
//                        "wallet/product/channel",
//                        mysqlService.getColumn(new Table("t_wallet_product_channel", "macao"))),
//                "/risk/console"
//        );

    }
}
