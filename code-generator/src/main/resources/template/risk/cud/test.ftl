${table.title}

${table.requestMapping}/1/10

<#list table.columns as column>
    <#if column.javaName != "id">
        ${column.javaName}:""
    </#if>
</#list>

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
        "current": {
            "type": "integer",
            "description": "頁碼",
            "mock": {
                "mock": 1
            }
        },
        "size": {
            "type": "integer",
            "description": "每頁記錄數",
            "mock": {
                "mock": 10
            }
        },
        "descs[0]": {
            "type": "string",
            "description": "降序字段",
            "mock": {
                "mock": "id"
            }
        }
    },
    "required": [
    <#list table.columns as column>
        <#if column.javaName != "id">
            "${column.javaName}",
        </#if>
    </#list>
        "current",
        "size",
        "descs[0]"
    ]
}
