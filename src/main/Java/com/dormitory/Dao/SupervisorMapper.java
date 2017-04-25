package com.dormitory.Dao;


import com.dormitory.model.po.Supervisor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by war on 2017/4/17.
 */
@Repository
public interface SupervisorMapper {
    Supervisor selectSvById(@Param("id") int id);  //根据id查询宿管信息
    List<Supervisor> selectAllSv();  //查询所有宿管
    void insertSupervisor(@Param("supersivor") Supervisor supersiovor);  //增加宿管
    void deleteSupersivor(@Param("id") int id);  //删除宿管
    void updateSupersivor(@Param("supersivor") Supervisor supersivor);  //更新宿管
}
