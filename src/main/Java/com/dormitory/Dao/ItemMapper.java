package com.dormitory.Dao;


import com.dormitory.model.po.Item;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by war on 2017/4/18.
 */
@Repository
public interface ItemMapper {
    Item selectItemByName(@Param("name") String name);   //查询设备
    void insertItem(Item item);  //插入设备信息
    void updateItem(@Param("item_name") String item_name, @Param("item_num") int item_num);   //更新仓库
}
