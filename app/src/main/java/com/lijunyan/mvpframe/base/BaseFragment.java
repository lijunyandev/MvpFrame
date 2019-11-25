package com.lijunyan.mvpframe.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.lijunyan.mvpframe.util.ToastUtil;
import com.lijunyan.mvpframe.widget.LoadingDialog;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by lijunyan on 2019-11-19
 */
public abstract class BaseFragment extends Fragment implements BaseView {

    protected Context mContext;

    private Unbinder unBinder;

    private LoadingDialog loadingDialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        unBinder = ButterKnife.bind(this, view);
        mContext = getActivity();
        loadingDialog = new LoadingDialog(getActivity());
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initEventAndData();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unBinder != null && unBinder != Unbinder.EMPTY) {
            unBinder.unbind();
            unBinder = null;
        }
        loadingDialog.dismiss();
    }

    @Override
    public void showLoadingMsg(String msg) {
        loadingDialog.setMessage(msg);
        loadingDialog.show();
    }

    @Override
    public void showLoading() {
        loadingDialog.show();
    }

    @Override
    public void hideLoading() {
        loadingDialog.dismiss();
    }

    @Override
    public void showToast(String message) {
        ToastUtil.showToast(message);
    }

    /**
     * 获取当前Fragment的UI布局
     *
     * @return 布局id
     */
    protected abstract int getLayoutId();

    /**
     * 初始化数据
     */
    protected abstract void initEventAndData();


}
