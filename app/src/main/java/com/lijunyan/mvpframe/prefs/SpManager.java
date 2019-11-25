package com.lijunyan.mvpframe.prefs;

import com.orhanobut.hawk.Hawk;

/**
 * Created by lijunyan on 2019-07-24
 * key--value hawk 管理
 */
public class SpManager {

    private volatile static SpManager instance;
    private SpManager() {

    }

    public static SpManager getInstance(){
        if(instance == null){
            synchronized (SpManager.class){
                if(instance == null){
                    instance = new SpManager();
                }
            }
        }
        return instance;
    }

    public void clearAll(){
        Hawk.deleteAll();
    }

}
