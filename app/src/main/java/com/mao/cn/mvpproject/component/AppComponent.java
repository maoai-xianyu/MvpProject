package com.mao.cn.mvpproject.component;

import com.mao.cn.mvpproject.MvpApplication;
import com.mao.cn.mvpproject.modules.AppModule;
import com.mao.cn.mvpproject.modules.DomainModule;
import com.mao.cn.mvpproject.utils.tools.PreferenceU;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        AppModule.class,
        DomainModule.class
})
public interface AppComponent {
    void inject(MvpApplication instance);

    PreferenceU getPreferenceU();
}