// +----------------------------------------------------------------------
// | Project:   MvpProject
// +----------------------------------------------------------------------
// | CreateTime: 06/09/2017 11:16 上午
// +----------------------------------------------------------------------
// | Author:     xab(xab@xabad.cn)
// +----------------------------------------------------------------------
// | Description:
// +----------------------------------------------------------------------
package com.mao.cn.mvpproject.component;

import com.mao.cn.mvpproject.component.commons.ActivityScope;
import com.mao.cn.mvpproject.interactors.MainInteractor;
import com.mao.cn.mvpproject.modules.MainModule;
import com.mao.cn.mvpproject.ui.activity.MainActivity;
import com.mao.cn.mvpproject.ui.features.IMain;
import com.mao.cn.mvpproject.ui.presenter.MainPresenter;

import dagger.Component;

@ActivityScope

@Component(
    dependencies = AppComponent.class,
    modules = MainModule.class
)
public interface MainComponent {
    void inject(MainActivity instance);

    IMain getViewInterface();

    MainPresenter getPresenter();

    MainInteractor getMainInteractor();

}
