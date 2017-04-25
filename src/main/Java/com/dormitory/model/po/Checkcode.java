package com.dormitory.model.po;

/**
 * Created by war on 2017/4/17.
 */
public class Checkcode {
    private int id;
    private int check_id;
    private int checkcode;

    public Checkcode() {
    }

    public Checkcode(int id, int check_id, int checkcode) {
        this.id = id;
        this.check_id = check_id;
        this.checkcode = checkcode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCheck_id() {
        return check_id;
    }

    public void setCheck_id(int check_id) {
        this.check_id = check_id;
    }

    public int getCheckcode() {
        return checkcode;
    }

    public void setCheckcode(int checkcode) {
        this.checkcode = checkcode;
    }
}
