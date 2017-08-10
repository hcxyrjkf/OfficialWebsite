package com.webTest.tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReadFile {
	 public ReadFile() {
     }
     /**
      * 读取某个文件夹下的所有文件
     * @return 
      */
     public static ArrayList<File>  readfile(String filepath) throws FileNotFoundException, IOException {
    	 	ArrayList<File> list = new ArrayList<File>();
             try {

                     File file = new File(filepath);
                     if (!file.isDirectory()) {
                    	 	 list.add(file);
//                             System.out.println("文件");
//                             System.out.println("path=" + file.getPath());
//                             System.out.println("absolutepath=" + file.getAbsolutePath());
//                             System.out.println("name=" + file.getName());
//                    	 	 return list;
                    	 	 return list;
                     } else {
                             System.out.println("检测到文件夹");
                             String[] filelist = file.list();
                             for (int i = 0; i < filelist.length; i++) {
                                     File readfile = new File(filepath + "\\" + filelist[i]);
                                     if (!readfile.isDirectory()) {
                                    	 	 list.add(readfile);
                                    	 	 //System.err.println(list);
//                                             System.out.println("path=" + readfile.getPath());
//                                             System.out.println("absolutepath="
//                                                             + readfile.getAbsolutePath());
//                                             System.out.println("name=" + readfile.getName());
                                    	 	
                                     } else if (readfile.isDirectory()) {
                                          readfile(filepath + "\\" + filelist[i]);
                                          //System.err.println("有文件夹");
                                     }
                                    
                             }
                             System.out.println(list);
                             return list;
                     }
                     
             } catch (FileNotFoundException e) {
                     System.out.println("readfile()   Exception:" + e.getMessage());
                     return null ;
             }
             
     }
     public static void main(String[] args) {
    	 int fileNum = 0;
         int folderNum = 0;
         File file = new File("E:\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\OfficialWebsite-master\\biananes-master");
         if (file.exists()) {
             LinkedList<File> filelist = new LinkedList<File>();
             File[] files  = file.listFiles();
             //遍历这个文件
             for (File file2 : files) {
             	//如果这个文件是文件夹
                 if (file2.isDirectory()) {
                     System.out.println("文件夹:" + file2.getAbsolutePath());
                     //文件夹list 添加这个文件夹
                     filelist.add(file2);
                     fileNum++;
                 } else {  
                     //如果是文件，执行解析文件函数
                 	
                 	folderNum++;
                 	System.out.println(file2.getAbsolutePath());
                 	
                 }
             }
             File temp_file;
             //遍历list
             while (!filelist.isEmpty()) {
                 temp_file = filelist.removeFirst();
                 files = temp_file.listFiles();
                 for (File file2 : files) {
                     if (file2.isDirectory()) {
                        
                         filelist.add(file2);
                         fileNum++;
                     } else {
                
                     	folderNum++;
                    	System.out.println(file2.getAbsolutePath());//因为我要把这些存储到数据库

                     }
                 }
             
             }
             
              
         } else {
             System.out.println("文件不存在!");
         }
      
         System.out.println("文件夹共有:" + fileNum + ",文件共有:" + folderNum);
 			
 	}
     public List<String> readFile(String path){
    	 int fileNum = 0;
         int folderNum = 0;
        List<String> fileList = new ArrayList<String>();
        File file = new File(path);
//         File file = new File("E:\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\OfficialWebsite-master\\biananes-master");
         if (file.exists()) {
             LinkedList<File> filelist = new LinkedList<File>();
             File[] files  = file.listFiles();
             //遍历这个文件
             for (File file2 : files) {
             	//如果这个文件是文件夹
                 if (file2.isDirectory()) {
                     System.out.println("文件夹:" + file2.getAbsolutePath());
                     //文件夹list 添加这个文件夹
                     filelist.add(file2);
                     fileNum++;
                 } else {  
                     //如果是文件，执行解析文件函数
                	 fileList.add(file2.getAbsolutePath());
                 	folderNum++;
                 	System.out.println(file2.getAbsolutePath());
                 	
                 }
             }
             File temp_file;
             //遍历list
             while (!filelist.isEmpty()) {
                 temp_file = filelist.removeFirst();
                 files = temp_file.listFiles();
                 for (File file2 : files) {
                     if (file2.isDirectory()) {
                        
                         filelist.add(file2);
                         fileNum++;
                     } else {
                    	 fileList.add(file2.getAbsolutePath());
                     	folderNum++;
                     	
                    	System.out.println(file2.getAbsolutePath());//因为我要把这些存储到数据库

                     }
                 }
             
             }
             
              
         } else {
             System.out.println("文件不存在!");
         }
      
         System.out.println("文件夹共有:" + fileNum + ",文件共有:" + folderNum);
    	 
    	 
    	 return fileList;
    	 
     }
	
}
