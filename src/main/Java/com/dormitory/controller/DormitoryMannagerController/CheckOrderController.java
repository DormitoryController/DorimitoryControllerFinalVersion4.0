package com.dormitory.controller.DormitoryMannagerController;

import com.dormitory.Dao.MaintenanceMapper;
import com.dormitory.Dao.RepairerMapper;
import com.dormitory.model.po.Maintenance;
import com.dormitory.model.vo.MaintenanceCustom;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lph on 2017/4/20.
 */

//查询维修单并审核,修改
@RequestMapping(value = "/DormManage")
@Controller
public class CheckOrderController {
    @Autowired
    private MaintenanceMapper maintenanceMapper;
    @Autowired
    private RepairerMapper repairerMapper;

    @RequestMapping(value = "/")
    public String entrance() throws Exception {
        return "DMView/entrance";
    }

    @RequestMapping(value = "/maintenanceControl")
    public String maintenanceControl() throws Exception {
        return "DMView/maintenanceControl";
    }

    //查询,修改维修单
    @RequestMapping(value = "/queryMaintenance")
    public String queryMaintenance() throws Exception {
        return "DMView/queryMaintenance";
    }

    @ResponseBody
    @RequestMapping(value = "/maintenanceItems")
    public void maintenanceItems(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<MaintenanceCustom> maintenanceList = maintenanceMapper.selectMaintenanceByState("待审核");

        //时间格式转换
        List<String> dateList = new LinkedList<String>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < maintenanceList.size(); i++) {
            Date date = maintenanceList.get(i).getReform_time();
            String tdate = sdf.format(date);
            dateList.add(tdate);
        }

        response.setHeader("content-type", "text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("maintenanceList", maintenanceList1);
        jsonObject.put("maintenanceList", maintenanceList);
        jsonObject.put("dateList", dateList);
        out.print(jsonObject.toString());
        out.flush();
        out.close();
    }

    @ResponseBody
    @RequestMapping(value = "/maintenanceSubmit")
    //下发（提交）维修单
    public void maintenanceSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        String repairerName = request.getParameter("name");
        Maintenance maintenance = maintenanceMapper.selectMaintenanceById(id);
        System.out.println("维修表id:" + id + ";维修员:" + repairerName);
        maintenance.setId(id);
        maintenance.setFault_state(request.getParameter("fault_state"));
        maintenance.setRepairer_id(repairerMapper.selectReqByName(repairerName));
        maintenanceMapper.updateAllocate(maintenance);
    }

    //审核不通过，删除维修单
    @ResponseBody
    @RequestMapping(value = "/maintenanceDelete")
    public void maintenanceDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        maintenanceMapper.deleteMaintenance(id);
    }
}
