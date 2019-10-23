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

    String catalog;//生成代碼的路徑（必填！！！）
    String tableComment;//表注释（必填！！！）
    String tableName;//表名称（必填！！！）
    String schemaName;
    String smartTableName;//美化後的表明（根據tableName生成）
    String tableAlias = "";//表別名（不賦值則根據smartTableName生成）
    String className;//類名（首字母大寫，根據smallClassName生成）
    String author;//作者
    /**
     * 首字母小写类名
     */
    String smallClassName;

    /**
     * controller请求路径
     */
    String requestMapping;
    String feignName = "";
    boolean hasBigDecimal = false;
    boolean hasDate = false;

    String detailListName = null;

    boolean isDetail = false;

    List<Column> columns;

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

    public Table(String tableName, String schemaName) {
        this.tableName = tableName;
        this.schemaName = schemaName;
    }

    public Table(String schemaName, String tableName, String catalog, String tableComment, String requestMapping, List<Column> columns, String tablePrefix, String author) {
        this();
        this.schemaName = schemaName;
        this.tableName = tableName;
        this.catalog = catalog;
        this.tableComment = tableComment;
        this.requestMapping = requestMapping;
        this.author = author;
        this.smartTableName = tableName.substring(tablePrefix.length());
        this.smallClassName = StringUtils.toCamelCase(smartTableName);
        this.className = StringUtils.toUpperCaseFirstOne(smallClassName);

        this.catalog += ("/" + smallClassName + "/");

        String[] alias = smartTableName.split("_");
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
}
