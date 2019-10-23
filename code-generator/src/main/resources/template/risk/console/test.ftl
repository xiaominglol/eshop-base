${table.title}

${table.requestMapping}/1/10

<#list table.columns as column>
    <#if column.javaName != "id">
        ${column.javaName}:""
    </#if>
</#list>
ascs:""
descs:""

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
    },
    "required": [
    <#list table.columns as column>
        <#if column.javaName != "id">
            "${column.javaName}",
        </#if>
    </#list>
    ]
}
