package com.dormitory.model.po;

/**
 * Created by war on 2017/4/17.
 */
public class Supervisor {
    private int id;
    private String name;
    private String passwd;
    private Boolean sex;
    private String telephone;
    private String eamil;
    private String officenum;

    public Supervisor(){

    }

    public Supervisor(int id, String name, String passwd, Boolean sex, String telephone, String eamil, String officenum) {
        this.id = id;
        this.name = name;
        this.passwd = passwd;
        this.sex = sex;
        this.telephone = telephone;
        this.eamil = eamil;
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

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEamil() {
        return eamil;
    }

    public void setEamil(String eamil) {
        this.eamil = eamil;
    }

    public String getOfficenum() {
        return officenum;
    }

    public void setOfficenum(String officenum) {
        this.officenum = officenum;
    }
}
