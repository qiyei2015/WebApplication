package com.qiyei.domain.bean;

/**
 * @author Created by qiyei2015 on 2019/10/4.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class User {

    public interface ${
        String tableName = "users";
        String id = "id";
        String userName = "user_name";
        String password = "password";
        String nickname = "nick_name";
        String sex = "sex";
        String hobby = "hobby";
        String iconPath = "icon_path";
    }

    private String userName;
    private String password;
    private String nickname;
    private String sex;
    private String hobby;
    private String iconPath;

    public User(String userName, String password, String nickname, String sex, String hobby, String iconPath) {
        this.userName = userName;
        this.password = password;
        this.nickname = nickname;
        this.sex = sex;
        this.hobby = hobby;
        this.iconPath = iconPath;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", sex='" + sex + '\'' +
                ", hobby='" + hobby + '\'' +
                ", iconPath='" + iconPath + '\'' +
                '}';
    }
}
