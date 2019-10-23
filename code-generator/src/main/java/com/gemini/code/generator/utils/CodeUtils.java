package com.gemini.code.generator.utils;

import com.gemini.code.generator.domain.Dict;
import com.gemini.code.generator.domain.Table;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CodeUtils {

    /**
     * 生成代码
     *
     * @param map          key=表名称，value=表注释
     * @param templatePath
     * @param mysqlService
     * @param catalog      代码生成的目录
     * @param author
     * @param request
     */

    public static void createModel(Table table, String templatePath) {
        System.out.println(templatePath + "：》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》");
        String className = table.getClassName();
        createCode(table, templatePath, "feign", className + "Feign.java");
        createCode(table, templatePath, "controller", className + "Controller.java");
        createCode(table, templatePath, "service", className + "Service.java");
        createCode(table, templatePath, "serviceImpl", className + "ServiceImpl.java");
        createCode(table, templatePath, "mapper", className + "Mapper.java");
        createCode(table, templatePath, "mapperImpl", className + "Mapper.xml");
        createCode(table, templatePath, "po", className + "Po.java");
        createCode(table, templatePath, "dto", className + "Dto.java");
        createCode(table, templatePath, "vo", className + "Vo.java");
        createCode(table, templatePath, "menu", className + "：menu.txt");
        createCode(table, templatePath, "test", className + "：test.txt");
        System.out.println("end：《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《");
    }

    public static void createCode(Table table, String templatePath, String templateName, String fileName) {
        try {
            Configuration configuration = new Configuration();
            configuration.setDefaultEncoding("UTF-8");
            String path = CodeUtils.class.getClassLoader().getResource("").getPath();
            File file = new File(path);
            file = new File(file.getParent() + "/classes/template/" + templatePath);
            if (file.exists()) {
                configuration.setDirectoryForTemplateLoading(file);
                Template template = null;

                try {
                    template = configuration.getTemplate(templateName + ".ftl");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                if (template != null) {
                    System.out.println(templateName + ".ftl");
//                    File outFile = new File(table.getCatalog() + fileName);
                    File outFile = new File((table.getCatalog() + fileName).replaceFirst(table.getSmallClassName(), templateName));
                    if (!outFile.getParentFile().exists()) {
                        outFile.getParentFile().mkdirs();
                    }

                    System.out.println(outFile.getAbsolutePath());

                    Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "UTF-8"));
                    Map<String, Object> dataMap = new HashMap<String, Object>();
                    dataMap.put("table", table);
                    template.process(dataMap, out);

                    out.flush();
                    out.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static synchronized void generateEnums(Dict dict) throws Exception {
        try {
            System.out.println(dict.getCode() + "------------------------------------------------------------------------------------------------");
            Configuration configuration = new Configuration();
            configuration.setDefaultEncoding("UTF-8");
            String path = CodeUtils.class.getClassLoader().getResource("").getPath();
            File file = new File(path);
            file = new File(file.getParent() + "/classes/template/enums");
            if (file.exists()) {
                configuration.setDirectoryForTemplateLoading(file);
                Template template = null;

                try {
                    template = configuration.getTemplate("enums.ftl");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                if (template != null) {
                    String basePath = System.getProperty("user.dir");
                    basePath = new File(basePath).getParent() + "/src";
                    String url = basePath + "/enums";

                    File outFile = new File(url + "/" + dict.getCode() + "Enum.java");
                    if (!outFile.getParentFile().exists()) {
                        outFile.getParentFile().mkdirs();
                    }
                    Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "UTF-8"));
                    template.process(dict, out);
                    out.flush();
                    out.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static synchronized void generateDicts(List<Dict> list) throws Exception {
        try {
            Configuration configuration = new Configuration();
            configuration.setDefaultEncoding("UTF-8");
            String path = CodeUtils.class.getClassLoader().getResource("").getPath();
            File file = new File(path);
            file = new File(file.getParent() + "/classes/template/enums");
            if (file.exists()) {
                configuration.setDirectoryForTemplateLoading(file);
                Template template = null;

                try {
                    template = configuration.getTemplate("dicts.ftl");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                if (template != null) {
                    String basePath = System.getProperty("user.dir");
                    basePath = new File(basePath).getParent() + "/src";
                    String url = basePath + "/dicts";

                    File outFile = new File(url + "/Dicts.java");
                    if (!outFile.getParentFile().exists()) {
                        outFile.getParentFile().mkdirs();
                    }
                    Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "UTF-8"));
                    Map<String, List<Dict>> map = new HashMap<>();
                    map.put("list", list);
                    template.process(map, out);
                    out.flush();
                    out.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
