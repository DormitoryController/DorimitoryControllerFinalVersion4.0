package com.dormitory.controller.StudentController;

import com.dormitory.Dao.MaintenanceMapper;
import com.dormitory.Dao.RepairerMapper;
import com.dormitory.Dao.StudentMapper;
import com.dormitory.model.po.Maintenance;
import com.dormitory.model.po.Repairer;
import com.dormitory.model.po.Student;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/9.
 */

@RequestMapping("/StudentView")

@Controller
public class StudentController {
    //日志
    private static final Log logger= LogFactory.getLog(StudentController.class);

    //加载接口
    @Resource
    private MaintenanceMapper maintenanceMapper;
    @Resource
    private StudentMapper studentMapper;
    @Resource
    private RepairerMapper repairerMapper;

    //根据名字查学生id
    public int selectStuId(String name){
        int sid;
        System.out.println("需要查的名字为："+name);
        Student st=studentMapper.selectStuByUsername(name);
       // System.out.println("学生信息："+st);
        sid=st.getId();
        System.out.println("学生信息："+sid);
        //sid = 123456l;
        return sid;
    }

    //根据维修员ID查名字
    public String seltctRepName(int id){
        String rname;
        Repairer re = repairerMapper.selectRepById(id);
        rname =re.getName();
        System.out.println("维修员名字为："+rname);
        return rname;
    }
     @RequestMapping(value ="/")
     public String welcome(){
        return "StudentView/Stu_first";
     }
    //保存维修单
    @RequestMapping(value = "/Stu_new",method = RequestMethod.POST)
    public void savefirst(HttpServletRequest request,HttpServletResponse response, Maintenance maintenance,HttpSession httpSession){
        String massage_detail = request.getParameter("index_detail");
        String massage_type = request.getParameter("index_type");
        String massage_location = request.getParameter("index_location");
        String massage_name = request.getParameter("index_name");
        String message=httpSession.getAttribute("username").toString();
        Date date = new Date();
        System.out.println(date+"时间能显示吗？");
        System.out.println("执行到此，先获取名字"+massage_detail+massage_name);
        maintenance.setStudent_id(studentMapper.selectStuIDByUsername(message));
        int s_id = selectStuId(message);//获取学生id
        System.out.println("aaaaaa"+date+"+++:");
        maintenance.setStudent_id(s_id);
        maintenance.setFault_type(massage_type);
        maintenance.setFault_detail(massage_detail);
        maintenance.setFault_location(massage_location);
        maintenance.setReform_time(date);
        maintenanceMapper.insertReform(maintenance);//插入数据库
        System.out.println("存入数据库成功++"+massage_detail);
    }

    //查看维修单，显示状态
    @ResponseBody
    @RequestMapping(value = "/Stu_seeStatus", method = RequestMethod.POST)
    public void seeStatus(HttpServletRequest request,HttpServletResponse response, Model model,HttpSession httpSession) throws IOException {
        System.out.println("查看维修单状态！");
        String message=httpSession.getAttribute("username").toString();
        //需要传的值为一个String类型的名字，可以取登录名。后面改
        //List<Maintenance> maintenancelist1 = new LinkedList();
        List<Maintenance> maintenancelist = maintenanceMapper.selectMaintenanceByStuUsername(message);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<String> datelist=new LinkedList<String>();
        for(Maintenance getMaintenance:maintenancelist){
            datelist.add(sdf.format(getMaintenance.getReform_time()));
        }
        System.out.println("维修单包括："+maintenancelist);
        response.setHeader("content-type", "text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("mlist1", maintenancelist);
        jsonObject.put("datelist",datelist);
        out.print(jsonObject.toString());
        out.flush();
        out.close();
        //选择显示维修表属性
    }

    //查看未评价回执单
    @ResponseBody
    @RequestMapping(value = "/Stu_seeReformm", method = RequestMethod.GET)
    public void StuReformm(HttpServletRequest request,HttpServletResponse response,HttpSession httpSession) throws IOException{
        System.out.println("查看未评价回执单！");
        //String message = request.getParameter("index");
        String message=httpSession.getAttribute("username").toString();
        List<Maintenance> maintenancelist = maintenanceMapper.selectMaintenanceByStuUsername(message);
        List<Maintenance> maintenancelist1 = new LinkedList();
        List<Maintenance> maintenancelist2 = new LinkedList();

        for (int i=0;i<maintenancelist.size();i++){
            Maintenance maintenance=maintenancelist.get(i);
            if (maintenance.getEstimate_detial()==null){
                maintenancelist1.add(maintenance);
                System.out.println("未评价："+maintenance);
            }
        }
        for (int i=0;i<maintenancelist1.size();i++){
            Maintenance maintenance = maintenancelist1.get(i);
            if (maintenance.getFault_analysis()!=null){
                maintenancelist2.add(maintenance);
                System.out.println("未评价且回执不为空"+maintenance);
            }
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<String> datelist=new LinkedList<String>();
        for(Maintenance getMaintenance:maintenancelist2){
            datelist.add(sdf.format(getMaintenance.getReform_time()));
        }
        response.setHeader("content-type", "text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("mlist3", maintenancelist2);
        jsonObject.put("datelist",datelist);
        out.print(jsonObject.toString());
        out.flush();
        out.close();
    }

    //查看回执单
    @ResponseBody
    @RequestMapping(value = "/Stu_seeReform", method = RequestMethod.GET)
    public void StuReform(HttpServletRequest request,HttpServletResponse response, Model model,HttpSession httpSession) throws IOException {
        System.out.println("查看回执单！");
        String message=httpSession.getAttribute("username").toString();
        //需要传的值为一个String类型的名字，可以取登录名。后面改
        //List<Maintenance> maintenancelist1 = new LinkedList();
        List<Maintenance> maintenancelist2 = maintenanceMapper.selectMaintenanceByStuUsername(message);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<String> datelist=new LinkedList<String>();
        for(Maintenance getMaintenance:maintenancelist2){
            datelist.add(sdf.format(getMaintenance.getReform_time()));
        }
        response.setHeader("content-type", "text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("mlist2", maintenancelist2);
        jsonObject.put("datelist",datelist);
        out.print(jsonObject.toString());
        out.flush();
        out.close();
        //选择显示回执单属性
        //return "StudentView/Stu_reform";
    }

    //评价回执单
    @RequestMapping(value = "/Stu_addComment", method = RequestMethod.POST)
    public void CommentReform(HttpServletRequest request, HttpServletResponse response, Maintenance maintenance, Model model){
        String message = request.getParameter("index");
        String message1 = request.getParameter("index1");
        int lid = Integer.valueOf(message1);
        System.out.println("+++信息："+message+"+++id："+lid);
        maintenance = maintenanceMapper.selectMaintenanceById(lid);
        maintenance.setEstimate_detial(message);
        maintenanceMapper.updateEstimate(maintenance); //插入评价
        System.out.println("存入成功!打印该表格"+maintenance);
    }

    //更新个人信息
    @RequestMapping(value = "/Stu_upStu", method = RequestMethod.POST)
    public void Upstudent(HttpServletRequest request, Student student, Model model,HttpSession httpSession){
        String message=httpSession.getAttribute("username").toString();
        String message1 = request.getParameter("index_name");
        String message2 = request.getParameter("index_flatnum");
        String message3 = request.getParameter("index_dormnum");
        String message4 = request.getParameter("index_telephone");
        String message5 = request.getParameter("index_email");
        //message = "高五";
        //登录名未获取
        System.out.println(message+"++++"+message1);
        student = studentMapper.selectStuByUsername(message);
        student.setName(message1);
        student.setFlatnum(message2);
        student.setDormnum(message3);
        student.setTelephone(message4);
        student.setEmail(message5);
        studentMapper.updateStudent(student);
        System.out.println("更新后学生信息："+student);
    }

    //查看学生个人信息
    @RequestMapping(value = "/Stu_selfInf", method = RequestMethod.GET)
    public void SeStudent(HttpServletRequest request,HttpServletResponse response, Model model ,HttpSession session) throws IOException{
        System.out.println("查看学生信息！");
        String message=session.getAttribute("username").toString();
        System.out.println("获取名字看看："+message);
        //需要传的值为一个String类型的名字，可以取登录名。后面改
        // message = "王八";
        Student student =studentMapper.selectStuByUsername(message);
        System.out.println("hhhh:"+student);
        response.setHeader("content-type", "text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        JSONObject jsonObject = new JSONObject();
        List<Student> list = new LinkedList();
        list.add(student);
        jsonObject.put("list", list);
        out.print(jsonObject);
        //out.print(jsonObject.toString());
        out.flush();
        out.close();
    }
    @RequestMapping(value = "/checkOut")
    public void checkOut(HttpServletResponse response ,HttpSession session) throws Exception{
        session.invalidate();
        response.setHeader("content-type", "text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("checkOut", "true");
        out.print(jsonObject);
        //out.print(jsonObject.toString());
        out.flush();
        out.close();
    }

}
