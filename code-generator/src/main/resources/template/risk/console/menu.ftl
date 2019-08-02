<#assign id>${.now?string["1ddhhmmSSsss"]}</#assign>
INSERT INTO s_r_identity_mgr_options
(id,pid,code,name,alias,source,path,http_method,sort,category,is_open,icon,action,remark,modify_date,modify_type)
VALUES
(${id}00,null,'${table.domainName}','${table.title}：列表','${table.title}：列表','${table.request}/*/*','/${table.domainName}','GET',1,1,0,'setting',3,'${table.title}：列表',1563241615210,'Insert'),
(${id}01,${id}00,'${table.domainName}','${table.title}：詳情','${table.title}：詳情','${table.request}/*','/${table.domainName}','GET',2,2,0,'setting',3,'${table.title}：詳情',1563241615210,'Insert'),
(${id}02,${id}00,'${table.domainName}','${table.title}：新增','${table.title}：新增','${table.request}','/${table.domainName}','POST',3,2,0,'setting',3,'${table.title}：新增',1563241615210,'Insert'),
(${id}03,${id}00,'${table.domainName}','${table.title}：修改','${table.title}：修改','${table.request}','/${table.domainName}','PUT',4,2,0,'setting',3,'${table.title}：修改',1563241615210,'Insert'),
(${id}04,${id}00,'${table.domainName}','${table.title}：刪除','${table.title}：刪除','${table.request}/*','/${table.domainName}','DELETE',5,2,0,'setting',3,'${table.title}：刪除',1563241615210,'Insert');