package com.dormitory.test;

import com.dormitory.Dao.SupervisorMapper;
import com.dormitory.model.po.Supervisor;
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
public class SupervisorMapperTest {
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
    public void selectSvById() throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        SupervisorMapper supervisorMapper=sqlSession.getMapper(SupervisorMapper.class);
        Supervisor supervisor=supervisorMapper.selectSvById(1002);
        System.out.println(supervisor);
        sqlSession.close();
    }

    @Test
    public void selectSvByUsername() throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        SupervisorMapper supervisorMapper=sqlSession.getMapper(SupervisorMapper.class);
        Supervisor supervisor=supervisorMapper.selectSvByUsername("许阿姨");
        System.out.println(supervisor);
        sqlSession.close();
    }

    @Test
    public void selectAllSv() throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        SupervisorMapper supervisorMapper=sqlSession.getMapper(SupervisorMapper.class);
        List<Supervisor> list=supervisorMapper.selectAllSv();
        System.out.println(list);
        sqlSession.close();
    }

    @Test
    public void insertSupervisor() throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        SupervisorMapper supervisorMapper=sqlSession.getMapper(SupervisorMapper.class);
        Supervisor supervisor=new Supervisor();
        supervisor.setUsername("ahahah");
        supervisor.setName("哈皮");
        supervisor.setPassword("123");
        supervisor.setOfficenum("公寓楼B座101室");
        supervisorMapper.insertSupervisor(supervisor);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteSupersivor() throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        SupervisorMapper supervisorMapper=sqlSession.getMapper(SupervisorMapper.class);
        supervisorMapper.deleteSupersivor("ahahah");
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateSupersivor() throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        SupervisorMapper supervisorMapper=sqlSession.getMapper(SupervisorMapper.class);
        Supervisor supervisor=new Supervisor();
        supervisor.setUsername("ahaha");
        supervisor.setName("我是哈珀");
        supervisor.setPassword("789");
        supervisorMapper.updateSupersivor(supervisor);
        sqlSession.commit();
        sqlSession.close();
    }

}