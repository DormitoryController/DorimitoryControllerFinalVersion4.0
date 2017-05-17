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

    private Repairer repairerBuffer;

    public Repairer getRepairerBuffer() {
        return repairerBuffer;
    }

    public void setRepairerBuffer(Repairer repairerBuffer) {
        this.repairerBuffer = repairerBuffer;
    }

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
             Repairer repairer=repairerMapper.selectRepById(maintenance.getRepairer_id());
                if(repairer!=null) {
                    repairer.setPassword("");
                    repairerlist.add(repairer);
                }
                else{
                    repairerlist.add(null);
                }
                if(maintenance.getResponse_time()!=null) {
                    dateList.add(sdf.format(maintenance.getResponse_time()));
                }
                else {
                    dateList.add("尚未维修");
                }

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
         Repairer repairer=repairerMapper.selectRepById(maintenance.getRepairer_id());
         if(repairer!=null) {
             repairer.setPassword("");
             replist.add(repairer);
         }
         else
         {
             replist.add(null);
         }
         Student student=studentMapper.selectStuById(maintenance.getStudent_id());
         if(student!=null) {
             student.setPassword("");
             studentList.add(student);
         }
         List<ItemList> itemListList=itemListMapper.selectItemListByMaintenance(maintenaceId);
         for(ItemList itemList:itemListList){
             itemNumList.add(itemList.getItem_num());
             itemNameList.add(itemList.getItem().getName());
         }
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
    @RequestMapping(value = "/checkOut")
    public void checkOut(HttpSession session,HttpServletResponse response)throws Exception{
        session.invalidate();
        JSONObject jsonObject=new JSONObject();
        System.out.println("come here");
        response.setHeader("content-type", "text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        jsonObject.put("checkCode","true");
        out.print(jsonObject.toString());
        out.flush();
        out.close();
    }

}