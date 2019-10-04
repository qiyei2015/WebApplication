package com.qiyei.pms.bean;

/**
 * @author Created by qiyei2015 on 2019/9/15.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class Emp {
    private String account;
    private String name;
    private String password;
    private String email;

    public Emp(String account, String name, String password, String email) {
        this.account = account;
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}