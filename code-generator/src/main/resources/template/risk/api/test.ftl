${table.title}

${table.request}/1/10

<#list table.columns as column>
    <#if column.mappingName != "id">
${column.mappingName}:""
    </#if>
</#list>

{
    "$schema": "http://json-schema.org/draft-04/schema#",
    "type": "object",
    "properties": {
    <#list table.columns as column>
        <#if column.mappingName != "id">
        "${column.mappingName}": {
            "type": "string",
            "description": "<#if column.mappingComment??>${column.mappingComment}</#if>",
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
        <#if column.mappingName != "id">
        "${column.mappingName}",
        </#if>
    </#list>
        "current",
        "size",
        "descs[0]"
    ]
}
