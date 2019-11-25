package com.lijunyan.mvpframe.base;


/**
 * Created by lijunyan on 2019-11-19
 */
public class BasePresenter<T extends BaseView> {

    protected T mView;

    public BasePresenter() {
    }

    public void attachView(T view) {
        this.mView = view;
    }

    public void detachView() {
        this.mView = null;
    }

}
