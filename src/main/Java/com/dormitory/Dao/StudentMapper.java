package com.dormitory.Dao;


import com.dormitory.model.po.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by war on 2017/4/17.
 */

@Repository
public interface StudentMapper {
     Student selectStuById(@Param("id") int id);  //根据id查询学生信息
     Student selectStuByUsername(String username); //根据用户名查询学生信息
     List<Student> selectAllStu();  //查询所有学生
     void insertStudent(Student student);  //插入学生信息
     void deleteStudentById(int id);
     void deleteStudent(String username);  //删除学生信息
     void updateStudent(Student student);  //更新学生信息
     int selectStuIDByUsername(String username);
}
