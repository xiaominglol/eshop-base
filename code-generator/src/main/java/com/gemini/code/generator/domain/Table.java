package com.gemini.code.generator.domain;

import com.gemini.code.generator.utils.StringUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Table {


    /**
     * 表名称（通过数据库查出）
     * eg：t_platform_user
     */
    String tableName;

    /**
     * 表注释（通过数据库查出）
     * eg：用户表
     */
    String tableComment;

    /**
     * 生成代碼的路徑
     * eg:D:\IdeaProjects-gemini\gemini\gemini-framework/src
     */
    String catalog;
    /**
     *  数据库名称
     *  eg：product
     */
    String dataBaseName;
    /**
     * 需要去掉的表前缀
     * eg: t_
     */
    String tablePrefix;
    /**
     * 去掉表前缀后的名称
     * eg：platform_user
     */
    String smartTableName;
    String tableAlias = "";//表別名（不賦值則根據smartTableName生成）
    /**
     * 模块名称 根据表名称t_platform_user 的“_”分组 得到的第二个
     * eg:platform
     */
    String moduleName;
    /**
     * 包名称
     * eg: com.gemini.business
     */
    String packageName;
    /**
     * 首字母大写类名，根據smallClassName生成
     * eg：PlatformUser
     */
    String bigClassName;
    /**
     * 首字母小写类名
     * eg：platformUser
     */
    String smallClassName;
    /**
     * 作者
     */
    String author;

    /**
     * 生成时间
     */
    String createDate;

    /**
     * controller请求路径
     * eg：/product
     */
    String requestMapping;


    /**
     * 表字段
     */
    List<Column> columns;


    String feignName = "";
    boolean hasBigDecimal = false;
    boolean hasDate = false;

    String detailListName = null;

    boolean isDetail = false;

    List<Map<String, String>> dicts;

    boolean hasDicts = false;

    /**
     * @param tableName      表名称
     * @param catalog        目录
     * @param tableComment   表注释
     * @param requestMapping controller请求路径
     * @param columns        字段列表
     * @param tablePrefix    去掉的表前缀
     * @param author         作者
     */
    public Table(String tableName, String catalog, String tableComment, String requestMapping, List<Column> columns, String tablePrefix, String author) {
        this(null, tableName, catalog, tableComment, requestMapping, columns, tablePrefix, author);
    }

    public Table(String tableName) {
        this.tableName = tableName;
    }

    public Table(String tableName, String dataBaseName) {
        this.tableName = tableName;
        this.dataBaseName = dataBaseName;
    }

    public Table(String dataBaseName, String tableName, String catalog, String tableComment, String requestMapping, List<Column> columns, String tablePrefix, String author) {
        this();
        this.dataBaseName = dataBaseName;
        this.tableName = tableName;
        this.catalog = catalog;
        this.tableComment = tableComment;
        this.requestMapping = requestMapping;
        this.author = author;
        this.smartTableName = tableName.substring(tablePrefix.length());
        this.smallClassName = StringUtils.toCamelCase(smartTableName);
        this.bigClassName = StringUtils.toUpperCaseFirstOne(smallClassName);

        this.catalog += ("/" + smallClassName + "/");

        String[] alias = smartTableName.split("_");
        this.moduleName = alias[0];
        for (int i = 0; i < alias.length; i++) {
            this.requestMapping += "/" + alias[i];
            if (i == 0) {
                this.feignName += "-" + alias[i];
            }
        }
        this.tableAlias = alias[alias.length - 1].substring(0, 1);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(this.tableAlias);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        this.columns = columns;
        for (Column column : columns) {
            column.init();
            if ("modify_access_id".equals(column.getName())) {
                this.isDetail = true;
            }
        }
    }

    public Table initTable(Table table){
        table.setSmartTableName(table.getTableName().substring(table.getTablePrefix().length()));
        String[] split = table.getSmartTableName().split("_");
        table.setModuleName(split[0]);
        table.setSmallClassName(StringUtils.toCamelCase(table.getSmartTableName()));
        table.setBigClassName(StringUtils.toUpperCaseFirstOne(table.getSmallClassName()));
        table.setCatalog(table.getCatalog() + ("/" + table.getModuleName() + "/"));
        String reqeustMapping = "";
        for(String s : split){
            reqeustMapping += ("/" + s);
        }
        table.setRequestMapping(reqeustMapping);

        table.setTableAlias(split[split.length - 1].substring(0, 1));
        return table;
    }
}
