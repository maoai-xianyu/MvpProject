package com.mao.cn.mvpproject.ui.commons;

import android.content.Context;

import com.mao.cn.mvpproject.MvpApplication;
import com.mao.cn.mvpproject.utils.tools.PreferenceU;


// +----------------------------------------------------------------------
// | CreateTime: 15/8/12 
// +----------------------------------------------------------------------
// | Author:     xab(http://www.xueyong.net.cn)
// +----------------------------------------------------------------------
// | CopyRight:  http://www.boxfish.cn
// +----------------------------------------------------------------------
public abstract class BasePresenterImp implements BasePresenter {
    protected Context context;
    protected PreferenceU preferenceU;

    public BasePresenterImp() {
        this.context = MvpApplication.context();
        this.preferenceU = PreferenceU.getInstance(MvpApplication.context());

    }

}
