package com.gemini.code.generator;

import com.gemini.code.generator.domain.Column;
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
import java.util.Date;
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
        List<Dict> list = dictService.find("product.t_platform_dict");
        CodeUtils.generateDicts(list);
        for (Dict dict : list) {
            CodeUtils.generateEnums(dict);
        }
    }

    @Test
    public void generator() {

        // 初始化基本参数
        Table table = new Table();
        table.setDataBaseName("product");
        table.setTablePrefix("");
        table.setPackageName("com.gemini.business");
        table.setAuthor("小明不读书");
//        table.setFeignName();
//        table.setHasBigDecimal();
//        table.setHasDate();
//        table.setDetailListName();
//        table.setDetail();
//        table.setDicts();
//        table.setHasDicts();
        table.setCreateDate(new Date().toString());

        // ftl模板路径
        String templatePath = "boot/";

        // 获取数据库的表名称和表注释
        List<DataBase> product = mysqlService.getTable(table.getDataBaseName());
        // key=表名称，value=表注释
        Map<String, String> map = new HashMap<>();
        for (DataBase dataBase : product) {
            map.put(dataBase.getTableName(), dataBase.getTableComment());
        }

        // 生成代码
        // 代码生成的目录名称
        String basePath = System.getProperty("user.dir");
        File file = new File(basePath);
        basePath = file.getParent() + "/src";
        for (String tableName : map.keySet()) {
            table.setCatalog(basePath);
            table.setTableName(tableName);
            table.setTableComment(map.get(tableName));
            table.setColumns(mysqlService.getColumn(tableName));
            for (Column column : table.getColumns()) {
                column.init();
            }
            table.initTable(table);
            CodeUtils.createModel(table, templatePath);
        }

    }
}
