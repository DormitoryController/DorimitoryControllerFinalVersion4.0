package com.dormitory.controller.MainController;

import com.dormitory.Dao.UserDao;
import com.dormitory.model.po.Item;
import com.dormitory.model.po.Maintenance;
import com.dormitory.model.po.Repairer;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dormitory.model.po.User;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
/**
 * Created by 赵嗣瑜 on 2017/4/19.
 */
@RequestMapping(value = "/MainController")
@Controller
public class MainController {
    @Resource
    private UserDao userDao;

    @RequestMapping(value = "/")
    public String index() {
        //测试
        System.out.println(userDao.addUser());
        return "MainView/index";
    }

    @ResponseBody
    @RequestMapping(value = "/user")
    public void user(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        List<User> userlist=userDao.findUser();
//        httpSession.setAttribute("userlist",userlist);
//        System.out.println(userDao.findUser());
//        return "MainView/user";
        System.out.println("come here");
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
        List<Item> itemslist = new LinkedList<Item>();
        Item item = new Item();
        item.setName("螺丝");
        itemslist.add(item);
        Item item1 = new Item();
        item1.setName("龙头");
        itemslist.add(item1);
        Item item2 = new Item();
        item2.setName("点灯");
        itemslist.add(item2);
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
        for (int i = 0; i <10 ; i++) {
            Maintenance maintenance = new Maintenance();
            maintenance.setId(1);
            maintenance.setResponse_time("2014.1.1");
            maintenance.setItem_id(2);
            maintenance.setItem_num(50);
            Repairer repairer = new Repairer();
            repairer.setEmail("99999999");
            repairer.setName("王立");
            repairer.setOfficenum("西十一");
            repairer.setTelephone("114444444");
            maintenanceslist.add(maintenance);
            repairerlist.add(repairer);
            response.setHeader("content-type", "text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("repairerlist", repairerlist);
            jsonObject.put("maintenanceslist",maintenanceslist);
            out.print(jsonObject.toString());
            out.flush();
            out.close();
        }
    }
    @RequestMapping(value = "/maintanancesDetail")
    public String maintanancesDetail(){
        return "/MainView/maintanancesDetail";
    }
}