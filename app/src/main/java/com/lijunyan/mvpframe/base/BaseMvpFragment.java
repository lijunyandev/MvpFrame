package com.lijunyan.mvpframe.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;

import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.AutoDisposeConverter;
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lijunyan on 2019-11-19
 */
public abstract class BaseMvpFragment extends BaseFragment{

    private List<BasePresenter> mPresenters;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenters = new ArrayList<>();
        addPresenters();
        for (BasePresenter presenter : mPresenters) {
            presenter.attachView(this);
        }
    }

    protected abstract void addPresenters();

    protected void addToPresenters(BasePresenter child) {
        mPresenters.add(child);
    }

    @Override
    public void onDestroyView() {
        for (BasePresenter presenter : mPresenters) {
            presenter.detachView();
        }
        super.onDestroyView();
    }

    /**
     * 绑定生命周期 防止MVP内存泄漏
     */
    @Override
    public <T> AutoDisposeConverter<T> bindAutoDispose() {
        return AutoDispose.autoDisposable(AndroidLifecycleScopeProvider
                .from(this, Lifecycle.Event.ON_DESTROY));
    }
}
