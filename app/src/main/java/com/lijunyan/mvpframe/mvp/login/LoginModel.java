package com.lijunyan.mvpframe.mvp.login;


import com.lijunyan.mvpframe.base.BaseModel;
import com.lijunyan.mvpframe.bean.LoginBean;
import com.lijunyan.mvpframe.http.BaseEntity;
import com.lijunyan.mvpframe.http.body.LoginPasswordBody;

import io.reactivex.Observable;

/**
 * Created by lijunyan on 2019-11-25
 */
public class LoginModel extends BaseModel implements LoginContract.Model{

    @Override
    public Observable<BaseEntity<LoginBean>> loginByPassword(String phone, String password, String countryCode) {
        return apiService.loginByPassword(new LoginPasswordBody(phone,password,countryCode));
    }

}
