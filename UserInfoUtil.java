package com.example.myapplication.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 窦浩鹏 on 2017/8/26.
 */

public class UserInfoUtil {
    public static boolean    saveUserInfo(String username, String password) {
        try {
            String userinfo = username+"##"+password;
            String path = "D:/javase";
            File file = new File(path,"userinfo.txt");

            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(userinfo.getBytes());
            fileOutputStream.close();
            return  true;
        } catch (Exception e) {
            e.printStackTrace();
        }


        return false;
    }


    public static Map<String,String> getUserInfo(){
        try {

            String path = "D:/javase";
            File file = new File(path,"userinfo.txt");

            FileInputStream fileInputStream = new FileInputStream(file);

           BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            String readline = bufferedReader.readLine();
           String[] split  =  readline.split("##");
           HashMap<String,String> hashmap = new HashMap<String,String>();
            hashmap.put("username",split[0]);
            hashmap.put("password",split[1]);
            bufferedReader.close();
            fileInputStream.close();
            return hashmap;

        } catch (Exception e) {
            e.printStackTrace();
        }
       return null;

    }
}
