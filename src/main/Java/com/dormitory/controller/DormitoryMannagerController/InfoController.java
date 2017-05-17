package com.dormitory.controller.DormitoryMannagerController;

import com.dormitory.Dao.SupervisorMapper;
import com.dormitory.model.po.Supervisor;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lph on 2017/4/27.
 */
@RequestMapping(value = "/DormManage")
@Controller
public class InfoController {
    @Autowired
    private SupervisorMapper supervisorMapper;

    //修改个人信息
    @RequestMapping("/updateInfoControl")
    public String updateInfoControl() throws Exception {
        return "/DMView/updateInfoControl";
    }

    @RequestMapping("/updateInfo")
    public String updateInfo() throws Exception {
        return "/DMView/updateInfo";
    }

    @ResponseBody
    @RequestMapping(value = "/supervisorItems")
    public void supervisorItems(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        String username=session.getAttribute("username").toString();
        Supervisor supervisor = supervisorMapper.selectSvByUsername(username);
        System.out.println(username);
//        for(int i=0;i<supervisorList.size();i++){
//            System.out.println(supervisorList.get(i).getUsername());
//        }
        List<Supervisor> supervisorList = new LinkedList<Supervisor>();
        supervisorList.add(supervisor);
        System.out.println(supervisor.getUsername());
        response.setHeader("content-type", "text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("supervisorList", supervisorList);
        out.print(jsonObject.toString());
        out.flush();
        out.close();
    }

    @ResponseBody
    @RequestMapping(value = "/supervisorUpdate")
    public void supervisorUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String username = request.getParameter("username");

        System.out.println("宿管昵称："+username);
        Supervisor supervisor = supervisorMapper.selectSvByUsername(username);
        supervisor.setName(request.getParameter("name"));
        supervisor.setSex(request.getParameter("sex"));
        supervisor.setEmail(request.getParameter("email"));
        supervisor.setTelephone(request.getParameter("telephone"));
        supervisor.setOfficenum(request.getParameter("officenum"));
        supervisorMapper.updateSupersivor(supervisor);

        System.out.println("宿管办公室");
    }
}
