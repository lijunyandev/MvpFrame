package com.lijunyan.mvpframe.http;

/**
 * Created by lijunyan on 2019-07-17
 */

import android.util.Log;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public abstract class BaseObserver<T> implements Observer<BaseEntity<T>> {

    private static final String TAG = BaseObserver.class.getSimpleName();
    private Disposable disposable;

    @Override
    public void onSubscribe(@NonNull Disposable d) {
//        Log.d(TAG, "onSubscribe");
        disposable = d;
    }

    /**
     * 统一拦截成功返回数据
     * @param value
     */
    @Override
    public void onNext(BaseEntity<T> value) {
        Log.d(TAG, value.toString());
        try {
            if (value.isSuccess() && value.getCode() == 0) {
                onSuccess(value.getData());
            } else {
                onError(value.getMsg());
            }
        }catch (Exception e){
            e.printStackTrace();
            onError(value.getMsg());
        }
    }

    @Override
    public void onError(Throwable e) {
        Log.e(TAG, e.getMessage());
        onError(e.getMessage());
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }

    @Override
    public void onComplete() {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }

    public abstract void onSuccess(T data);

    public abstract void onError(String message);

}