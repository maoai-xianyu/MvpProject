package com.mao.cn.mvpproject;

import android.app.Activity;

import com.mao.cn.mvpproject.common.CommApplication;
import com.mao.cn.mvpproject.component.AppComponent;
import com.mao.cn.mvpproject.component.DaggerAppComponent;
import com.mao.cn.mvpproject.domain.AnalyticsManager;
import com.mao.cn.mvpproject.modules.AppModule;
import com.mao.cn.mvpproject.utils.PreferenceU;
import com.mao.cn.mvpproject.utils.StringU;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.Map;

import javax.inject.Inject;

/**
 * Created by zhangkun on 2017/6/8.
 */

public class MvpApplication extends CommApplication {

    private static MvpApplication instance;
    private LinkedHashMap<String, Activity> activityMap = new LinkedHashMap<>();
    private static AppComponent component;
    @Inject
    AnalyticsManager analyticsManager;
    @Inject
    public PreferenceU preferenceU;

    @Override
    protected void initApplication() {

    }

    @Override
    protected void beforeCreate() {

    }

    @Override
    protected void afterOnCreate() {
        instance = this;
        component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        getComponent().inject(this);
        analyticsManager.registerAppEnter();

    }


    public static MvpApplication getInstance() {
        return instance;
    }

    public static AppComponent getComponent() {
        return component;
    }

    public static void addAty(Activity aty) {
        if (getInstance() == null) return;
        if (aty == null) return;
        if (getInstance().activityMap == null) getInstance().activityMap = new LinkedHashMap<>();
        getInstance().activityMap.put(aty.getLocalClassName(), aty);
    }

    public static void removeAty(Activity aty) {
        if (getInstance() != null && aty != null && getInstance().activityMap != null && getInstance().activityMap.keySet().contains(aty.getLocalClassName())) {
            getInstance().activityMap.remove(aty.getLocalClassName());
        }
    }

    /**
     * 根据传入的Activity名，判断该Activity是否已经被激活
     */
    public static boolean containsAty(String atyLocalClassName) {
        return StringU.isNotEmpty(atyLocalClassName) && getInstance() != null && getInstance().activityMap != null && getInstance().activityMap.keySet().contains(atyLocalClassName);
    }

    public static Activity getTopActivity() {
        if (getInstance().activityMap == null || getInstance().activityMap.size() == 0) return null;
        ListIterator<Map.Entry<String, Activity>> i = new ArrayList<>(getInstance().activityMap.entrySet()).listIterator(getInstance().activityMap.size());
        if (i.hasPrevious()) {
            Map.Entry<String, Activity> entry = i.previous();
            return entry.getValue();
        }
        return null;
    }

    private static void finishAty(Activity aty, String[] excludes) {
        if (aty != null && !aty.isFinishing() && !StringU.endsWithAny(aty.getLocalClassName(), excludes)) {
            aty.finish();
        }
    }

    public void finishCourseAty() {
        for (String key : activityMap.keySet()) {
            Activity aty = (activityMap.get(key));
            if (aty != null && !aty.isFinishing()) {
                if (StringU.endsWith(aty.getLocalClassName(), ".MainActivity"))
                    aty.finish();
            }
        }
    }
}
