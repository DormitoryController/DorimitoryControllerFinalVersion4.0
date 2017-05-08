package com.dormitory.test;

import com.dormitory.Dao.SuperAdminMapper;
import com.dormitory.model.po.SuperAdmin;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

/**
 * Created by war on 2017/5/7.
 */
public class SuperAdminMapperTest {
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
    public void selectSuperAdminById() throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        SuperAdminMapper superAdminMapper=sqlSession.getMapper(SuperAdminMapper.class);
        SuperAdmin superAdmin=superAdminMapper.selectSuperAdminById(1034);
        System.out.println(superAdmin);
        sqlSession.close();
    }

    @Test
    public void selectSuperAdminByName() throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        SuperAdminMapper superAdminMapper=sqlSession.getMapper(SuperAdminMapper.class);
        SuperAdmin superAdmin=superAdminMapper.selectSuperAdminByName("赵瑾");
        System.out.println(superAdmin);
        sqlSession.close();
    }

    @Test
    public void insertSuperAdmin() throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        SuperAdminMapper superAdminMapper=sqlSession.getMapper(SuperAdminMapper.class);
        SuperAdmin superAdmin=new SuperAdmin();
        superAdmin.setId(1036);
        superAdmin.setName("孟艳丽");
        superAdmin.setPasswd("123");
        superAdminMapper.insertSuperAdmin(superAdmin);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteSuperAdmin() throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        SuperAdminMapper superAdminMapper=sqlSession.getMapper(SuperAdminMapper.class);
    }

}