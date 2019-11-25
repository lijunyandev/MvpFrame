package com.lijunyan.mvpframe.base;

import com.uber.autodispose.AutoDisposeConverter;

/**
 * Created by lijunyan on 2019-11-19
 */
public interface BaseView {

    /**
     * Show loading
     */
    void showLoading();

    /**
     * Hide loading
     */
    void hideLoading();

    /**
     * Hide loading
     */
    void showLoadingMsg(String msg);

    /**
     * Show toast
     *
     * @param message Message
     */
    void showToast(String message);


    /**
     * 数据获取失败
     *
     * @param message
     */
    void onError(String message);


    /**
     * 绑定Android生命周期 防止RxJava内存泄漏
     *
     * @param <T>
     * @return
     */
    <T> AutoDisposeConverter<T> bindAutoDispose();


}
