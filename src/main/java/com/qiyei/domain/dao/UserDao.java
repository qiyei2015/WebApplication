package com.qiyei.domain.dao;

import com.qiyei.db.DBManager;
import com.qiyei.domain.bean.User;
import com.qiyei.utils.DBUtils;
import org.apache.ibatis.session.SqlSession;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Created by qiyei2015 on 2019/10/19.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class UserDao {


    static {
        createUsers();
    }

    private static void createUsers(){
        if (!DBManager.getInstance().validateTableExist(User.$.tableName)){
            PreparedStatement preparedStatement = null;
            try (Connection connection = DBManager.getInstance().getConnection()){
                String createUsersSql = "create table " + User.$.tableName + "("
                        + User.$.id + " int primary key not null auto_increment,"
                        + User.$.userName + " varchar(32) not null,"
                        + User.$.password + " varchar(16) not null,"
                        + User.$.nickname + " varchar(32) not null,"
                        + User.$.sex + " varchar (16),"
                        + User.$.hobby + " varchar(32),"
                        + User.$.iconPath + " text"
                        + ");";
                preparedStatement = connection.prepareStatement(createUsersSql);
                preparedStatement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                DBManager.close(preparedStatement);
            }
        } else {

        }
    }

    public void insert(User user){
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            connection = DBManager.getInstance().getConnection();
            String insertSql = "INSERT INTO " + User.$.tableName + "("
                    + User.$.userName + ","
                    + User.$.password + ","
                    + User.$.nickname + ","
                    + User.$.sex + ","
                    + User.$.hobby + ","
                    + User.$.iconPath + ")"
                    + "VALUES (?,?,?,?,?,?)";

            preparedStatement = connection.prepareStatement(insertSql);
            preparedStatement.setString(1,user.getUserName());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.setString(3,user.getNickname());
            preparedStatement.setString(4,user.getSex());
            preparedStatement.setString(5,user.getHobby());
            preparedStatement.setString(6,user.getIconPath());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.close(preparedStatement);
            DBManager.close(connection);
        }
    }

    public List<User> queryAll(){
        SqlSession session = DBUtils.getSession();
        List<User> list = null;
        try {
            list = session.selectList("queryUser");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.close();
        }
        return list;
    }

    public User queryUser(int id){
        SqlSession session = DBUtils.getSession();
        User user = null;
        try {
            user = session.selectOne("queryUser",new User(id));
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.close();
        }
        return user;
    }

    public int insertUser(User user){
        SqlSession session = DBUtils.getSession();
        int id = -1;
        try {
            id = session.insert("insertUser",user);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.close();
        }
        return id;
    }

    /**
     *
     * @return
     */
    public int updateUser(User user) {
        int id = -1;
        SqlSession session = DBUtils.getSession();
        try {
            // 返回值：是insert执行过程中影响的行数
            id = session.update("updateUser", user);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return id;
    }

    public void deleteUser(int id) {
        SqlSession session = DBUtils.getSession();
        try {
            session.delete("deleteUser", new User(id));
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
