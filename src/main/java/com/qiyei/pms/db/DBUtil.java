package com.qiyei.pms.db;

import com.qiyei.pms.bean.Emp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Created by qiyei2015 on 2019/9/15.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class DBUtil {
    private static Map<String, Emp> sUserMap = new HashMap<>();

    static {
        sUserMap.put("101",new Emp("101","AA","123456","AA@qq.com"));
        sUserMap.put("102",new Emp("102","BB","123456","BB@qq.com"));
        sUserMap.put("103",new Emp("103","CC","123456","CC@qq.com"));
        sUserMap.put("104",new Emp("104","DD","123456","DD@qq.com"));
    }

    /**
     * 验证账号和密码
     * @param emp
     * @return
     */
    public static boolean verifyAccountAndPassword(Emp emp){
        boolean flag = false;
        for (Map.Entry<String,Emp> entry:sUserMap.entrySet()){
            Emp item = entry.getValue();
            if (item != null && item.getAccount().equals(emp.getAccount()) && item.getPassword().equals(emp.getPassword())){
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static Map<String, Emp> getUserMap() {
        return sUserMap;
    }
}

