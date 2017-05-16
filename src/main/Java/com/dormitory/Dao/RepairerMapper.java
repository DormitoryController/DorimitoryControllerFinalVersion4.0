package com.dormitory.Dao;


import com.dormitory.model.po.Repairer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepairerMapper {

    Repairer selectRepById(@Param("id") int id);  //根据id号查询维修员
    Repairer selectRepByUsername(@Param("username") String username);
    List<Repairer> selectAllRep();  //查询所有维修员
    List<Repairer> selectByTypeAndState(@Param("repairer_type") String repairer_type, @Param("state") String state);  //根据维修员类型和工作状态查询
    void insertReq(Repairer repairer);  //插入维修员信息
    void deleteReqById(int id);
    void deleteReq(@Param("username") String username);  //删除维修员
    void updateReq(@Param("username") String username,@Param("state") String state);  //更新维修员信息
    List<Repairer> selectRepByState(@Param("repairer_state") String repairer_state);
    int selectReqByName(String name);
    void updateReqInfo(Repairer repairer);  //修改维修员信息
}
