package com.dormitory.test;

import com.dormitory.Dao.CheckcodeMapper;
import com.dormitory.model.po.Checkcode;
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
public class CheckcodeMapperTest {
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
    public void selectCheckcodeById() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CheckcodeMapper checkcodeMapper=sqlSession.getMapper(CheckcodeMapper.class);
        Checkcode checkcode=checkcodeMapper.selectCheckcodeById(1034);
        System.out.println(checkcode);

    }

}