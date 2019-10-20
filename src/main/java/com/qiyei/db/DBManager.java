package com.qiyei.db;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Created by qiyei2015 on 2019/10/19.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class DBManager {

    private static final String TAG = "DBManager";
    private static final String TABLE = "TABLE";

    private static HikariDataSource sHikariDataSource;
    private static DBManager sManager;

    private DBManager(){
        init();
    }

    public static DBManager getInstance(){
        if (sManager == null){
            synchronized (DBManager.class){
                if (sManager == null){
                    sManager = new DBManager();
                }
            }
        }
        return sManager;
    }

    public HikariDataSource getDataSource(){
        return sHikariDataSource;
    }

    public Connection getConnection() throws SQLException{
        return sHikariDataSource.getConnection();
    }

    private void init(){
        // 如何获得属性文件的输入流？
        // 通常情况下使用类的加载器的方式进行获取：
        try (InputStream is = DBManager.class.getClassLoader().getResourceAsStream("hikari.properties")) {
            // 加载属性文件并解析：
            Properties props = new Properties();
            props.load(is);
            HikariConfig config = new HikariConfig(props);
            sHikariDataSource = new HikariDataSource(config);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean validateTableExist(String tableName){
        boolean flag = false;
        ResultSet rs = null;
        Connection connection = null;
        try {
            connection = getConnection();
            System.out.println("validateTableExist tableName:" + tableName);
            DatabaseMetaData meta = connection.getMetaData();
            String type[] = {TABLE};
            rs = meta.getTables(null, null, tableName, type);
            flag = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(rs);
            close(connection);
        }
        return flag;
    }

    public static void close(AutoCloseable closeable){
        if (closeable != null){
            try {
                closeable.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
