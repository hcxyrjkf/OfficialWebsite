# 开发环境：
eclipse，java1.7，mysql数据库。
全部引用的jar包，在项目的WebContent文件夹下的lib文件夹里面。
项目所需的数据库，在项目中，名为userdata.sql
# 数据库结构：
![Menu](https://github.com/StandardStudent/OfficialWebsite/raw/master/forReadMe/Menu.png)
## Categorytable：
存储上传文件的种类，0为计算机视觉，1为虚拟现实
## Filetable：
Id:上传文件后自动生成的id，自动增加  
fileFileName:上传文件解压后的文件名  
fileContentType:上传文件解压后的文件类型  
path:上传文件解压后的文件相对路径  
fileTitle:上传文件时手动输入的文件标题  
fileContent:上传文件时手动输入的文件简介内容  
categoryId:关联categorytable的主键  
## Usertable：
Id:自增id,自动生成  
userName:用户名  
userPassword:密码（md5加密后的）  
# 下载
![Download](https://github.com/StandardStudent/OfficialWebsite/raw/master/forReadMe/download.png)  
通过Clone or download 中的Download ZIP，下载文件  
下载后，通过eclipse的import来导入工程，若出现错误，进入项目的设置界面，选择java build path 删除所有包，并且导入工程中WebContent下的lib文件夹中的所有jar包
