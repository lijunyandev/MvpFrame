package com.lijunyan.mvpframe.mvp.login;


import com.lijunyan.mvpframe.base.BasePresenter;
import com.lijunyan.mvpframe.bean.LoginBean;
import com.lijunyan.mvpframe.http.BaseObserver;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by lijunyan on 2019-11-25
 */
public class LoginPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter {

    private LoginModel model;

    public LoginPresenter() {
        this.model = new LoginModel();
    }

    @Override
    public void loginByPassword(String phone, String password, String countryCode) {

        mView.showLoading();
        model.loginByPassword(countryCode,phone,password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .as(mView.bindAutoDispose())
                .subscribe(new BaseObserver<LoginBean>() {
                    @Override
                    public void onSuccess(LoginBean data) {
                        mView.hideLoading();
                        mView.showLoginSuccess();
                    }

                    @Override
                    public void onError(String message) {
                        mView.hideLoading();
                        mView.showToast(message);
                    }
                });
    }
}
