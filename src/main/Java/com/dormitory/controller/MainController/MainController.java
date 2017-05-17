package com.dormitory.controller.MainController;

import com.dormitory.Dao.*;
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
    @Autowired
    private MaintenanceMapper maintenanceMapper;
    @Autowired
    private RepairerMapper repairerMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private ItemListMapper itemListMapper;

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

//    @ResponseBody
//    @RequestMapping(value = "/user")
//    public void user(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        List<User> list = new LinkedList();
//        for (int i = 0; i < 5; i++) {
//            User user = new User();
//            user.setId(5);
//            user.setName("王立");
//            user.setSex("男");
//            list.add(user);
//        }
//        String username = "王立";
//        response.setHeader("content-type", "text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("userlist", list);
//        out.print(jsonObject.toString());
//        out.flush();
//        out.close();
//    }
//
//    @RequestMapping(value = "/test")
//    public String test() {
//        return "MainView/test";
//    }

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
        List<Item> itemlist =itemMapper.selectAllItem();
        List<Item> relist = new LinkedList<Item>();
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
        List<Item> itemslist=itemMapper.selectAllItem();
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
        List<Maintenance> maintenanceslist=maintenanceMapper.selectAllMaintenance();
        int index = Integer.valueOf(request.getParameter("index"));
        List<Repairer> repairerlist=new LinkedList<Repairer>();
        List<String> dateList=new LinkedList<String>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Maintenance maintenance:maintenanceslist){
            repairerlist.add(repairerMapper.selectRepById(maintenance.getRepairer_id()));
            dateList.add(sdf.format(maintenance.getResponse_time()));
        }
        List<Maintenance> reMainList=new LinkedList<Maintenance>();
        List<Repairer> reRepairerList=new LinkedList<Repairer>();
        List<String> reDateList=new LinkedList<String>();
        for (int i = 0; i < 5; i++) {
            if (index * 5 + i < maintenanceslist.size()) {
                reMainList.add(maintenanceslist.get(index * 5 + i));
                reRepairerList.add(repairerlist.get(index*5+i));
                reDateList.add(dateList.get(index*5+i));
            }
        }
            response.setHeader("content-type", "text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("repairerlist", reRepairerList);
            jsonObject.put("maintenanceslist",reMainList);
            jsonObject.put("datelist",reDateList);
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
        Maintenance maintenance=maintenanceMapper.selectMaintenanceById(maintenaceId);
         mainList.add(maintenance);
         replist.add(repairerMapper.selectRepById(maintenance.getRepairer_id()));
         studentList.add(studentMapper.selectStuById(maintenance.getStudent_id()));
         List<ItemList> itemListList=itemListMapper.selectItemListByMaintenance(maintenaceId);
         for(ItemList itemList:itemListList){
             itemNumList.add(itemList.getItem_num());
             itemNameList.add(itemList.getItem().getName());
         }
//         Repairer repairer=new Repairer();
//         repairer.setTelephone("1444444444444444444");
//         repairer.setName("王力");
//         Maintenance maintenance=new Maintenance();
//         maintenance.setFault_detail("马桶坏了sadddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd");
//         maintenance.setFault_analysis("换个马桶dsaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//         replist.add(repairer);
//         mainList.add(maintenance);
//         Student student=new Student();
//         student.setName("王力");
//         student.setDormnum("第二公寓");
//         studentList.add(student);
//         itemNameList.add("龙头");
//         itemNumList.add(1);
//         itemNameList.add("水管");
//         itemNumList.add(8);
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
        String[] numlist=request.getParameterValues("numlist[]");
        String[] itemlist=request.getParameterValues("itemlist[]");
        String[] pricelist=request.getParameterValues("pricelist[]");
        for(int i=0;i<itemlist.length;i++){
            Item items=itemMapper.selectItemByName(itemlist[i]);
            itemMapper.updateItem(itemlist[i],"￥"+pricelist[i],items.getRepertory()+Integer.valueOf(numlist[i]));
        }
    }
    @RequestMapping(value = "/reduceItem")
    public void reduceItrm(HttpServletRequest request, HttpServletResponse response)throws Exception{
        String[] numlist=request.getParameterValues("numlist[]");
        String[] itemlist=request.getParameterValues("itemlist[]");
        for(int i=0;i<itemlist.length;i++){
             Item items=itemMapper.selectItemByName(itemlist[i]);
             if(items.getRepertory()-Integer.valueOf(numlist[i])>0) {
                 itemMapper.updateItem(itemlist[i], items.getPrice(), items.getRepertory() - Integer.valueOf(numlist[i]));
             }
             else {
                 itemMapper.updateItem(itemlist[i], items.getPrice(), 0);
             }
        }
    }

}