package com.lijunyan.mvpframe.base;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import com.lijunyan.mvpframe.util.ActivityCollector;
import com.lijunyan.mvpframe.util.ToastUtil;
import com.lijunyan.mvpframe.widget.LoadingDialog;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by lijunyan on 2019-11-19
 */
public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    protected Context mContext;

    private Unbinder unBinder;

    private LoadingDialog loadingDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        unBinder = ButterKnife.bind(this);
        mContext = this;
        loadingDialog = new LoadingDialog(this);
        ActivityCollector.getInstance().addActivity(this);
        initEventAndData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.getInstance().removeActivity(this);
        if (unBinder != null && unBinder != Unbinder.EMPTY) {
            unBinder.unbind();
            unBinder = null;
        }
        loadingDialog.dismiss();
        hideKeyBoard();
    }


    /**
     * 获取当前Activity的UI布局
     *
     * @return 布局id
     */
    protected abstract int getLayoutId();

    /**
     * 初始化数据
     */
    protected abstract void initEventAndData();


    @Override
    public void showLoading() {
        loadingDialog.show();
    }

    @Override
    public void hideLoading() {
        if (loadingDialog.isShowing()) {
            loadingDialog.dismiss();
        }
    }

    @Override
    public void showLoadingMsg(String msg) {
        loadingDialog.setMessage(msg);
        loadingDialog.show();
    }

    @Override
    public void showToast(String message) {
        ToastUtil.showToast(message);
    }

    /**
     * 隐藏软键盘
     */
    protected void hideKeyBoard() {
        View view = getCurrentFocus();
        if (view != null) {
            ((InputMethodManager) getSystemService(INPUT_METHOD_SERVICE))
                    .hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }


    protected void showKeyBoard() {
        View view = getCurrentFocus();
        if (view != null) {
            ((InputMethodManager) getSystemService(INPUT_METHOD_SERVICE))
                    .showSoftInput(view, 0);
        }
    }

}
