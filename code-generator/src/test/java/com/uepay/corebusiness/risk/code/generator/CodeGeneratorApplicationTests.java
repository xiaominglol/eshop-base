package com.uepay.corebusiness.risk.code.generator;

import com.uepay.corebusiness.risk.code.generator.domain.Dict;
import com.uepay.corebusiness.risk.code.generator.service.ColumnService;
import com.uepay.corebusiness.risk.code.generator.service.DictService;
import com.uepay.corebusiness.risk.code.generator.utils.CodeUtils;
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
	ColumnService columnService;

	@Autowired
	DictService dictService;

	@Test
	public void dict() throws Exception {
        List<Dict> list = dictService.find("gemini_portal.f_sys_dict");
		CodeUtils.generateDicts(list);
		for(Dict dict : list) {
			CodeUtils.generateEnums(dict);
		}
	}

	@Test
	public void generator() throws Exception {

		String basePath = System.getProperty("user.dir");
		File file = new File(basePath);
		basePath = file.getParent() + "/src";

        String author = "小明不读书";
		String url = basePath + "/risk/console";
		String request = "/risk/console";
		String templatePath = "risk/console";
		Map<String, String> map = new HashMap<>();

		map.put("字典表", "f_sys_dict");
		map.put("错误日志表", "f_sys_error_log");
		map.put("登陆日志表", "f_sys_login_log");
		map.put("菜单表", "f_sys_menu");
		map.put("操作日志表", "f_sys_opt_log");
		map.put("组织架构表", "f_sys_org");
		map.put("角色表", "f_sys_role");
		map.put("用户表", "f_sys_user");

		CodeUtils.generateBatch(map, templatePath, columnService, url, author, request);

		url = basePath + "/risk/api";
		request = "/risk/api";
		templatePath = "risk/api";
		CodeUtils.generateBatch(map, templatePath, columnService, url, author, request);

		url = basePath + "/risk/cud";
		request = "/risk/cud";
		templatePath = "risk/cud";
		CodeUtils.generateBatch(map, templatePath, columnService, url, author, request);
	}
}
