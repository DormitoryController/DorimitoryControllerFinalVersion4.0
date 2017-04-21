package com.dormitory.controller.MainController;

import com.dormitory.Dao.UserDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dormitory.model.po.User;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by 赵嗣瑜 on 2017/4/19.
 */
@Controller
public class MainController {
    @Resource
    private UserDao userDao;
    @RequestMapping(value ="/")
    public String index(){
        System.out.println(userDao.addUser());
        return "MainView/index";
    }
    @RequestMapping(value = "/user")
    public String user(HttpSession httpSession){
        List<User> userlist=userDao.findUser();
        httpSession.setAttribute("userlist",userlist);
        System.out.println(userDao.findUser());
        return "MainView/user";
    }
    @RequestMapping(value ="/test" )
    public String test(){
        return "MainView/test";
    }
}
