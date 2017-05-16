package com.dormitory.model.po;

/**
 * Created by war on 2017/4/17.
 */
public class Repairer {
    private int id;
    private String username;
    private String name;
    private String password;
    private String sex;
    private String repairer_type;
    private String telephone;
    private String email;
    private String officenum;
    private String state;

    public Repairer(){

    }

    public Repairer(int id, String username, String name, String password, String sex,
                    String repairer_type, String telephone, String email, String officenum, String state) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.repairer_type = repairer_type;
        this.telephone = telephone;
        this.email = email;
        this.officenum = officenum;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Repairer{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", repairer_type='" + repairer_type + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", officenum='" + officenum + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
