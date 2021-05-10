package com.ssm.utils;



import javax.servlet.http.Cookie;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


public class DoCookie {

    private  static Cookie cookie = null;

    public static void setCookie(String key,String value) throws UnsupportedEncodingException {

         cookie = new Cookie(key,URLEncoder.encode(value,"UTF-8"));  // 新建Cookie
         cookie.setPath("/");               // 设置路径
    }

    public static Cookie getCookie(){
        return cookie;
    }
}
