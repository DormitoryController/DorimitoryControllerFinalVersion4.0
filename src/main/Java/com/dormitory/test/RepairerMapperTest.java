package com.dormitory.test;

import com.dormitory.Dao.RepairerMapper;
import com.dormitory.model.po.Repairer;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;

import java.io.InputStream;
import java.util.List;

/**
 * Created by war on 2017/5/7.
 */
public class RepairerMapperTest {

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
    @org.junit.Test
    public void selectRepById() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        RepairerMapper repairerMapper=sqlSession.getMapper(RepairerMapper.class);
        Repairer repairer=repairerMapper.selectRepById(102);
        System.out.println(repairer);
    }

    @org.junit.Test
    public void selectRepByName() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        RepairerMapper repairerMapper=sqlSession.getMapper(RepairerMapper.class);
        Repairer repairer=repairerMapper.selectRepByName("王师傅");
        System.out.println(repairer);
    }

    @org.junit.Test
    public void selectAllRep() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        RepairerMapper repairerMapper=sqlSession.getMapper(RepairerMapper.class);
        List<Repairer> list=repairerMapper.selectAllRep();
        System.out.println(list);
    }

    @org.junit.Test
    public void selectByTypeAndState() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        RepairerMapper repairerMapper=sqlSession.getMapper(RepairerMapper.class);
        List<Repairer> list=repairerMapper.selectByTypeAndState("火工","上班");
        System.out.println(list);
    }

    @org.junit.Test
    public void insertReq() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        RepairerMapper repairerMapper=sqlSession.getMapper(RepairerMapper.class);
        Repairer newRepairer=new Repairer();
        newRepairer.setId(107);
        newRepairer.setName("草薙剑");
        newRepairer.setPasswd("123..");
        newRepairer.setOfficenum("A座201室");
        newRepairer.setRepairer_type("火工");
        newRepairer.setEmail("caolijian@sina.com");
        newRepairer.setSex("男");
        newRepairer.setTelephone("13626136087");
        newRepairer.setState("上班");
        repairerMapper.insertReq(newRepairer);
        sqlSession.commit();
        sqlSession.close();
    }

    @org.junit.Test
    public void deleteReq() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        RepairerMapper repairerMapper=sqlSession.getMapper(RepairerMapper.class);
        repairerMapper.deleteReq(106);
        sqlSession.commit();
        sqlSession.close();
    }

    @org.junit.Test
    public void updateReq() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        RepairerMapper repairerMapper=sqlSession.getMapper(RepairerMapper.class);
        repairerMapper.updateReq(102,"上班");
        sqlSession.commit();
        sqlSession.close();
    }

}