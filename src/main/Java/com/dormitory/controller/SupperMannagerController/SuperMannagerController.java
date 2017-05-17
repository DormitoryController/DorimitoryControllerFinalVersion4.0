package com.dormitory.controller.SupperMannagerController;

import com.dormitory.Dao.CheckcodeMapper;
import com.dormitory.model.po.Repairer;
import com.dormitory.model.po.Student;
import com.dormitory.model.po.Supervisor;
import com.dormitory.model.po.Checkcode;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import com.dormitory.Dao.SupervisorMapper;
import com.dormitory.Dao.StudentMapper;
import com.dormitory.Dao.RepairerMapper;
import java.util.Random;

/**
 * Created by xjtu_ on 2017/5/11.
 */
@RequestMapping(value = "/SuperMannagerController")
@Controller
public class SuperMannagerController {


    @Resource
    private  StudentMapper studentMapper;
    @Resource
    private  RepairerMapper repairerMapper;
    @Resource
    private  SupervisorMapper supervisorMapper;
    @Resource
    private CheckcodeMapper checkcodeMapper;



    @RequestMapping(value ="/")
    public String index(){
        System.out.println("zhuye");
        return "SuperMannagerView/index";
    }

    @RequestMapping(value ="/Student")
    public String Student(){
        return "SuperMannagerView/Student";
    }

    @ResponseBody
    @RequestMapping(value ="/StudentItem")
    public void StudentItem(HttpServletRequest request, HttpServletResponse response)throws Exception {
        int index = Integer.valueOf(request.getParameter("index"));
        List<Student> studentlist = studentMapper.selectAllStu();
        //System.out.println(studentlist);
        //System.out.println(supervisorlist.get(1));
        List<Student> studentrelist = new LinkedList<Student>();
//        List<Student> studentlist = new LinkedList<Student>();
//        List<Student> studentrelist = new LinkedList<Student>();

//        for (long i = 0; i < 52; i++) {
//            Student student = new Student();
//            student.setId(i);
//            student.setName("庞博学生");
//            student.setSex("man");
//            student.setTelephone("13934622766");
//            student.setEmail("163.com");
//            student.setFlatnum("float");
//            student.setDormnum("das");
//            student.setPasswd("mim_ma");
//            studentlist.add(student);
//        }

        for (int i = 0; i < 5; i++) {
            if (index *5 + i < studentlist.size()) {
                studentrelist.add(studentlist.get(index * 5 + i));
            }
        }

        response.setHeader("content-type", "text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("studentlist", studentrelist);
        out.print(jsonObject.toString());
        out.flush();
        out.close();

    }



    @RequestMapping(value ="/Repairer")
    public String Repairer(){
//        System.out.println("Repairer");
        return "SuperMannagerView/Repairer";
    }

    @ResponseBody
    @RequestMapping(value ="/RepairerItem")
    public void RepairerItem(HttpServletRequest request, HttpServletResponse response)throws Exception {
        int index = Integer.valueOf(request.getParameter("index"));
        List<Repairer> repairerlist=repairerMapper.selectAllRep();
        //System.out.println(repairerlist);
        List<Repairer> repairerrelist =new LinkedList<Repairer>();
//        List<Repairer> repairerlist = new LinkedList<Repairer>();
//        List<Repairer> repairerrelist = new LinkedList<Repairer>();

//        for (int i = 0; i < 52; i++) {
//            Repairer repairer = new Repairer();
//            repairer.setId(i);
//            repairer.setName("小池维修师傅");
//            repairer.setPasswd("mim_ma");
//            repairer.setSex("man");
//            repairer.setRepairer_type("维修水电");
//            repairer.setTelephone("13934622766");
//            repairer.setEmail("163.com");
//            repairer.setOfficenum("西青院");
//            repairer.setState("不错");
//            repairerlist.add(repairer);
//        }

        for (int i = 0; i < 5; i++) {
            if (index *5 + i < repairerlist.size()) {
                repairerrelist.add(repairerlist.get(index * 5 + i));
            }
        }

        response.setHeader("content-type", "text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("repairerlist", repairerrelist);
        out.print(jsonObject.toString());
        out.flush();
        out.close();

    }


    @RequestMapping(value ="/Supervisor")
    public String Supervisior(){
//        System.out.println("Supervisor");
        return "SuperMannagerView/Supervisor";
    }

    @ResponseBody
    @RequestMapping(value ="/SupervisorItem")
    public void SupervisorItem(HttpServletRequest request, HttpServletResponse response)throws Exception {
//        System.out.println("p");
        int index = Integer.valueOf(request.getParameter("index"));
        List<Supervisor> supervisorlist = supervisorMapper.selectAllSv();
        //System.out.println(supervisorlist.get(1));
        List<Supervisor> supervisorrelist = new LinkedList<Supervisor>();
        //List<Supervisor> supervisorlist = new LinkedList<Supervisor>();
        //List<Supervisor> supervisorrelist = new LinkedList<Supervisor>();

//        for (int i = 0; i < 52; i++) {
//            Supervisor supervisor = new Supervisor();
//            supervisor.setId(i);
//            supervisor.setName("没有宿管");
//            supervisor.setPasswd("mim_ma");
//            supervisor.setSex("man");
//            supervisor.setTelephone("13934622766");
//            supervisor.setEmail("163.com");
//            supervisor.setOfficenum("西安交通大学宿管");
//            supervisorlist.add(supervisor);
//        }

        for (int i = 0; i < 5; i++) {
            if (index *5 + i < supervisorlist.size()) {
                supervisorrelist.add(supervisorlist.get(index * 5 + i));
            }
        }

        response.setHeader("content-type", "text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("supervisorlist", supervisorrelist);
        out.print(jsonObject.toString());
        out.flush();
        out.close();
    }

    @RequestMapping(value ="/DeleteStudent",method = RequestMethod.POST)
    public void DeleteStudent(HttpServletRequest request, HttpServletResponse response, Model model)throws Exception {
        String sid = request.getParameter("index");
        int id=Integer.valueOf(sid);
        System.out.println(id);
        studentMapper.deleteStudentById(id);

    }


    @RequestMapping(value ="/DeleteRepairer",method = RequestMethod.POST)
    public void DeleteRepairer(HttpServletRequest request, HttpServletResponse response, Model model)throws Exception {
        String sid = request.getParameter("index");
        int id =  Integer.valueOf(sid);
        System.out.println(id);
        repairerMapper.deleteReqById(id);

    }


    @RequestMapping(value ="/DeleteSupervisor",method = RequestMethod.POST)
    public void DeleteSupervisor(HttpServletRequest request, HttpServletResponse response, Model model)throws Exception {
        String sid = request.getParameter("index");
        int id =  Integer.valueOf(sid);
        System.out.println(id);
        supervisorMapper.deleteSupersivorById(id);
    }

    @RequestMapping(value ="/CheckCode")
    public String CheckCode() {
        return "SuperMannagerView/CheckCode";
    }

    @RequestMapping(value ="/CheckCodeItem")
    public void CheckCodeItem( HttpServletRequest request, HttpServletResponse response)throws Exception {

            int studentnum = Integer.valueOf(request.getParameter("Student"));
            int repairernum = Integer.valueOf(request.getParameter("Repaier"));
            int supervisornum = Integer.valueOf(request.getParameter("Supervisor"));
//            System.out.println(studentnum);
//            System.out.println(repairernum);
//            System.out.println(supervisornum);

            String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
            Random random = new Random();


            StringBuffer sb = new StringBuffer();
            for(int i = 0; i < repairernum;i++)
            {
                for (int j = 0; j < 6; j++)
              {
                  int number = random.nextInt(base.length());
                  sb.append(base.charAt(number));
              }
                String s = sb.toString();
                //System.out.println("我是y验证码"+s);
                Checkcode ck = new Checkcode();
                ck.setUser_type("学生");
                ck.setCheckcode(s);
                Checkcode Ack=ck;
                System.out.println("我是对象Ack"+Ack);
                checkcodeMapper.insertCheckcode(Ack);
                sb.delete(0,sb.length());
            }

        StringBuffer sb1 = new StringBuffer();
        for(int i = 0; i < studentnum;i++)
        {
            for (int j = 0; j < 6; j++)
            {
                int number = random.nextInt(base.length());
                sb.append(base.charAt(number));
            }
            String s = sb.toString();
            //System.out.println("我是y验证码"+s);
            Checkcode ck = new Checkcode();
            ck.setUser_type("维修员");
            ck.setCheckcode(s);
            Checkcode Ack=ck;
            System.out.println("我是对象Ack"+Ack);
            checkcodeMapper.insertCheckcode(Ack);
            sb.delete(0,sb.length());
        }


        StringBuffer sb2 = new StringBuffer();
        for(int i = 0; i < supervisornum;i++)
        {
            for (int j = 0; j < 6; j++)
            {
                int number = random.nextInt(base.length());
                sb.append(base.charAt(number));
            }
            String s = sb.toString();
            //System.out.println("我是y验证码"+s);
            Checkcode ck = new Checkcode();
            ck.setUser_type("宿舍管理员");
            ck.setCheckcode(s);
            Checkcode Ack=ck;
            System.out.println("我是对象Ack"+Ack);
            checkcodeMapper.insertCheckcode(Ack);
            sb.delete(0,sb.length());
        }
    }

    @RequestMapping(value ="/StudentCheckCode")
    public String StudentCheckCode() {
        return "SuperMannagerView/StudentCheckCode";
    }

    @ResponseBody
    @RequestMapping(value ="/StudentCheckCodeItem")
    public void StudentCheckCodeItem(HttpServletRequest request, HttpServletResponse response)throws Exception {

        int index = Integer.valueOf(request.getParameter("index"));
        List<Checkcode> student_checkcode_item_list1 = checkcodeMapper.selectCheckcodeWhenRegister("学生");
        List<Checkcode> student_checkcode_item_list = new LinkedList<Checkcode>();

        for (int i = 0; i < 5; i++) {
            if (index *5 + i < student_checkcode_item_list1.size()) {
                student_checkcode_item_list.add(student_checkcode_item_list1.get(index * 5 + i));
            }
        }
        response.setHeader("content-type", "text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("student_checkcode_item_list", student_checkcode_item_list);
        out.print(jsonObject.toString());
        out.flush();
        out.close();

    }


    @RequestMapping(value ="/RepairerCheckCode")
    public String RepairertCheckCode() {
        return "SuperMannagerView/RepairerCheckCode";
    }

    @ResponseBody
    @RequestMapping(value ="/RepairerCheckCodeItem")
    public void RepairerCheckCodeItem(HttpServletRequest request, HttpServletResponse response)throws Exception {
        int index = Integer.valueOf(request.getParameter("index"));
        List<Checkcode> repairer_checkcode_item_list1 = checkcodeMapper.selectCheckcodeWhenRegister("维修员");
        List<Checkcode> repairer_checkcode_item_list = new LinkedList<Checkcode>();

        for (int i = 0; i < 5; i++) {
            if (index *5 + i < repairer_checkcode_item_list1.size()) {
                repairer_checkcode_item_list.add(repairer_checkcode_item_list1.get(index * 5 + i));
            }
        }
        response.setHeader("content-type", "text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("repairer_checkcode_item_list", repairer_checkcode_item_list);
        out.print(jsonObject.toString());
        out.flush();
        out.close();
    }



    @RequestMapping(value ="/SupervisorCheckCode")
    public String SupervisorCheckCode() {
        return "SuperMannagerView/SupervisorCheckCode";
    }

    @ResponseBody
    @RequestMapping(value ="/SupervisorCheckCodeItem")
    public void SupervisorCheckCodeItem(HttpServletRequest request, HttpServletResponse response)throws Exception {
        int index = Integer.valueOf(request.getParameter("index"));
        List<Checkcode> supervisor_checkcode_item_list1 = checkcodeMapper.selectCheckcodeWhenRegister("宿舍管理员");
        List<Checkcode> supervisor_checkcode_item_list = new LinkedList<Checkcode>();

        for (int i = 0; i < 5; i++) {
            if (index *5 + i < supervisor_checkcode_item_list1.size()) {
                supervisor_checkcode_item_list.add(supervisor_checkcode_item_list1.get(index * 5 + i));
            }
        }
        response.setHeader("content-type", "text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("supervisor_checkcode_item_list", supervisor_checkcode_item_list);
        out.print(jsonObject.toString());
        out.flush();
        out.close();
    }


}



