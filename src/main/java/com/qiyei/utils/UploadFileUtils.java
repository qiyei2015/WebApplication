package com.qiyei.utils;

import java.util.UUID;

/**
 * @author Created by qiyei2015 on 2019/10/4.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class UploadFileUtils {

    /**
     *
     * @param file
     * @return
     */
    public static String getUUIDFileName(String file){
        if (TextUtils.isEmpty(file)){
            return null;
        }
        int index = file.lastIndexOf(".");
        String temp = file;
        String suffix = file.substring(index);
        String prefix = temp.substring(0,index);

        return prefix + "_" + UUID.randomUUID().toString().replaceAll("-","") + suffix;
    }

}
