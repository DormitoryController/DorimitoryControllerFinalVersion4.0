package com.dormitory.controller.WorkerController;

import com.dormitory.Dao.MaintenanceMapper;
import com.dormitory.Dao.RepairerMapper;
import com.dormitory.Dao.UserDao;
import com.dormitory.controller.MainController.MainController;
import com.dormitory.model.po.Item;
import com.dormitory.model.po.Maintenance;
import com.dormitory.model.po.Repairer;
import com.dormitory.model.po.Student;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
 * Created by Administration on 2017/5/11.
 */
@RequestMapping(value = "/workerHandleController")
@Controller
public class workerHandleController {
    @Resource
    private MaintenanceMapper maintenanceMapper;
    //private Maintenance maintenance;
    //private Repairer repairer;
    @Resource
    private RepairerMapper repairerMapper;
    @RequestMapping(value ="/")
    public String index(){
        return "WorkerView/index";
    }
    @RequestMapping(value = "/workerHandle")
    public String workerHandle(){
        return "WorkerView/workerHandle";
    }
    @RequestMapping(value = "/workerHistory")
    public String workerHistory(){
        return "WorkerView/workerHistory";
    }
    @RequestMapping(value = "/worker1")
    public String workerReply(){
        return "WorkerView/workerReply";
    }
    @RequestMapping(value = "/workerModel2")
    public String workerModel2(){
        return "WorkerView/workerLookPerson";
    }
    @RequestMapping(value = "/workerModel")
    public String workerModel(){
        return "WorkerView/workerModifyPerson";
    }

    //第五个功能修改个人信息
    @RequestMapping(value = "/workerModifyPerson", method = RequestMethod.GET)
    public void workerModifyPerson(HttpServletRequest request, Model model,HttpSession httpSession){
        String message=httpSession.getAttribute("username").toString();
        String message1 = request.getParameter("index_name");
        String message2 = request.getParameter("index_flatnum");
        String message3 = request.getParameter("index_telephone");
        String message4 = request.getParameter("index_email");
        System.out.println(message+"++++"+message1);
        Repairer repairer = repairerMapper.selectRepByUsername(message);
        repairer.setName(message1);
        repairer.setOfficenum(message2);
        repairer.setTelephone(message3);
        repairer.setEmail(message4);
        repairerMapper.updateReqInfo(repairer);
        System.out.println("更新后学生信息："+repairer);
    }




    //第四个功能查看个人信息
    @RequestMapping(value = "/workerLookPerson",method = RequestMethod.GET)
    public void workerLookPerson(HttpServletRequest request, HttpServletResponse response, Model model ,HttpSession session) throws Exception {
        //String message = request.getParameter("index");//查找维修师傅的姓名
        System.out.println("jjjjjj");
        String message=session.getAttribute("username").toString();
        System.out.println("名字为："+message);
        Repairer repairer =repairerMapper.selectRepByUsername(message);
        System.out.println("hhhh:"+repairer);
        response.setHeader("content-type", "text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        JSONObject jsonObject = new JSONObject();
        List<Repairer> list = new LinkedList();
        list.add(repairer);
        jsonObject.put("list1", list);
        out.print(jsonObject);
        //out.print(jsonObject.toString());
        out.flush();
        out.close();
    }

    //第三个功能子功能，添加信息
    @RequestMapping(value = "/detailReply1", method = RequestMethod.POST)
    public void detailReply1(HttpServletRequest request, HttpServletResponse response, Maintenance maintenance, Model model,HttpSession httpSession){
        String message = request.getParameter("index");
        //String message=httpSession.getAttribute("username").toString();
        String message1 = request.getParameter("index1");
        System.out.println("666"+message1);
        String message2 = request.getParameter("index2");
        int lid = Integer.valueOf(message);
        System.out.println("666"+lid);
        maintenance = maintenanceMapper.selectMaintenanceById(lid);
        maintenance.setFault_analysis(message1);
        Date date = new Date();
        maintenance.setResponse_time(date);
        maintenanceMapper.updateResponse(maintenance);
        System.out.println("存入成功!打印该表格"+maintenance);
    }

//第一个功能的子功能
    @RequestMapping(value = "/modify",method = RequestMethod.POST)
    public void modify(HttpServletRequest request, HttpServletResponse response, Model model){
        String sid = request.getParameter("index");
       // System.out.println(sid);
        int id =  Integer.valueOf(sid);
       // System.out.println("yjjyjyjyjy"+id);
        maintenanceMapper.updateMaintenanceState(id);
    }



    //第一个功能
    @ResponseBody
    @RequestMapping(value = "/handle")
    public void item(HttpServletRequest request, HttpServletResponse response,HttpSession httpSession) throws Exception {
        //int index = Integer.valueOf(request.getParameter("index"));//查找维修表的id
        //String message = request.getParameter("index");//查找维修师傅的姓名
        /*List<Maintenance> handlelist = new LinkedList<Maintenance>();*/
        String message=httpSession.getAttribute("username").toString();
        System.out.println("jjjjjj");
        List<Maintenance> handlelist = maintenanceMapper.selectMaintenanceByRep(message);
        List<Maintenance> relist = new LinkedList<Maintenance>();
        System.out.println("555"+handlelist);
       /* for (int i = 0; i < 52; i++) {
            Maintenance maintenance=new Maintenance();
            maintenance.setId(i);
            maintenance.setFault_type("水龙头");
            maintenance.setFault_detail("水龙头坏了");
            maintenance.setFault_location("1号宿舍楼");
            handlelist.add(maintenance);
        }*/
        for (int i=0;i<handlelist.size();i++){
            Maintenance maintenance=handlelist.get(i);
            System.out.println("000000"+maintenance);
            if (maintenance.getFault_state().equals("未修复")){
                relist.add(maintenance);
                System.out.println("111未修复："+relist);
            }
        }

     /*   for (int i = 0; i < 5; i++) {
            if (index * 5 + i < handlelist.size()) {
                relist.add(handlelist.get(index * 5 + i));
            }
        }*/
        response.setHeader("content-type", "text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("handlelist", relist);
        out.print(jsonObject.toString());
        out.flush();
        out.close();
    }


    //第二个功能
    @ResponseBody
    @RequestMapping(value = "/history")
    public void item1(HttpServletRequest request, HttpServletResponse response, HttpSession httpSession) throws Exception {
        //String message = request.getParameter("index");//查找维修师傅的姓名
        String message=httpSession.getAttribute("username").toString();
        System.out.println("jjjjjj");
        List<Maintenance> handlelist1 = maintenanceMapper.selectMaintenanceByRep(message);
        List<Maintenance> relist1 = new LinkedList<Maintenance>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<String> datelist=new LinkedList<String>();
        for (int i=0;i<handlelist1.size();i++){
            Maintenance maintenance=handlelist1.get(i);
            System.out.println("000000"+maintenance);
            if (maintenance.getFault_state().equals("修复")){
                datelist.add(sdf.format(maintenance.getReform_time()));
                relist1.add(maintenance);
                System.out.println("111未修复："+relist1);
            }
        }
     /*   for (int i = 0; i < 5; i++) {
            if (index * 5 + i < handlelist1.size()) {
                relist1.add(handlelist1.get(index * 5 + i));
            }
        }*/
        response.setHeader("content-type", "text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("handlelist1", relist1);
        jsonObject.put("datelist",datelist);
        out.print(jsonObject.toString());
        out.flush();
        out.close();
    }


    //第三个功能
    @ResponseBody
    @RequestMapping(value = "/reply")
    public void item2(HttpServletRequest request, HttpServletResponse response,HttpSession httpSession) throws Exception {
        //int index = Integer.valueOf(request.getParameter("index"));
        //String message = request.getParameter("index1");//查找维修师傅的姓名
        String message=httpSession.getAttribute("username").toString();
        System.out.println("jjjjjj");
        List<Maintenance> handlelist = maintenanceMapper.selectMaintenanceByRep(message);
        System.out.println("999"+handlelist);
                //List<Maintenance> handlelist = maintenanceMapper.selectMaintenanceByState("修复");
        /*List<Maintenance> handlelist = new LinkedList<Maintenance>();*/
        List<Maintenance> relist = new LinkedList();
        //List<Maintenance> relist1 = new LinkedList<Maintenance>();
        /*for (int i = 0; i < 52; i++) {
            Maintenance maintenance=new Maintenance();
            maintenance.setId(i);
            //maintenance.setItem_id(73121);
            maintenance.setFault_state("填写回执单");
            handlelist.add(maintenance);
        }*/
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<String> datelist=new LinkedList<String>();
        for (int i=0;i<handlelist.size();i++) {
            Maintenance maintenance = handlelist.get(i);
            if (maintenance.getFault_analysis()==null && maintenance.getFault_state().equals("修复")) {
                String mydate=sdf.format(maintenance.getReform_time());
                datelist.add(mydate);
                    relist.add(maintenance);
                    System.out.println("未评价：" + relist);
                }
            }

/*        for (int i = 0; i < 5; i++) {
            if (index * 5 + i < relist.size()) {
                relist.add(relist.get(index * 5 + i));
            }
        }*/
        response.setHeader("content-type", "text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("handlelist", relist);
        jsonObject.put("datelist",datelist);
        out.print(jsonObject.toString());
        out.flush();
        out.close();
    }
}
