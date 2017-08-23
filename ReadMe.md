# 开发手册  

## 开发环境：
eclipse，java1.7，mysql数据库。
全部引用的jar包，在项目的WebContent文件夹下的lib文件夹里面。
项目所需的数据库，在项目中，名为userdata.sql  

## 数据库结构：
### Categorytable：
|categoryId|category|   
|---|---|  
|int|varchar|  

### Filetable：
|id|fileFileName|fileContentType|path|fileTitle|fileContent|categoryId|  
|---|---|---|---|---|---|---|  
|int|varchar|varchar|varchar|varchar|longtext|int|  

### Usertable：
|id|userName|userPassword|  
|---|---|---|  
|int|varchar|varchar|  

# 用户手册  

## 下载  

通过 __git clone + 项目链接__  

下载后，通过eclipse的import来导入工程，若出现错误，进入项目的设置界面，选择java build path 删除所有包，并且导入工程中WebContent下的lib文件夹中的所有jar包
