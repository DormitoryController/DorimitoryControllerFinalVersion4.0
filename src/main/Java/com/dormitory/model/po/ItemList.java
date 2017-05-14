package com.dormitory.model.po;

/**
 * Created by war on 2017/5/12.
 */
public class ItemList {
    private int id;
    private int maintenance_id;
    private int item_id;
    private int item_num;

    public ItemList() {
    }

    public ItemList(int id, int maintenance_id, int item_id, int item_num) {
        this.id = id;
        this.maintenance_id = maintenance_id;
        this.item_id = item_id;
        this.item_num = item_num;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaintenance_id() {
        return maintenance_id;
    }

    public void setMaintenance_id(int maintenance_id) {
        this.maintenance_id = maintenance_id;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getItem_num() {
        return item_num;
    }

    public void setItem_num(int item_num) {
        this.item_num = item_num;
    }

    @Override
    public String toString() {
        return "ItemList{" +
                "id=" + id +
                ", maintenance_id=" + maintenance_id +
                ", item_id=" + item_id +
                ", item_num=" + item_num +
                '}';
    }
}
