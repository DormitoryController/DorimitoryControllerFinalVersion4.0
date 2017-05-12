package com.dormitory.test;

import com.dormitory.Dao.StudentMapper;
import com.dormitory.model.po.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * Created by war on 2017/5/7.
 */
public class StudentMapperTest {
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void setUp() throws Exception {
        // 创建sqlSessionFactory

        // mybatis配置文件
        String resource = "mybatis.xml";
        // 得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 创建会话工厂，传入mybatis的配置文件信息
        sqlSessionFactory = new SqlSessionFactoryBuilder()
                .build(inputStream);
    }

    @Test
    public void selectStuById() throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
        Student student=studentMapper.selectStuById(3116370112L);
        System.out.println(student);
        sqlSession.close();
    }

    @Test
    public void selectStuByName() throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
        Student student=studentMapper.selectStuByName("王家辉");
        System.out.println(student);
        sqlSession.close();

    }

    @Test
    public void selectAllStu() throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
        List<Student> list=studentMapper.selectAllStu();
        System.out.println(list);
        sqlSession.close();
    }

    @Test
    public void insertStudent() throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
        Student student=new Student();
        student.setId(3116370114L);
        student.setName("乔治");
        student.setSex("女");
        student.setFlatnum("公寓楼B座");
        student.setDormnum("415室");
        student.setPasswd("123");
        studentMapper.insertStudent(student);
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void deleteStudent() throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
        studentMapper.deleteStudent(3116370114L);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateStudent() throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
        Student student=new Student();
        student.setName("巨根乔");
        student.setFlatnum("在天上");
        student.setId(3116370114L);
        studentMapper.updateStudent(student);
        sqlSession.commit();
        sqlSession.close();
    }

}