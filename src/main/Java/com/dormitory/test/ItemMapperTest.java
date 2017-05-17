package com.dormitory.test;

import com.dormitory.Dao.ItemMapper;
import com.dormitory.model.po.Item;
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
public class ItemMapperTest {
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
    public void selectItemByName() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ItemMapper itemMapper=sqlSession.getMapper(ItemMapper.class);
        Item item=itemMapper.selectItemByName("水龙头");
        System.out.println(item);

    }

    @Test
    public void insertItem() throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        ItemMapper itemMapper=sqlSession.getMapper(ItemMapper.class);
        Item item=new Item();
        item.setName("座椅");
        item.setRepertory(20);
        item.setPrice("¥50.0");
        itemMapper.insertItem(item);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateItem() throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        ItemMapper itemMapper=sqlSession.getMapper(ItemMapper.class);
        itemMapper.updateItem("水龙头",2);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectAllItem() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ItemMapper itemMapper=sqlSession.getMapper(ItemMapper.class);
        List<Item> item=itemMapper.selectAllItem();
        System.out.println(item);

    }

}