package com.lijunyan.mvpframe.http;



import com.lijunyan.mvpframe.bean.LoginBean;
import com.lijunyan.mvpframe.http.body.LoginPasswordBody;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by lijunyan on 2019-07-15
 */
public interface ApiService {

    /**
     * 手机登录
     *
     * @param body
     * @return
     */
    @POST("user/user/login")
    Observable<BaseEntity<LoginBean>> loginByPassword(@Body LoginPasswordBody body);

}