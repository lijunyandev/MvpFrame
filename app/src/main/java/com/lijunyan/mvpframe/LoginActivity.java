package com.lijunyan.mvpframe;

import android.view.View;
import android.widget.TextView;

import com.lijunyan.mvpframe.base.BaseMvpActivity;
import com.lijunyan.mvpframe.mvp.login.LoginContract;
import com.lijunyan.mvpframe.mvp.login.LoginPresenter;

import butterknife.BindView;

public class LoginActivity extends BaseMvpActivity implements LoginContract.View {

    @BindView(R.id.tv_login)
    TextView tvLogin;

    private LoginPresenter loginPresenter;

    @Override
    protected void addPresenters() {
        loginPresenter = new LoginPresenter();
        addToPresenters(loginPresenter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initEventAndData() {
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.loginByPassword("15911112222", "123456", "86");
            }
        });
    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void showLoginSuccess() {
        showToast("登录成功 hahahhahahah");
    }
}
