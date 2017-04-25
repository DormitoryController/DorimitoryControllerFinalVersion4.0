package com.dormitory.model.po;

/**
 * Created by war on 2017/4/17.
 */
public class Repairer {
    private int id;
    private String name;
    private String passwd;
    private Boolean sex;
    private String repairer_type;
    private String telephone;
    private String email;
    private String officenum;

    public Repairer(){

    }

    public Repairer(int id, String name, String passwd, Boolean sex, String repairer_type, String telephone, String email, String officenum) {
        this.id = id;
        this.name = name;
        this.passwd = passwd;
        this.sex = sex;
        this.repairer_type = repairer_type;
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

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getRepairer_type() {
        return repairer_type;
    }

    public void setRepairer_type(String repairer_type) {
        this.repairer_type = repairer_type;
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

    @Override
    public String toString() {
        return "Repairer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", passwd='" + passwd + '\'' +
                ", sex=" + sex +
                ", repairer_type='" + repairer_type + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", officenum='" + officenum + '\'' +
                '}';
    }
}
