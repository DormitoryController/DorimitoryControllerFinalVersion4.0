package com.dormitory.model.po;

/**
 * Created by war on 2017/4/17.
 */
public class Checkcode {
    private int id;
    private Long user_id;
    private String checkcode;
    private String user_type;
    private String use_state;


    public Checkcode() {
    }

    public Checkcode(int id, Long user_id, String checkcode, String use_state, String state) {
        this.id = id;
        this.user_id = user_id;
        this.checkcode = checkcode;
        this.user_type = user_type;
        this.use_state = use_state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getCheckcode() {
        return checkcode;
    }

    public void setCheckcode(String checkcode) {
        this.checkcode = checkcode;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getUse_state() {
        return use_state;
    }

    public void setUse_state(String use_state) {
        this.use_state = use_state;
    }

    @Override
    public String toString() {
        return "Checkcode{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", checkcode='" + checkcode + '\'' +
                ", user_type='" + user_type + '\'' +
                ", use_state='" + use_state + '\'' +
                '}';
    }
}
