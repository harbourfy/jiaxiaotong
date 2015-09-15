package com.app.jiaxiaotong;

import android.app.Application;
import android.content.Context;

import com.app.jiaxiaotong.im.MyHXSDKHelper;
import com.app.jiaxiaotong.im.domain.User;
import com.easemob.EMCallBack;

import java.util.Map;

/**
 * Created by Administrator on 2015/8/24.
 */
public class AppContext extends Application {

    private static AppContext appContext;

    private static int identityType;//0代表老师，1代表家长

    // login user name
    public final String PREF_USERNAME = "username";

    /**
     * 当前用户nickname,为了苹果推送不是userid而是昵称
     */
    public static String currentUserNick = "";

    public static MyHXSDKHelper hxSDKHelper= new MyHXSDKHelper();

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = this;
        /**
         * this function will initialize the HuanXin SDK
         *
         * @return boolean true if caller can continue to call HuanXin related APIs after calling onInit, otherwise false.
         *
         * 环信初始化SDK帮助函数
         * 返回true如果正确初始化，否则false，如果返回为false，请在后续的调用中不要调用任何和环信相关的代码
         *
         * for example:
         * 例子：
         *
         * public class DemoHXSDKHelper extends HXSDKHelper
         *
         * HXHelper = new DemoHXSDKHelper();
         * if(HXHelper.onInit(context)){
         *     // do HuanXin related work
         * }
         */
        hxSDKHelper.onInit(appContext);
    }
    /**
     * 获取当前登陆用户名
     *
     * @return
     */
    public String getUserName() {
        return hxSDKHelper.getHXId();
    }

    /**
     * 获取密码
     *
     * @return
     */
    public String getPassword() {
        return hxSDKHelper.getPassword();
    }

    /**
     * 设置用户名
     *
     * @param username
     */
    public void setUserName(String username) {
        hxSDKHelper.setHXId(username);
    }

    /**
     * 设置密码 下面的实例代码 只是demo，实际的应用中需要加password 加密后存入 preference 环信sdk
     * 内部的自动登录需要的密码，已经加密存储了
     *
     * @param pwd
     */
    public void setPassword(String pwd) {
        hxSDKHelper.setPassword(pwd);
    }

    /**
     * 退出登录,清空数据
     */
    public void logout(final boolean isGCM,final EMCallBack emCallBack) {
        // 先调用sdk logout，在清理app中自己的数据
        hxSDKHelper.logout(isGCM, emCallBack);
    }

    public void setYelloTheme(){
        setTheme(R.style.AppblueTheme);
    }
    public void setBlueTheme(){
        setTheme(R.style.AppYelloTheme);
    }

    public static AppContext getAppContext(){
        return appContext;
    }

    public static int getIdentityType() {
        return identityType;
    }

    public static void setIdentityType(int identityType) {
        AppContext.identityType = identityType;
    }
    /**
     * 设置好友user list到内存中
     *
     * @param contactList
     */
    public void setContactList(Map<String, User> contactList) {
        hxSDKHelper.setContactList(contactList);
    }
}
