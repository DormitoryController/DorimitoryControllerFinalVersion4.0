package com.dormitory.test;

import com.dormitory.Dao.ItemListMapper;
import com.dormitory.model.po.ItemList;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by war on 2017/5/12.
 */
public class ItemListMapperTest {

    private ApplicationContext applicationContext;

    @Before
    public void setUp() throws Exception {
        applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void selectAllItemList() throws Exception {
            ItemListMapper itemListMapper=(ItemListMapper) applicationContext.getBean("itemListMapper");
            List<ItemList> lists=itemListMapper.selectAllItemList();
            System.out.println(lists);
            System.out.println(lists.size());
    }

    @Test
    public void insertItemList() throws Exception {
        ItemListMapper itemListMapper=(ItemListMapper) applicationContext.getBean("itemListMapper");
        ItemList itemList=new ItemList();
        itemList.setMaintenance_id(4);
        itemList.setItem_id(11);
        itemList.setItem_num(1);
        itemListMapper.insertItemList(itemList);
    }

    @Test
    public void selectItemListByMaintenance() throws Exception {
        ItemListMapper itemListMapper=(ItemListMapper) applicationContext.getBean("itemListMapper");
        List<ItemList> lists=itemListMapper.selectItemListByMaintenance(3);
        System.out.println(lists);
        System.out.println(lists.size());
    }


}