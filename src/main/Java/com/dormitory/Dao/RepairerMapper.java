package com.dormitory.Dao;


import com.dormitory.model.po.Repairer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by war on 2017/4/17.
 */
@Repository
public interface RepairerMapper {
    Repairer selectRepByid(@Param("") int id);  //根据id号查询维修员
    List<Repairer> selectAllRep();  //查询所有维修员
    Repairer selectByTypeAndState(@Param("repairer_type") String repairer_type, @Param("state") String state);  //根据维修员类型和工作状态查询
    void insertReq(@Param("repairer") Repairer repairer);  //插入维修员信息
    void deleteReq(@Param("") int id);  //删除维修员
    void updateReq(@Param("repairer") Repairer repairer);  //更新维修员信息
}
