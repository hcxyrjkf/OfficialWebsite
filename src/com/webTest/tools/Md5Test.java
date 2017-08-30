package com.webTest.tools;

import java.security.MessageDigest;

import org.springframework.stereotype.Component;

@Component("md5Test")
public class Md5Test {
  
  public String toMD5(String plainText) {
	  StringBuffer buf=new StringBuffer("");
   try {
    //生成实现指定摘要算法的 MessageDigest 对象。
    MessageDigest md = MessageDigest.getInstance("MD5"); 
    //使用指定的字节数组更新摘要。
    md.update(plainText.getBytes());
    //通过执行诸如填充之类的最终操作完成哈希计算。
    byte b[] = md.digest();
    //生成具体的md5密码到buf数组
    int i;
    for (int offset = 0; offset < b.length; offset++) {
     i = b[offset];
     if (i < 0)
      i += 256;
     if (i < 16)
      buf.append("0");
     buf.append(Integer.toHexString(i));
    }
    //System.out.println("32位: " + buf.toString());// 32位的加密
    //System.out.println("16位: " + buf.toString().substring(8, 24));// 16位的加密，其实就是32位加密后的截取
    
   } 
   catch (Exception e) {
    e.printStackTrace();
   }
   return buf.toString();
  }
  
  public static void main(String agrs[]) {
    new Md5Test().toMD5("1234");//加密LXD
  }
}