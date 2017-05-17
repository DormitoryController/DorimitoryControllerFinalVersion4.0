package com.dormitory.controller.DormitoryMannagerController;

import com.dormitory.Dao.RepairerMapper;
import com.dormitory.model.po.Repairer;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by lph on 2017/4/20.
 */
//查询维修员信息
@RequestMapping(value = "/DormManage")
@Controller
public class QueryStaffController {
    @Autowired
    private RepairerMapper repairerMapper;

    //查询维修员
    @RequestMapping(value = "/queryRepairer")
    public String queryRepairer() throws Exception {
        return "DMView/queryRepairer";
    }

    @ResponseBody
    @RequestMapping(value = "/repairerItems")
    public void repairerItems(HttpServletRequest request, HttpServletResponse response) throws Exception {
/*        //测试
        int index = Integer.valueOf(request.getParameter("index"));
        List<Repairer> repairerList = new LinkedList<Repairer>();
        List<Repairer> repairerList1 = new LinkedList<Repairer>();
        for (int i = 0; i < 21; i++) {
            Repairer repairer = new Repairer();
            repairer.setId(i);
            repairer.setRepairer_type("水工");
            repairer.setState("在职");
            repairerList.add(repairer);
        }
        for (int i = 0; i < 5; i++) {
            if (index * 5 + i < repairerList.size()) {
                repairerList1.add(repairerList.get(index * 5 + i));
            }
        }
*/
        List<Repairer> repairerList = repairerMapper.selectRepByState("上班");
        response.setHeader("content-type", "text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("repairerList", repairerList1);
        jsonObject.put("repairerList", repairerList);
        out.print(jsonObject.toString());
        out.flush();
        out.close();
    }
}

