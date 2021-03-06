package com.wz.googleplay.base;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wz on 2016/4/16.
 * 全局，单例，全局的容器
 * 放置全局的对象
 * 放置常用的对象
 */
public class MyApplication extends Application {

    private static Context mContext;
    private static Handler mHandler;
    private static long    mMainThreadId;

    //保存我们协议的内容
    private Map<String, String> mProtocolMap = new HashMap<>();

    public Map<String, String> getProtocolMap() {
        return mProtocolMap;
    }

    public static Context getContext() {
        return mContext;
    }

    public static Handler getHandler() {
        return mHandler;
    }

    public static long getMainThreadId() {
        return mMainThreadId;
    }

    @Override
    public void onCreate() {// 程序的入口方法

        // 1.上下文
        mContext = getApplicationContext();

        // 2.主线程的Handler
        mHandler = new Handler();

        // 3.得到主线程的id
        mMainThreadId = android.os.Process.myTid();
        /**
         myTid: thread
         myPid: process
         myUid: user
         */

        super.onCreate();
    }
}
