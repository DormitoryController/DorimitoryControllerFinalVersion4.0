package com.dormitory.Dao;


import com.dormitory.model.po.Maintenance;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by war on 2017/4/17.
 */
@Repository
public interface MaintenanceMapper {
    Maintenance selectMaintenanceById(int id);  //根据id号查询维修表
    List<Maintenance> selectMaintenanceByStu(String stu_name);  //根据学生名查询维修表
    List<Maintenance> selectMaintenanceByRep(String rep_name);  //根据维修员查询维修表
    List<Maintenance> selectMaintenanceByState(String fault_state);  //根据维修状态查询维修表
    List<Maintenance> selectAllMaintenance();  //查询所有维修表
    void insertReform(Maintenance maintenance);  //增加报修情况
    void updateAllocate(Maintenance maintenance);  //分派维修工作（状态、维修人)
    void updateResponse(Maintenance maintenance);  //插入回执情况
    void updateEstimate(Maintenance maintenance);  //插入评价
    void deleteMaintenance(int id);  //删除维修表
    List<Maintenance> selectReform(String username);  //学生查询维修表
    void updateMaintenanceState(int maintenance_id);           //更新维修状态
    List<Maintenance> selectMaintenanceByStuUsername(String stu_name);  //根据学生名查询维修表

}
