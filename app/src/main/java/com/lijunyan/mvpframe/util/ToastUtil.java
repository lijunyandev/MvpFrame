package com.lijunyan.mvpframe.util;

import android.widget.Toast;

import com.lijunyan.mvpframe.app.App;


/**
 * Created by lijunyan on 2019/4/4
 */
public class ToastUtil {

    private static Toast mToast;

    public ToastUtil() {
    }

    public static void showToast(String msg) {
        if (mToast == null) {
            mToast = Toast.makeText(App.getInstance(), msg, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(msg);
        }

        mToast.show();
    }

    public static void showLongToast(String msg) {
        if (mToast == null) {
            mToast = Toast.makeText(App.getInstance(), msg, Toast.LENGTH_LONG);
        } else {
            mToast.setText(msg);
        }

        mToast.show();
    }
}
