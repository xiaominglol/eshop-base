package com.uepay.corebusiness.risk.code.generator.utils;

import com.uepay.corebusiness.risk.code.generator.domain.Column;
import com.uepay.corebusiness.risk.code.generator.domain.Dict;
import com.uepay.corebusiness.risk.code.generator.domain.Table;
import com.uepay.corebusiness.risk.code.generator.service.ColumnService;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CodeUtils {

    public static void generateBatch(Map<String, String> map, String templatePath, ColumnService columnService, String url, String author, String request) {
        System.out.println(request + "：》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》");
        for (String key : map.keySet()) {
            System.out.println("------------------------------------------------------------------------------------------------");
            List<Column> list = columnService.find(map.get(key));
            if (list.size() > 0) {
                Table table = new Table(url, author, key, request, list);
                CodeUtils.createModel(table, templatePath);
            }
            System.out.println("------------------------------------------------------------------------------------------------");
        }
        System.out.println("end：《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《");
    }

    public static void createModel(Table table, String templatePath) {
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
                    File outFile = new File(table.getUrl() + fileName);
                    File outFile2 = new File((table.getUrl() + fileName).replaceFirst(table.getDomainName(), templateName));
                    if (!outFile.getParentFile().exists()) {
                        outFile.getParentFile().mkdirs();
                    }
                    if (!outFile2.getParentFile().exists()) {
                        outFile2.getParentFile().mkdirs();
                    }

                    Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "UTF-8"));
                    Map<String, Object> dataMap = new HashMap<String, Object>();
                    dataMap.put("table", table);
                    template.process(dataMap, out);

                    Writer out2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile2), "UTF-8"));
                    Map<String, Object> dataMap2 = new HashMap<String, Object>();
                    dataMap2.put("table", table);
                    template.process(dataMap, out2);

                    out2.flush();
                    out2.close();

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
