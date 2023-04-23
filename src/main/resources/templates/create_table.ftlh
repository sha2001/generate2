CREATE TABLE ${configuration.entity.table.name} (
<#list configuration.entity.table.tableFields as tableField>
    <#if tableField.colunm??>${tableField.column}<#else>${tableField.name}</#if> ${tableField.type} <#if tableField.id == true>primary key</#if>,
</#list>
);
