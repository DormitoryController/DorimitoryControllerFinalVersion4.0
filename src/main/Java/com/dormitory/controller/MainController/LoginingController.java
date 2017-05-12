package com.dormitory.controller.MainController;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * Created by 赵嗣瑜 on 2017/5/11.
 */
@RequestMapping(value = "/LoginingController")
@Controller
public class LoginingController {
    String username="王力";
    String password="123";
    @RequestMapping(value = "/login")
    public String Logining(){
         return "MainView/logining";
    }
    @RequestMapping(value = "/checkIn")
    public void CheckIn(HttpServletRequest request, HttpServletResponse response) throws Exception {
        JSONObject jsonObject = new JSONObject();
        if(username.equals(request.getParameter("username"))&&password.equals(request.getParameter("password"))){
            HttpSession session=request.getSession();
            session.setAttribute("username",username);
            session.setAttribute("password",password);
            jsonObject.put("loginCheck","true");
        }
        else {
            jsonObject.put("loginCheck","false");
        }
        System.out.println(jsonObject.toString());
        response.setHeader("content-type", "text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(jsonObject.toString());
        out.flush();
        out.close();
    }
    @RequestMapping(value = "/register")
    public String register(){
        return "/MainView/register";
    }
    @RequestMapping(value = "/usernameCheck")
    public void usernameCheck(HttpServletRequest request, HttpServletResponse response) throws Exception {
        JSONObject jsonObject = new JSONObject();
        if(username.equals(request.getParameter("username"))){
            jsonObject.put("usernameCheck","true");
        }
        else {
            jsonObject.put("usernameCheck","false");
        }
        response.setHeader("content-type", "text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(jsonObject.toString());
        out.flush();
        out.close();
    }
    @RequestMapping(value = "/checkRegister")
    public void registerCheck(HttpServletRequest request, HttpServletResponse response) throws Exception {
        JSONObject jsonObject = new JSONObject();
//        String registerPassword=request.getParameter("registerPassword");
//        String registerUsername=request.getParameter("registerUsername");
        String checkCode=request.getParameter("checkCode");
        System.out.println("come here");
        if(checkCode.equals("123")){
            jsonObject.put("registerCheck","true");
        }
        else {
            jsonObject.put("registerCheck","false");
        }
        response.setHeader("content-type", "text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(jsonObject.toString());
        out.flush();
        out.close();
    }
    @RequestMapping(value = "/codeChange")
    public String codeChange(){
        return "MainView/codeChange";
    }
    @RequestMapping(value = "/codeChangeSubmit")
    public void codeChangdeSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        JSONObject jsonObject = new JSONObject();

        String checkCode=request.getParameter("checkCode");
        if(checkCode.equals("123")){
            jsonObject.put("registerCheck","true");
        }
        else {
            jsonObject.put("registerCheck","false");
        }
        response.setHeader("content-type", "text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(jsonObject.toString());
        out.flush();
        out.close();


    }
}
