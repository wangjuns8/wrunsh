package com.minierp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/resultController")  
public class ResultController {
     @RequestMapping(value="/validateCode",method=RequestMethod.POST)
     public void doPost(HttpServletRequest request, HttpServletResponse response)         
             throws ServletException, IOException {         
     	System.out.println("validateCode starting...");

    	 response.setContentType("text/html;charset=utf-8");         
         String validateC = (String) request.getSession().getAttribute("validateCode");         
         String veryCode = request.getParameter("c");         
      	System.out.println("validateCode: validateC=" + validateC + ", veryCode=" + veryCode);
         PrintWriter out = response.getWriter();         
         if(veryCode==null||"".equals(veryCode)){         
             out.println("验证码为空");         
         }else{         
             if(validateC.equalsIgnoreCase(veryCode)){         
                 out.println("验证码正确");         
             }else{         
                 out.println("验证码错误");         
             }         
         }         
         out.flush();         
         out.close();         
     }         
}
