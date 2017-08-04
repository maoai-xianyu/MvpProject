// +----------------------------------------------------------------------
// | Project:   MvpProject
// +----------------------------------------------------------------------
// | CreateTime: 08/04/2017 16:53 下午
// +----------------------------------------------------------------------
// | Author:     xab(xab@xabad.cn)
// +----------------------------------------------------------------------
// | Description:
// +----------------------------------------------------------------------
package com.mao.cn.mvpproject.ui.activity;

import android.os.Bundle;

import com.mao.cn.mvpproject.R;
import com.mao.cn.mvpproject.component.AppComponent;
import com.mao.cn.mvpproject.component.DaggerOkhttpShowContentComponent;
import com.mao.cn.mvpproject.modules.OkhttpShowContentModule;
import com.mao.cn.mvpproject.ui.commons.BaseActivity;
import com.mao.cn.mvpproject.ui.features.IOkhttpShowContent;
import com.mao.cn.mvpproject.ui.presenter.OkhttpShowContentPresenter;

import javax.inject.Inject;
/**
* DESC   :
* AUTHOR : Xabad
*/
public class OkhttpShowContentActivity extends BaseActivity  implements IOkhttpShowContent {

    @Inject
    OkhttpShowContentPresenter presenter;

    @Override
    public void getArgs(Bundle bundle) {

    }

    @Override
    public int setView() {
        return R.layout.aty_okhttp_show_content;
    }

    @Override
    public void initView() {

    }

    @Override
    public void setListener() {

    }

    @Override
    protected void setupComponent(AppComponent appComponent) {
        DaggerOkhttpShowContentComponent.builder()
            .appComponent(appComponent)
            .okhttpShowContentModule(new OkhttpShowContentModule(this))
            .build().inject(this);
    }
}
