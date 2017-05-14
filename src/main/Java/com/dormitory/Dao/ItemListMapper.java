package com.dormitory.Dao;

import com.dormitory.model.po.ItemList;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by war on 2017/5/12.
 */
@Repository
public interface ItemListMapper {
    List<ItemList> selectAllItemList();
    void insertItemList(ItemList itemList);
}
