package com.util;

import java.io.UnsupportedEncodingException;

public class StringUtil {
   public static String ZERO = "00000";
   public static String PATH = "http://hq.sinajs.cn/list=";
   
   public static String sixLen(Integer i){
	   String num = i.toString();
	   int len = 6-num.length();
	   if(len>0) {
		   return ZERO.substring(0, len)+num;
	   }else{
		   return "999999";
	   }
   }
   public static String getNameByStr(String rs){
	  String name =  rs.substring(rs.indexOf("\""), rs.indexOf(","));
	  return name;
   }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
}
