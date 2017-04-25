package com.dormitory.Dao;


import com.dormitory.model.po.Maintenance;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by war on 2017/4/17.
 */
@Repository
public interface MaintenanceMapper {
    Maintenance selectMaintenanceById(@Param("id") int id);  //根据id号查询维修表
    Maintenance selectMaintenanceByStu(@Param("stu_name") String stu_name);  //根据学生名查询维修表
    Maintenance selectMaintenanceByRep(@Param("rep_name") String rep_name);  //根据维修员查询维修表
    List<Maintenance> selectAllMaintenance();  //查询所有维修表
    void insertReform(@Param("maintenance") Maintenance maintenance);  //插入保修单
    void updateAllocate(@Param("maintenance") Maintenance maintenance);  //分派维修工作
    void updateResponse(@Param("maintenance") Maintenance maintenance);  //插入回执单
    void updateEstimate(@Param("maintenance") Maintenance maintenance);  //插入评价
    void deleteMaintenance(@Param("id") int id);  //删除维修表
}
