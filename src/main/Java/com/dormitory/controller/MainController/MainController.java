package com.dormitory.controller.MainController;

import com.dormitory.Dao.ItemMapper;
import com.dormitory.Dao.UserDao;
import com.dormitory.model.po.*;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
/**
 * Created by 赵嗣瑜 on 2017/4/19.
 */
@RequestMapping(value = "/MainController")
@Controller
public class MainController {

    private int maintenaceId=0;
    @Autowired
    private ItemMapper itemMapper;

    public int getMaintenaceId() {
        return maintenaceId;
    }

    public void setMaintenaceId(int maintenaceId) {
        this.maintenaceId = maintenaceId;
    }

    @RequestMapping(value = "/")
    public String index() {
        return "MainView/index";
    }

    @ResponseBody
    @RequestMapping(value = "/user")
    public void user(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<User> list = new LinkedList();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setId(5);
            user.setName("王立");
            user.setSex("男");
            list.add(user);
        }
        String username = "王立";
        response.setHeader("content-type", "text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userlist", list);
        out.print(jsonObject.toString());
        out.flush();
        out.close();
    }

    @RequestMapping(value = "/test")
    public String test() {
        return "MainView/test";
    }

    @RequestMapping(value = "/repositoryTable")
    public String repositoryTable() {
        return "MainView/repositoryTable";
    }
    @RequestMapping(value = "/repositoryTableReducing")
    public String repositoryTableReducing() {
        return "MainView/repositoryTableReducing";
    }

    @RequestMapping(value = "/repositoryControl")
    public String repositoryControl() {
        return "MainView/repositoryControl";
    }

    @RequestMapping(value = "/repositoryInfo")
    public String repositoryInfo() {
        return "MainView/repositoryInfo";
    }

    @ResponseBody
    @RequestMapping(value = "/item")
    public void item(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int index = Integer.valueOf(request.getParameter("index"));
        List<Item> itemlist = new LinkedList<Item>();
        List<Item> relist = new LinkedList<Item>();
        for (int i = 0; i < 52; i++) {
            Item item = new Item();
            item.setId(i);
            item.setName("螺丝");
            item.setPrice("五元");
            item.setRepertory(10);
            itemlist.add(item);
        }
        for (int i = 0; i < 5; i++) {
            if (index * 5 + i < itemlist.size()) {
                relist.add(itemlist.get(index * 5 + i));
            }
        }

        response.setHeader("content-type", "text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("itemlist", relist);
        out.print(jsonObject.toString());
        out.flush();
        out.close();
    }

    @ResponseBody
    @RequestMapping(value = "/repositoryItem")
    public void repositoryItem(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        List<Item> itemslist = new LinkedList<Item>();
//        Item item = new Item();
//        item.setName("螺丝");
//        item.setPrice("99");
//        itemslist.add(item);
//        Item item1 = new Item();
//        item1.setPrice("11");
//        item1.setName("龙头");
//        itemslist.add(item1);
//        Item item2 = new Item();
//        item.setPrice("55");
//        item2.setName("点灯");
//        itemslist.add(item2);
        List<Item> itemslist=itemMapper.
        response.setHeader("content-type", "text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("itemlist", itemslist);
        out.print(jsonObject.toString());
        out.flush();
        out.close();
    }

    @ResponseBody
    @RequestMapping(value = "/itemSubmit")
    public void itemSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {

    }
    @RequestMapping(value = "/reword")
    public String reword(){
        return "/MainView/reword";
    }
    @RequestMapping(value = "/checkReword")
    public void checkReword(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Maintenance> maintenanceslist=new LinkedList<Maintenance>();
        List<Repairer> repairerlist=new LinkedList<Repairer>();
        int index = Integer.valueOf(request.getParameter("index"));
        Date date=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String mydate = sdf.format(date);
        for (int i = 0; i <50 ; i++) {
            Maintenance maintenance = new Maintenance();
            maintenance.setId(i);
            maintenance.setResponse_time(date);
            Repairer repairer = new Repairer();
            repairer.setEmail("99999999");
            repairer.setName("王立");
            repairer.setOfficenum("西十一");
            repairer.setTelephone("114444444");
            maintenanceslist.add(maintenance);
            repairerlist.add(repairer);
        }
        List<Maintenance> reMainList=new LinkedList<Maintenance>();
        List<Repairer> reRepairerList=new LinkedList<Repairer>();
        for (int i = 0; i < 5; i++) {
            if (index * 5 + i < maintenanceslist.size()) {
                reMainList.add(maintenanceslist.get(index * 5 + i));
                reRepairerList.add(repairerlist.get(index*5+i));
                System.out.println(index*5+i);
            }
        }
            response.setHeader("content-type", "text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("repairerlist", reRepairerList);
            jsonObject.put("maintenanceslist",reMainList);
            jsonObject.put("date",mydate);
            out.print(jsonObject.toString());
            out.flush();
            out.close();

    }
    @RequestMapping(value = "/maintanancesDetail")
    public String maintanancesDetail(){
        return "/MainView/maintanancesDetail";
    }
    @RequestMapping(value = "/maintanancesIdSet")
    public void maintanancesIdSet(HttpServletRequest request, HttpServletResponse response){
        this.setMaintenaceId(Integer.valueOf(request.getParameter("maintananceId")));
    }
    @RequestMapping(value = "/maitanancesInfoGet")
    public void maintanancesInfoGet(HttpServletRequest request, HttpServletResponse response)throws Exception{
         JSONObject jsonObject=new JSONObject();
         List<Repairer> replist=new LinkedList<Repairer>();
         List<Maintenance> mainList=new LinkedList<Maintenance>();
         List<Student> studentList=new LinkedList<Student>();
         List<String> itemNameList=new LinkedList<String>();
         List<Integer> itemNumList=new LinkedList<Integer>();
         Repairer repairer=new Repairer();
         repairer.setTelephone("1444444444444444444");
         repairer.setName("王力");
         Maintenance maintenance=new Maintenance();
         maintenance.setFault_detail("马桶坏了sadddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd");
         maintenance.setFault_analysis("换个马桶dsaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
         replist.add(repairer);
         mainList.add(maintenance);
         Student student=new Student();
         student.setName("王力");
         student.setDormnum("第二公寓");
         studentList.add(student);
         itemNameList.add("龙头");
         itemNumList.add(1);
         itemNameList.add("水管");
         itemNumList.add(8);
        jsonObject.put("maintenanceId",maintenaceId);
         jsonObject.put("replist",replist);
         jsonObject.put("mainlist",mainList);
         jsonObject.put("stulist",studentList);
         jsonObject.put("itemNameList",itemNameList);
         jsonObject.put("itemNumList",itemNumList);
        response.setHeader("content-type", "text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(jsonObject.toString());
        out.flush();
        out.close();
    }
    @RequestMapping(value = "/addItem")
    public void addItrm(HttpServletRequest request, HttpServletResponse response)throws Exception{
        String[] pricelist=request.getParameterValues("pricelist[]");
        for(String price:pricelist){
            System.out.println(price);
        }
    }
    @RequestMapping(value = "/reduceItem")
    public void reduceItrm(HttpServletRequest request, HttpServletResponse response)throws Exception{
        String[] numlist=request.getParameterValues("numlist[]");
        for(String num:numlist){
            System.out.println(num);
        }
    }

}