package com.dormitory.model.po;

/**
 * Created by war on 2017/4/17.
 */
public class Student {
    private int id;
    private String username;
    private String name;
    private String sex;
    private String telephone;
    private String email;
    private String flatnum;
    private String dormnum;
    private String password;

    public Student(){

    }

    public Student(int id, String username, String name, String sex, String telephone,
                   String email, String flatnum, String dormnum, String password) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.sex = sex;
        this.telephone = telephone;
        this.email = email;
        this.flatnum = flatnum;
        this.dormnum = dormnum;
        this.password = password;
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

    public String getFlatnum() {
        return flatnum;
    }

    public void setFlatnum(String flatnum) {
        this.flatnum = flatnum;
    }

    public String getDormnum() {
        return dormnum;
    }

    public void setDormnum(String dormnum) {
        this.dormnum = dormnum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String passwd) {
        this.password = passwd;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", flatnum='" + flatnum + '\'' +
                ", dormnum='" + dormnum + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
