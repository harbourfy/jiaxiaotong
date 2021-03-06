package com.app.jiaxiaotong;

import android.content.Context;
import android.content.SharedPreferences;

import com.app.jiaxiaotong.data.ServiceConst;
import com.app.jiaxiaotong.model.ChildModel;
import com.app.jiaxiaotong.model.UserModel;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2015/9/3.
 */
public class UserInfoKeeper {
    private static final String NAME = "name";
    private static final String AVATAR = "avatar";
    private static final String USER_TYPE = "userTypes";
    private static final String TYPE = "type";
    private static final String UID = "uid";
    private static final String MOBILE_PHONE = "mobilePhone";
    private static final String RELATION = "relation";
    private static final String SCHOOL_NAME = "schoolName";

    private static final String PREFERENCES_NAME = "user_info";

    /**
     * 写入用户信息到首选项
     * @param context
     * @param info
     */
    public static void writeUserInfo(Context context,UserModel info){
        if (null == context || null == info) {
            return;
        }

        SharedPreferences pref = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_APPEND);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(NAME, info.getName());
        editor.putString(AVATAR, ServiceConst.SERVICE_URL + "/api/mobiles/header/" + info.getAvatar());
        editor.putString(UID, info.getUid());
        String userTypes = "";
        for (String userType : info.getUserTypes()){
            userTypes += userType + ",";
        }
        editor.putString(USER_TYPE, userTypes);
        editor.putString(TYPE, info.getType());
        editor.putString(RELATION,info.getRelation());
        editor.putString(MOBILE_PHONE,info.getMobilePhone());
        editor.putString(SCHOOL_NAME,info.getSchoolName());
        editor.commit();
    }
    /**
            * 写入用户手机号到首选项
    * @param context
    * @param info
    */
    public static void writeUserTel(Context context,String info){
        if (null == context || null == info) {
            return;
        }

        SharedPreferences pref = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_APPEND);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(MOBILE_PHONE,info);
        editor.commit();
    }
    /**
     * 写入用户头像到首选项
     * @param context
     * @param info
     */
    public static void writeUserAvatar(Context context,String info){
        if (null == context || null == info) {
            return;
        }

        SharedPreferences pref = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_APPEND);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(AVATAR, ServiceConst.SERVICE_URL + "/api/mobiles/header/" + info);

        editor.commit();
    }
    /**
     * 从首选项读取数据
     * @param context
     * @return
     */
    public static UserModel readUserInfo(Context context){
        if (null == context) {
            return null;
        }
        UserModel info = new UserModel();
        SharedPreferences pref = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_APPEND);
        info.setAvatar(pref.getString(AVATAR, ""));
        info.setName(pref.getString(NAME, ""));
        info.setType(pref.getString(TYPE, ""));
        info.setUid(pref.getString(UID, ""));
        info.setMobilePhone(pref.getString(MOBILE_PHONE, ""));
        info.setRelation(pref.getString(RELATION, ""));
        info.setSchoolName(pref.getString(SCHOOL_NAME,""));
        String[] userTypes = pref.getString(USER_TYPE, "").split(",");
        info.setUserTypes(userTypes);
        return info;
    }

    /**
     * 清除首选项数据
     * @param context
     */
    public static void clearInfo(Context context){
        if (null == context) {
            return;
        }
        SharedPreferences pref = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_APPEND);
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.commit();
    }
}
