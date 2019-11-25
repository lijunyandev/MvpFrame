package com.lijunyan.mvpframe.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lijunyan.mvpframe.R;
import com.wang.avi.AVLoadingIndicatorView;

/**
 * Created by lijunyan on 2019-07-18
 */
public class LoadingDialog extends Dialog {

    private AVLoadingIndicatorView loadingView;
    private TextView tvMsg;
    private RelativeLayout rlLoading;

    /**
     * 自定义主题及布局的构造方法
     * @param context
     */
    public LoadingDialog(Context context){
        super(context);
        /**设置对话框背景透明*/
        getWindow().setDimAmount(0);
//        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(R.layout.dialog_loading);
        rlLoading = findViewById(R.id.loading_rl);
        loadingView = findViewById(R.id.loading_avi);
        tvMsg = findViewById(R.id.loading_message);
    }

    /**
     * 为加载进度个对话框设置不同的提示消息
     *
     * @param message 给用户展示的提示信息
     * @return build模式设计，可以链式调用
     */
    public LoadingDialog setMessage(String message) {
        tvMsg.setVisibility(View.VISIBLE);
        tvMsg.setText(message);
        return this;
    }

    @Override
    public void show() {
        super.show();
        loadingView.setVisibility(View.VISIBLE);
        loadingView.show();
    }

    /***
     * 设置loading背景色
     * @param Colorbg
     * @return
     */
    public LoadingDialog setLoadingBg(int Colorbg){
        rlLoading.setBackgroundColor(Colorbg);
        return this;
    }

    @Override
    public void dismiss() {
        super.dismiss();
        loadingView.hide();
        tvMsg.setVisibility(View.GONE);
    }
}
