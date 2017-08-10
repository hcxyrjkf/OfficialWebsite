package com.webTest.tools;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import com.webTest.Action.FilecAction;

public class UnZipper {
    /** 
     * 解压文件到当前目录 功能相当于右键 选择解压 
     * @param zipFile 
     * @param 
     * @author gabriel 
     */ 
	public static String outPath;
	public static ZipEntry entry;
    @SuppressWarnings("rawtypes") 
    public static void unZipFiles(File zipFile)throws IOException{ 
        //得到压缩文件所在目录 
        String path=zipFile.getAbsolutePath(); 
        path=path.substring(0,path.lastIndexOf("\\")); 
       // System.out.println("path "+path); 
        ZipFile zip = new ZipFile(zipFile); 
        for(Enumeration entries =zip.entries(); 
                entries.hasMoreElements();){ 
            entry = (ZipEntry)entries.nextElement(); 
            String zipEntryName = entry.getName(); 
            InputStream in = zip.getInputStream(entry); 
            //outPath输出目录 
            outPath = (path+"\\"+zipEntryName).replaceAll("\\\\", "/");; 
            //System.out.println("outPath "+outPath); 
            //判断路径是否存在,不存在则创建文件路径 
            File file = new File(outPath.substring(0, outPath.lastIndexOf('/'))); 
            if(!file.exists()){ 
                file.mkdirs(); 
            } 
            //判断文件全路径是否为文件夹,如果是上面已经上传,不需要解压 
            if(new File(outPath).isDirectory()){ 
                continue; 
            } 
            //输出文件路径信息 
            System.out.println(outPath); 

            OutputStream out = new FileOutputStream(outPath); 
            byte[] buf1 = new byte[1024]; 
            int len; 
            while((len=in.read(buf1))>0){ 
                out.write(buf1,0,len); 
                
            } 
            in.close(); 
            out.close(); 
            } 
        System.out.println("******************解压完毕********************"); 
    }
    
//    public static void main(String[] args) { 
//        try { 
//            unZipFiles(new File("C:\\Users\\hp\\Desktop\\testsping.zip")); 
//        } catch (IOException e) { 
//            // TODO Auto-generated catch block 
//            e.printStackTrace(); 
//        } 
//    } 
}
