package com.mao.cn.mvpproject.ui.commons;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.mao.cn.mvpproject.MvpApplication;
import com.mao.cn.mvpproject.base.BaseViewInterface;
import com.mao.cn.mvpproject.common.CommFragment;
import com.mao.cn.mvpproject.component.AppComponent;
import com.mao.cn.mvpproject.converter.RetrofitError;

import java.lang.reflect.Field;

import retrofit2.adapter.rxjava.HttpException;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public abstract class BaseFragment extends CommFragment implements BaseViewInterface {

    protected static String clickComboType = "";


    //用于修改 java.lang.IllegalStateException: No host 异常
    @Override
    public void onDetach() {
        super.onDetach();
        try {
            Field childFragmentManager = Fragment.class.getDeclaredField("mChildFragmentManager");
            childFragmentManager.setAccessible(true);
            childFragmentManager.set(this, null);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void setting() {
        setupComponent(MvpApplication.getComponent());
    }


    protected abstract void getArgs(Bundle bundle);

    protected abstract int setView();

    protected abstract void setupComponent(AppComponent appComponent);

    @Override
    public void interError(RetrofitError error) {
        int status = error.getCode();
        if (status == RetrofitError.ERROR_CONNECTION) {
            return;
        }
    }

    @Override
    public void interError(Throwable throwable) {
        if (throwable instanceof HttpException) {
            HttpException httpException = (HttpException) throwable;
        }
    }

    @Override
    public void showLoadingDialog(final String str) {
        if (!checkActivityState()) return;
    }

    @Override
    public void showLoadingDialog(int i) {

    }

    @Override
    public void hideLoadingDialog() {
        if (!checkActivityState()) return;
    }

    @Override
    public void onTip(final String tipInfo) {
        if (!checkActivityState()) return;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(context, tipInfo, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @Override
    public void onTip(int i) {
        if (!checkActivityState()) return;
        onTip(getString(i));
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    // 检测当前的activity 是否被销毁
    protected boolean checkActivityState() {
        return activity != null
                && !activity.isFinishing()
                && isAdded();
    }

    // 检测当前的activity fragment 是否被销毁
    protected boolean checkActivityAndFragmentState() {
        return activity != null
                && !activity.isFinishing()
                && isAdded()
                && (getParentFragment() != null && getParentFragment().getUserVisibleHint());
    }


    // 处理事件的方法
    protected <T> Observable.Transformer<T, T> timer() {
        return observable -> observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
