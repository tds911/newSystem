package com.tds.common.utils;

import com.tds.common.constant.HttpStatus;
import com.tds.common.core.text.Convert;
import com.tds.common.exception.CustomException;
import com.tds.modules.domain.UserEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.PushBuilder;
import java.io.IOException;

public class ServletUtils {
    public static HttpServletRequest getRequest(){
        return getRequestAttributes().getRequest();
    }
    public static ServletRequestAttributes getRequestAttributes(){
        RequestAttributes attributes= RequestContextHolder.getRequestAttributes();
        return (ServletRequestAttributes)attributes;
    }
    public static String renderString(HttpServletResponse response,String string){
        try{
            response.setStatus(200);
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(string);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
    public  static Integer getParameterToInt(String name){
        return Convert.toInt(getRequest().getParameter(name));
    }
    public static String getParameter(String name){
        return getRequest().getParameter(name);
    }

}
