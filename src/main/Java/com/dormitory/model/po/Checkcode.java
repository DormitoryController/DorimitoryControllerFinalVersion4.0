package com.dormitory.model.po;

/**
 * Created by war on 2017/4/17.
 */
public class Checkcode {
    private int id;
    private String checkcode;

    public Checkcode() {
    }

    public Checkcode(int id, String checkcode) {
        this.id = id;
        this.checkcode = checkcode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCheckcode() {
        return checkcode;
    }

    public void setCheckcode(String checkcode) {
        this.checkcode = checkcode;
    }

    @Override
    public String toString() {
        return "Checkcode{" +
                "id=" + id +
                ", checkcode='" + checkcode + '\'' +
                '}';
    }
}
