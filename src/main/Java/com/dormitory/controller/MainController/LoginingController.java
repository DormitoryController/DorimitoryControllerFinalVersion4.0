package com.dormitory.controller.MainController;

import com.dormitory.Dao.CheckcodeMapper;
import com.dormitory.Dao.RepairerMapper;
import com.dormitory.Dao.StudentMapper;
import com.dormitory.Dao.SupervisorMapper;
import com.dormitory.model.po.Checkcode;
import com.dormitory.model.po.Repairer;
import com.dormitory.model.po.Student;
import com.dormitory.model.po.Supervisor;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by 赵嗣瑜 on 2017/5/11.
 */
@RequestMapping(value = "/LoginingController")
@Controller
public class LoginingController {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private RepairerMapper repairerMapper;
    @Autowired
    private SupervisorMapper supervisorMapper;
    @Autowired
    private CheckcodeMapper checkcodeMapper;
    @RequestMapping(value = "/")
    public String Logining(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "MainView/logining";
    }
    @RequestMapping(value = "/checkIn")
    public void CheckIn(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        JSONObject jsonObject = new JSONObject();
        if(!password.equals("")&&password.equals(studentMapper.selectStuByUsername(username).getPassword())){
            jsonObject.put("loginCheck","true");
            jsonObject.put("userType","学生");
        }
        if(!password.equals("")&&password.equals(repairerMapper.selectRepByUsername(username).getPassword())){
            jsonObject.put("loginCheck","true");
            jsonObject.put("userType","维修员");
        }
        if(!password.equals("")&&password.equals(supervisorMapper.selectSvByUsername(username).getPassword())){
            jsonObject.put("loginCheck","true");
            jsonObject.put("userType","宿舍管理员");
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
        String username=request.getParameter("username");
        JSONObject jsonObject = new JSONObject();
        if(studentMapper.selectStuByUsername(username)==null&&supervisorMapper.selectSvByUsername(username)==null&&repairerMapper.selectRepByUsername(username)==null){
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
        String registerPassword=request.getParameter("registerPassword");
        String registerUsername=request.getParameter("registerUsername");
        String checkCode=request.getParameter("checkCode");
        String userType=request.getParameter("userType");
        String registerCheck="false";
        List<Checkcode> checkcodeList=checkcodeMapper.selectCheckcodeByStateAndUserType(userType);
        for(Checkcode getcheckcode:checkcodeList){
            if(checkCode.equals(getcheckcode.getCheckcode())){
                int id=getcheckcode.getId();
                checkcodeMapper.updateCheckcodeState(id,"1");
                if(userType.equals("学生")) {
                    registerCheck = "true";
                    Student student = new Student();
                    student.setUsername(registerUsername);
                    student.setPassword(registerPassword);
                    studentMapper.insertStudent(student);
                    Student reStudent=studentMapper.selectStuByUsername(registerUsername);
                    int unitId=reStudent.getId();
                    checkcodeMapper.updateCheckcode(checkCode,unitId);
                    break;
                }
                if(userType.equals("宿舍管理员")) {
                    registerCheck = "true";
                    Supervisor supervisor=new Supervisor();
                    supervisor.setUsername(registerUsername);
                    supervisor.setPassword(registerPassword);
                    supervisorMapper.insertSupervisor(supervisor);
                    break;
                }
                if(userType.equals("维修员")) {
                    registerCheck = "true";
                    Repairer repairer=new Repairer();
                    repairer.setUsername(registerUsername);
                    repairer.setPassword(registerPassword);
                    repairerMapper.insertReq(repairer);
                    break;
                }

            }
        }
        jsonObject.put("registerCheck",registerCheck);
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
    public void codeChangeSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String registerPassword=request.getParameter("registerPassword");
        String registerUsername=request.getParameter("registerUsername");
        String checkCode=request.getParameter("checkCode");
        JSONObject jsonObject = new JSONObject();
        String registerCheck="false";
        List<Checkcode> checkcodeList=checkcodeMapper.selectAllCheckcode();
        for (Checkcode getCheckCode:checkcodeList){
           if(checkCode.equals(getCheckCode.getCheckcode())){
               Long id=getCheckCode.getUser_id();
               String userType=getCheckCode.getUser_type();
               String user_state=getCheckCode.getUse_state();
               if(user_state.equals("1")){
                   if(userType.equals("学生")){
                       Student student=studentMapper.selectStuById(id);
                       if(registerUsername.equals(student.getUsername())){
                           student.setPassword(registerPassword);
                       }
                   }
                   if(userType.equals("宿舍管理员")){
                       Supervisor supervisor=supervisorMapper.selectSvById(id)
                       if(registerUsername.equals(supervisor.getUsername())){
                           supervisor.setPassword(registerPassword);
                       }
                   }
                   if(userType.equals("维修员")){
                       Repairer repairer=new Repairer();
                       if(registerUsername.equals(repairer.getUsername())){
                           student.setPassword(registerPassword);
                       }
                   }
               }

           }
        }
        response.setHeader("content-type", "text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(jsonObject.toString());
        out.flush();
        out.close();


    }
}
