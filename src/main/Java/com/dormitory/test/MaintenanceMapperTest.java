package com.dormitory.test;

import com.dormitory.Dao.MaintenanceMapper;
import com.dormitory.model.po.Maintenance;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * Created by war on 2017/5/7.
 */
public class MaintenanceMapperTest {
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
    public void selectMaintenanceById() throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        MaintenanceMapper maintenanceMapper=sqlSession.getMapper(MaintenanceMapper.class);
        Maintenance maintenance=maintenanceMapper.selectMaintenanceById(1);
        System.out.println(maintenance);
        sqlSession.close();

    }

    @Test
    public void selectMaintenanceByStu() throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        MaintenanceMapper maintenanceMapper=sqlSession.getMapper(MaintenanceMapper.class);
        List<Maintenance> list=maintenanceMapper.selectMaintenanceByStu("王八");
        System.out.println(list);
        sqlSession.close();
    }

    @Test
    public void selectMaintenanceByRep() throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        MaintenanceMapper maintenanceMapper=sqlSession.getMapper(MaintenanceMapper.class);
        List<Maintenance> list=maintenanceMapper.selectMaintenanceByRep("小迟师傅");
        System.out.println(list);
        sqlSession.close();
    }

    @Test
    public void selectMaintenanceByState() throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        MaintenanceMapper maintenanceMapper=sqlSession.getMapper(MaintenanceMapper.class);
        List<Maintenance> list=maintenanceMapper.selectMaintenanceByState("修复");
        System.out.print(list);
        sqlSession.close();
    }

    @Test
    public void selectAllMaintenance() throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        MaintenanceMapper maintenanceMapper=sqlSession.getMapper(MaintenanceMapper.class);
        List<Maintenance> list=maintenanceMapper.selectAllMaintenance();
        System.out.println(list);
        sqlSession.close();
    }

    @Test
    public void insertReform() throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        MaintenanceMapper maintenanceMapper=sqlSession.getMapper(MaintenanceMapper.class);
        Maintenance maintenance=new Maintenance();
        maintenance.setStudent_id(3116370112L);
        maintenance.setFault_type("热水器故障");
        maintenance.setFault_detail("淋浴头出现裂缝，疯狂喷水");
        Date date=new Date();
        maintenance.setReform_time(date);
        maintenance.setFault_location("公寓楼B座413室");
        maintenanceMapper.insertReform(maintenance);
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void updateAllocate() throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        MaintenanceMapper maintenanceMapper=sqlSession.getMapper(MaintenanceMapper.class);
        Maintenance maintenance=new Maintenance();
        maintenance.setSupervisor_id(1002);
        maintenance.setRepairer_id(103);
        maintenance.setRepairer_type("水工");
        maintenance.setId(5);
        maintenance.setFault_state("已审核");
        maintenanceMapper.updateAllocate(maintenance);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateResponse() throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        MaintenanceMapper maintenanceMapper=sqlSession.getMapper(MaintenanceMapper.class);
        Maintenance maintenance=new Maintenance();
        maintenance.setFault_analysis("淋浴头质量问题");
        maintenance.setFault_state("修复");
        maintenance.setItem_id(2);
        maintenance.setItem_num(1);
        maintenance.setId(5);
        Date date=new Date();
        maintenance.setResponse_time(date);
        maintenanceMapper.updateResponse(maintenance);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateEstimate() throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        MaintenanceMapper maintenanceMapper=sqlSession.getMapper(MaintenanceMapper.class);
        Maintenance maintenance=new Maintenance();
        maintenance.setId(5);
        maintenance.setEstimate_rate(4.5F);
        maintenance.setEstimate_detial("还可以");
        maintenanceMapper.updateEstimate(maintenance);
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void deleteMaintenance() throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        MaintenanceMapper maintenanceMapper=sqlSession.getMapper(MaintenanceMapper.class);
    }

}