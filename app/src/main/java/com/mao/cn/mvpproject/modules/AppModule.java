package com.mao.cn.mvpproject.modules;

import android.app.Application;

import com.mao.cn.mvpproject.MvpApplication;
import com.mao.cn.mvpproject.utils.PreferenceU;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private final MvpApplication app;

    public AppModule(MvpApplication app) {
        this.app = app;
    }

    @Provides
    @Singleton
    public Application provideApplication() {
        return MvpApplication.getInstance();
    }

    @Provides
    @Singleton
    PreferenceU providePreferenceU() {
        return PreferenceU.getInstance(MvpApplication.context());
    }

}