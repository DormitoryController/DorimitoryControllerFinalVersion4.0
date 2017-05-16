package com.dormitory.model.po;

/**
 * Created by war on 2017/4/17.
 */
public class Supervisor {
    private int id;
    private String username;
    private String name;
    private String password;
    private String sex;
    private String telephone;
    private String email;
    private String officenum;

    public Supervisor(){

    }

    public Supervisor(int id, String username, String name, String password,
                      String sex, String telephone, String email, String officenum) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.password = password;
        this.sex = sex;
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
        return "Supervisor{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", officenum='" + officenum + '\'' +
                '}';
    }
}
