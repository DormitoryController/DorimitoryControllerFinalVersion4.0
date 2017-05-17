package com.dormitory.test;

import com.dormitory.Dao.CheckcodeMapper;
import com.dormitory.model.po.Checkcode;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.InputStream;
import java.util.List;

/**
 * Created by war on 2017/5/7.
 */
public class CheckcodeMapperTest {
    private SqlSessionFactory sqlSessionFactory;
    private ApplicationContext applicationContext;

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
        applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void selectCheckcodeById() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CheckcodeMapper checkcodeMapper=sqlSession.getMapper(CheckcodeMapper.class);
        Checkcode checkcode=checkcodeMapper.selectCheckcodeById(1);
        System.out.println(checkcode);

    }

    @Test
    public void selectAllCheckcode() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CheckcodeMapper checkcodeMapper=sqlSession.getMapper(CheckcodeMapper.class);
        List<Checkcode> checkcode=checkcodeMapper.selectAllCheckcode();
        System.out.println(checkcode);

    }

    @Test
    public void selectCheckcodeWhenRegister() throws Exception {
       CheckcodeMapper checkcodeMapper=(CheckcodeMapper) applicationContext.getBean("checkcodeMapper");
       List<Checkcode>  list=checkcodeMapper.selectCheckcodeWhenRegister("学生");
        System.out.println(list);
        System.out.println(list.size());
    }

    @Test
    public void updateCheckcodeState() throws Exception {
        CheckcodeMapper checkcodeMapper=(CheckcodeMapper) applicationContext.getBean("checkcodeMapper");
        checkcodeMapper.updateCheckcodeState(1,"1");

    }

    @Test
    public void updateCheckcode() throws Exception {
        CheckcodeMapper checkcodeMapper=(CheckcodeMapper) applicationContext.getBean("checkcodeMapper");

        //checkcodeMapper.updateCheckcode("1S2T",3116770113L);

    }

    @Test
    public void insertCheckcode() throws Exception {
        CheckcodeMapper checkcodeMapper=(CheckcodeMapper) applicationContext.getBean("checkcodeMapper");
        Checkcode checkcode=new Checkcode();
        checkcode.setCheckcode("6542");
        checkcode.setUser_type("学生");
        checkcodeMapper.insertCheckcode(checkcode);

    }

    @Test
    public void selectCheckcodeByStateAndUserType() throws Exception {
        CheckcodeMapper checkcodeMapper=(CheckcodeMapper) applicationContext.getBean("checkcodeMapper");
        List<Checkcode> list=checkcodeMapper.selectCheckcodeByStateAndUserType("学生");
        System.out.println(list);
        System.out.println(list.size());
    }

}