${table.title}

${table.action}/page

{
    "$schema": "http://json-schema.org/draft-04/schema#",
    "type": "object",
    "properties": {
<#list table.columns as column>
    <#if column.javaName != "id">
        "${column.javaName}": {
            "type": "string",
        "description": "<#if column.comment??>${column.comment}</#if>",
            "mock": {
                "mock": ""
            }
        },
    </#if>
</#list>
        "pageNum": {
            "type": "integer",
            "description": "頁碼",
            "mock": {
                "mock": 1
            }
        },
        "pageSize": {
            "type": "integer",
            "description": "每頁記錄數",
            "mock": {
                "mock": 10
            }
        }
    },
    "required": [
<#list table.columns as column>
    <#if column.javaName != "id">
        "${column.javaName}",
    </#if>
</#list>
        "pageNum",
        "pageSize"
    ]
}
