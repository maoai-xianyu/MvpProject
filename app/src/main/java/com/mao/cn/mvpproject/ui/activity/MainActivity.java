// +----------------------------------------------------------------------
// | Project:   MvpProject
// +----------------------------------------------------------------------
// | CreateTime: 06/09/2017 11:17 上午
// +----------------------------------------------------------------------
// | Author:     xab(xab@xabad.cn)
// +----------------------------------------------------------------------
// | Description:
// +----------------------------------------------------------------------
package com.mao.cn.mvpproject.ui.activity;

import android.os.Bundle;

import com.mao.cn.mvpproject.R;
import com.mao.cn.mvpproject.component.AppComponent;
import com.mao.cn.mvpproject.component.DaggerMainComponent;
import com.mao.cn.mvpproject.modules.MainModule;
import com.mao.cn.mvpproject.ui.commons.BaseActivity;
import com.mao.cn.mvpproject.ui.features.IMain;
import com.mao.cn.mvpproject.ui.presenter.MainPresenter;

import javax.inject.Inject;
/**
* DESC   :
* AUTHOR : Xabad
*/
public class MainActivity extends BaseActivity  implements IMain {

    @Inject
    MainPresenter presenter;

    @Override
    public void getArgs(Bundle bundle) {

    }

    @Override
    public int setView() {
        return R.layout.aty_main;
    }

    @Override
    public void initView() {

    }

    @Override
    public void setListener() {

    }

    @Override
    protected void setupComponent(AppComponent appComponent) {
        DaggerMainComponent.builder()
            .appComponent(appComponent)
            .mainModule(new MainModule(this))
            .build().inject(this);
    }
}
