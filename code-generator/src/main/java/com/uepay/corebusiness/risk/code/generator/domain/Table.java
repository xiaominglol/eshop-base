package com.uepay.corebusiness.risk.code.generator.domain;

import com.uepay.corebusiness.risk.code.generator.utils.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Table {

    String url;//生成代碼的路徑（必填！！！）
    String title;//標題（必填！！！）
    String tableName;//表名（必填！！！）
    String smartTableName;//美化後的表明（根據tableName生成）
    String tableAlias = "";//表別名（不賦值則根據smartTableName生成）
    String domainName;//實體名稱（首字母小寫 ，不賦值則根據tableName生成）
    String className;//類名（首字母大寫，根據domainName生成）

    String request;
    String author;
    String feignName = "";
    boolean hasBigDecimal = false;

    boolean isDetail = false;

    List<Column> columns;

    List<Map<String, String>> dicts = new ArrayList<>();

    boolean hasDicts = false;

    public Table() {

    }

    public Table(String url, String author, String title, String request, List<Column> columns) {
        this();
        this.title = title;
        this.author = author;
        this.columns = columns;
        this.request = request;
        Column column = columns.get(0);
        tableName = column.getTableName();
        smartTableName = tableName.substring(4);

        domainName = domainName == null ? StringUtils.toCamelCase(smartTableName) : domainName;
        className = StringUtils.toUpperCaseFirstOne(domainName);
        this.url = url + "/" + domainName + "/";

        String[] alias = smartTableName.split("_");
        for (int i = 0; i < alias.length; i++) {
            tableAlias += alias[i].substring(0, 1);
            this.request += "/" + alias[i];
            if (i == 0) {
                this.feignName += "-" + alias[i];
            }
        }

        for (Column col : columns) {
            col.setName(col.getName().toLowerCase());
            if ("modify_access_id".equals(col.getName())) {
                this.isDetail = true;
            }
            col.setMappingName(StringUtils.toCamelCase(col.getName()));
            String mappingType = null;
            switch (col.getType()) {
                case "bigint":
                    mappingType = "Long";
                    String[] arr = col.getName().split("_");
                    String f = StringUtils.toCamelCase(col.getName());
                    if (f.length() > 3 && "id".equals(arr[arr.length - 1])) {
                        String s = f.substring(0, f.length() - 2);
                        for (Column c : columns) {
                            if ((s + "NameCn").equals(StringUtils.toCamelCase(c.getName()))) {
                                Map<String, String> map = new HashMap<>();
                                map.put("n", s);
                                map.put("c", col.getMappingComment());
                                dicts.add(map);
                                hasDicts = true;
                            }
                        }
                    }
                    System.out.println(dicts);
                    break;
                case "int":
                    mappingType = "Integer";
                    break;
                case "datetime":
                    mappingType = "Date";
                    break;
                case "bit":
                    mappingType = "Boolean";
                    break;
                case "decimal":
                    hasBigDecimal = true;
                    mappingType = "BigDecimal";
                    break;
                case "float":
                    mappingType = "Float";
                    break;
                case "timestamp":
                    mappingType = "Timestamp";
                    break;
                default:
                    mappingType = "String";
            }
            col.setMappingType(mappingType);
            col.setMappingComment(col.getComment());
            if ("Integer".equals(col.getMappingType()) || "BigDecimal".equals(col.getMappingType()) || "Float".equals(col.getMappingType()) || "Double".equals(col.getMappingType()) || "Decimal".equals(col.getMappingType())) {
                col.setInputType("number");
            } else if ("Date".equals(col.getMappingType())) {
                col.setInputType("datetime");
            } else if ("Long".equals(col.getMappingType())) {
                col.setInputType("hidden");
            } else {
                col.setInputType("text");
            }
            //System.out.println(col.getMappingName() + ":" + col.getInputType());

            if ("modifyUser".equals(col.getMappingName())) {
                col.setMappingComment("修改人");
            }
            if ("modifyDate".equals(col.getMappingName())) {
                col.setMappingComment("修改日期");
            }
            if ("modifyType".equals(col.getMappingName())) {
                col.setMappingComment("修改類型");
            }
            if ("modifyAccessId".equals(col.getMappingName())) {
                col.setMappingComment("修改人訪問ID");
            }
        }
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getSmartTableName() {
        return smartTableName;
    }

    public void setSmartTableName(String smartTableName) {
        this.smartTableName = smartTableName;
    }

    public String getTableAlias() {
        return tableAlias;
    }

    public void setTableAlias(String tableAlias) {
        this.tableAlias = tableAlias;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeignName() {
        return feignName;
    }

    public void setFeignName(String feignName) {
        this.feignName = feignName;
    }

    public boolean isHasBigDecimal() {
        return hasBigDecimal;
    }

    public void setHasBigDecimal(boolean hasBigDecimal) {
        this.hasBigDecimal = hasBigDecimal;
    }

    public boolean isDetail() {
        return isDetail;
    }

    public void setDetail(boolean detail) {
        isDetail = detail;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }

    public List<Map<String, String>> getDicts() {
        return dicts;
    }

    public void setDicts(List<Map<String, String>> dicts) {
        this.dicts = dicts;
    }

    public boolean isHasDicts() {
        return hasDicts;
    }

    public void setHasDicts(boolean hasDicts) {
        this.hasDicts = hasDicts;
    }
}
