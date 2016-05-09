package com.cjs.util.string;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by xiaowu on 2016/5/8.
 */
public class StringUtil {

    /**
     * 如果字符串对象等于null转换非空""，否则不变
     * @param str
     * @return
     */
    public static String swapNull(String str){
        return str == null?"":str;
    }
    /**
     * 判断字符串是否为空（包含空对象和空字符串）
     * @param str 传入字符串
     * @return 是否为空
     */
    public static boolean isEmpty(String str){
        if(str==null||"".equals(str)){
            return true;
        }
        return false;
    }
    /**
     * 判断list集合是否为空（包括空对象和大小为0）
     * @param list
     * @return 是否为空
     */
    public static boolean isEmpty(List<?> list){
        if(list == null || list.size() == 0){
            return true;
        }
        return false;
    }

    /**
     * 将制定字符串的_字母转换成大写字母(先转成小写字母)
     * @param str 字符串
     * @return
     */
    public static String changeLineToLarge(String str){
        str = str.toLowerCase();
        //匹配_加小写字母
        Pattern pattern = Pattern.compile("_[a-z]");
        Matcher matcher = pattern.matcher(str);
        while(matcher.find()){
            String suitStr = matcher.group();
            str = str.replace(suitStr, suitStr.toUpperCase());
        }
        str = str.replace("_", "");
        return str;
    }

    /**
     * 将制定字符串的大写字母转换成_字母
     * @param str 字符串
     * @return
     */
    public static String changeLargeToLine(String str){
        StringBuffer buffer = new StringBuffer();
        for(int i=0;i<str.length();i++){
            String s = str.substring(i, i+1);
            s = s.replaceAll("[A-Z]", "_"+s);
            buffer.append(s);
        }
        return buffer.toString();
    }

    /**
     * 将传入参数首字母变成大写,并加上get返回
     * @param parameterName 属性名
     * @return
     */
    public static String getSetMethodName(String parameterName){
        return "set"+parameterName.substring(0, 1).toUpperCase()+parameterName.substring(1, parameterName.length());
    }

    /**
     * 将传入参数首字母变成大写,并加上set返回
     * @param parameterName 属性名
     * @return
     */
    public static String getGetMethodName(String parameterName){
        return "get"+firstCharToUpper(parameterName);
    }

    public static String firstCharToUpper(String str){
        return str.substring(0, 1).toUpperCase()+str.substring(1, str.length());
    }
    public static String firstCharToLower(String str){
        return str.substring(0, 1).toLowerCase()+str.substring(1, str.length());
    }
}

