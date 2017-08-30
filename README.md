# 开发手册  

## 开发环境
集成开发环境: Eclipse  
Java版本: Java 1.7  
数据库: Mysql  

## 数据库结构
Categorytable：  

|categoryId|category|   
|---|---|  
|int|varchar|  

Filetable：  

|id|fileFileName|fileContentType|path|fileTitle|fileContent|categoryId|  
|---|---|---|---|---|---|---|  
|int|varchar|varchar|varchar|varchar|longtext|int|  

Usertable：  

|id|userName|userPassword|  
|---|---|---|  
|int|varchar|varchar|  

## 安装
执行命令下载 `git clone git@github.com:hcxyrjkf/OfficialWebsite.git`  
下载后，通过eclipse的import来导入工程.若出现错误，进入项目的设置界面，选择java build path 删除所有包，并且导入工程中WebContent下的lib文件夹中的所有jar包.  
项目所需的数据库，在项目中，名为userdata.sql.  
## 注意！！！ 上传时需要上传zip或者rar格式，并且需要先上传webgl项目，再上传webplayer项目
