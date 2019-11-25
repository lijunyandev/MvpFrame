package com.lijunyan.mvpframe.util;

import android.app.Activity;

import java.util.Stack;


/**
 * Activity 管理类
 * Created by lijunyan on 2019-07-09
 */
public class ActivityCollector {


    private static ActivityCollector instance;
    private static Stack<Activity> activityStack;

    private ActivityCollector() {
    }

    public static ActivityCollector getInstance() {
        if (instance == null) {
            instance = new ActivityCollector();
        }
        return instance;
    }

    /**
     * 添加 Activity 到堆栈
     */
    public void addActivity(Activity activity) {
        if (activityStack == null) {
            activityStack = new Stack<>();
        }
        activityStack.add(activity);
    }

    /**
     * 获取当前 Activity （堆栈中最后一个压入的）
     */
    public Activity currentActivity() {
        return activityStack.lastElement();
    }

    /**
     * 结束当前 Activity （堆栈中最后一个压入的）
     */
    public void removeActivity() {
        if (activityStack == null || activityStack.size() == 0) {
            return;
        }
        Activity activity = activityStack.lastElement();
        removeActivity(activity);
    }

    /**
     * 结束指定的Activity
     */
    public void removeActivity(Activity activity) {
        if (activity != null) {
            activityStack.remove(activity);
            activity.finish();
            activity = null;
        }
    }

    /**
     * 结束指定类名的Activity
     */
    public void removeActivity(Class<?> cls) {
        for (Activity activity : activityStack) {
            if (activity.getClass().equals(cls)) {
                removeActivity(activity);
            }
        }
    }

    /**
     * 结束所有Activity
     */
    public void removeAllActivity() {
        for (int i = 0, size = activityStack.size(); i < size; i++) {
            if (null != activityStack.get(i)) {
                activityStack.get(i).finish();
            }
        }
        activityStack.clear();
    }

    /**
     * 退出应用程序
     */
    public void exitApp() {
        try {
            removeAllActivity();
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(0);
        } catch (Exception e) {
        }
    }

}
