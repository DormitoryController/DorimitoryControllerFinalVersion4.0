package com.dormitory.model.vo;

import com.dormitory.model.po.Maintenance;

/**
 * Created by war on 2017/5/17.
 */
public class MaintenanceCustom extends Maintenance {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MaintenanceCustom{" +
                "name='" + name + '\'' +
                '}';
    }
}
