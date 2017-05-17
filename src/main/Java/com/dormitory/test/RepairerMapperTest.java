package com.dormitory.test;

import com.dormitory.Dao.RepairerMapper;
import com.dormitory.model.po.Repairer;
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
    public void selectRepByUsername() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        RepairerMapper repairerMapper=sqlSession.getMapper(RepairerMapper.class);
        Repairer repairer=repairerMapper.selectRepByUsername("王师傅");
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
        newRepairer.setUsername("艹");
        newRepairer.setName("草薙剑");
        newRepairer.setPassword("123..");
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
        repairerMapper.deleteReq("艹");
        sqlSession.commit();
        sqlSession.close();
    }

    @org.junit.Test
    public void updateReq() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        RepairerMapper repairerMapper=sqlSession.getMapper(RepairerMapper.class);
        repairerMapper.updateReq("王师傅","上班");
        sqlSession.commit();
        sqlSession.close();
    }

    @org.junit.Test
    public void selectRepByState() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        RepairerMapper repairerMapper=sqlSession.getMapper(RepairerMapper.class);
        List<Repairer> list=repairerMapper.selectRepByState("上班");
        System.out.println(list);
    }

    @Test
    public void selectReqByName() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        RepairerMapper repairerMapper=sqlSession.getMapper(RepairerMapper.class);
        int ID=repairerMapper.selectReqByName("小迟师傅");
        System.out.println(ID);
    }

    @Test
    public void updateReqInfo() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        RepairerMapper repairerMapper=sqlSession.getMapper(RepairerMapper.class);
        Repairer r=new Repairer();
        r.setUsername("王师傅");
        r.setTelephone("18051186770");
        r.setEmail("xiaoshifu@163.com");
        r.setOfficenum("A座413");
        r.setName("王小二");
        r.setPassword("123");
        r.setSex("女");
        repairerMapper.updateReqInfo(r);
        sqlSession.commit();
        sqlSession.close();
    }

}