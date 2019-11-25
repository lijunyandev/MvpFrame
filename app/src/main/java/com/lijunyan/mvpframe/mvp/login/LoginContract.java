package com.lijunyan.mvpframe.mvp.login;


import com.lijunyan.mvpframe.base.BaseView;
import com.lijunyan.mvpframe.bean.LoginBean;
import com.lijunyan.mvpframe.http.BaseEntity;

import io.reactivex.Observable;

/**
 * Created by lijunyan on 2019-11-25
 */
public interface LoginContract {

    interface Model{

        Observable<BaseEntity<LoginBean>> loginByPassword(String phone, String password, String countryCode);
    }

    interface View extends BaseView {
        void showLoginSuccess();
    }

    interface Presenter {

        void loginByPassword(String phone, String password, String countryCode);
    }


}
