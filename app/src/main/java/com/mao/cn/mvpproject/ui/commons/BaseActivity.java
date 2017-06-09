package com.mao.cn.mvpproject.ui.commons;

import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.mao.cn.mvpproject.MvpApplication;
import com.mao.cn.mvpproject.base.BaseViewInterface;
import com.mao.cn.mvpproject.common.CommActivity;
import com.mao.cn.mvpproject.component.AppComponent;
import com.mao.cn.mvpproject.converter.RetrofitError;
import com.orhanobut.logger.Logger;

/**
 * Created by zhangkun on 2017/6/9.
 */

public abstract class BaseActivity extends CommActivity implements BaseViewInterface{


    protected void setStyle(boolean status, boolean navigation) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            // Translucent status bar
            if (status)
                window.setFlags(
                        WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                        WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // Translucent navigation bar
            if (navigation)
                window.setFlags(
                        WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION,
                        WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }


    public void setScreenBackground(float alphaParams) {
        WindowManager.LayoutParams params = this.getWindow().getAttributes();
        params.alpha = alphaParams;
        this.getWindow().setAttributes(params);
    }

    @Override
    public void showLoadingDialog(String msg) {

    }

    @Override
    public void showLoadingDialog(int msg) {

    }

    @Override
    public void hideLoadingDialog() {

    }

    @Override
    public void onTip(String msg) {

    }

    @Override
    public void interError(RetrofitError error) {

    }

    @Override
    public void onTip(int msg) {

    }

    @Override
    public void interError(Throwable throwable) {

    }

    @Override
    public void getArgs(Bundle var1) {

    }

    @Override
    public int setView() {
        return 0;
    }

    @Override
    public void initView() {

    }

    @Override
    public void setting() {

        Logger.i(" activity "+getClass().getName());
        MvpApplication.addAty(activity);

    }

    protected abstract void setupComponent(AppComponent appComponent);

    public boolean checkActivityState() {
        return activity != null && !activity.isFinishing();
    }

    @Override
    protected void onDestroy() {
        MvpApplication.removeAty(activity);
        super.onDestroy();
    }
}
