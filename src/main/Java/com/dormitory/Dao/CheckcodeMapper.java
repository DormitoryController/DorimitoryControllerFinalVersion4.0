package com.dormitory.Dao;

import com.dormitory.model.po.Checkcode;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by war on 2017/4/17.
 */
@Repository
public interface CheckcodeMapper {
    Checkcode selectCheckcodeById(int id);  //查询验证码
    List<Checkcode> selectCheckcodeWhenRegister(String user_type);       //注册时根据用户类别查询验证码
    void updateCheckcodeState(@Param("id") int id,@Param("use_state") String use_state);    //修改验证码使用状态
    void insertCheckcode(Checkcode checkcode);             //插入验证码
    List<Checkcode> selectCheckcodeByStateAndUserType(@Param("user_type") String user_type); //修改密码时根据用户类型及邀请码使用状态查询
}
