// +----------------------------------------------------------------------
// | Project:   MvpProject
// +----------------------------------------------------------------------
// | CreateTime: 08/04/2017 16:53 下午
// +----------------------------------------------------------------------
// | Author:     xab(xab@xabad.cn)
// +----------------------------------------------------------------------
// | Description:
// +----------------------------------------------------------------------
package com.mao.cn.mvpproject.component;

import com.mao.cn.mvpproject.component.commons.ActivityScope;
import com.mao.cn.mvpproject.interactors.RxjavaShowContentInteractor;
import com.mao.cn.mvpproject.modules.RxjavaShowContentModule;
import com.mao.cn.mvpproject.ui.activity.RxjavaShowContentActivity;
import com.mao.cn.mvpproject.ui.features.IRxjavaShowContent;
import com.mao.cn.mvpproject.ui.presenter.RxjavaShowContentPresenter;

import dagger.Component;

@ActivityScope

@Component(
    dependencies = AppComponent.class,
    modules = RxjavaShowContentModule.class
)
public interface RxjavaShowContentComponent {
    void inject(RxjavaShowContentActivity instance);

    IRxjavaShowContent getViewInterface();

    RxjavaShowContentPresenter getPresenter();

    RxjavaShowContentInteractor getRxjavaShowContentInteractor();

}
