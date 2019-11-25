package com.lijunyan.mvpframe.base;


import com.lijunyan.mvpframe.http.Api;
import com.lijunyan.mvpframe.http.ApiService;

/**
 * Created by lijunyan on 2019-11-25
 */
public class BaseModel {

    protected ApiService apiService;

    public BaseModel() {
        this.apiService = Api.INSTANCE.getApiService();
    }
}
