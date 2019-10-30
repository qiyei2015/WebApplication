package com.qiyei.domain.bean;

import java.util.Date;

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
        String nickName = "nick_name";
        String gender = "gender";
        String phone = "phone";
        String email = "email";
        String createTime = "create_time";
        String updateTime = "update_time";
        String lastLogin = "last_login";
        String userStatus = "user_status";
        String remark = "remark";
        String hobby = "hobby";
        String iconPath = "icon_path";
    }
    private Integer id;
    private String userName;
    private String password;
    private String nickName;
    /**
     * 用户性别
     */
    private String gender;
    /**
     * 联系方式
     */
    private String phone;
    /**
     * 用户邮箱
     */
    private String email;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 账号最后修改时间
     */
    private Date updateTime;
    /**
     * 用户最后登录时间
     */
    private Date lastLogin;
    /**
     * 用户账号状态 0 正常 1 锁定 2 删除
     */
    private Integer userStatus;
    /**
     * 用户备注信息
     */
    private String remark;
    /**
     * 爱好
     */
    private String hobby;
    /**
     * 头像信息
     */
    private String iconPath;

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(String userName, String password, String nickname, String gender, String phone, String email,
                Date createTime, Date updateTime, Date lastLogin, Integer userStatus, String remark, String hobby,
                String iconPath) {
        this.userName = userName;
        this.password = password;
        this.nickName = nickname;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.lastLogin = lastLogin;
        this.userStatus = userStatus;
        this.remark = remark;
        this.hobby = hobby;
        this.iconPath = iconPath;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickName + '\'' +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", lastLogin=" + lastLogin +
                ", userStatus=" + userStatus +
                ", remark='" + remark + '\'' +
                ", hobby='" + hobby + '\'' +
                ", iconPath='" + iconPath + '\'' +
                '}';
    }
}
