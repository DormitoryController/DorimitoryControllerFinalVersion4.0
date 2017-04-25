package com.dormitory.model.po;

/**
 * Created by war on 2017/4/17.
 */
public class SuperAdmin {
    private int id;
    private String name;
    private String passwd;
    private String telephone;
    private String email;
    private String officenum;

    public SuperAdmin() {
    }

    public SuperAdmin(int id, String name, String passwd, String telephone, String email, String officenum) {
        this.id = id;
        this.name = name;
        this.passwd = passwd;
        this.telephone = telephone;
        this.email = email;
        this.officenum = officenum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOfficenum() {
        return officenum;
    }

    public void setOfficenum(String officenum) {
        this.officenum = officenum;
    }
}
