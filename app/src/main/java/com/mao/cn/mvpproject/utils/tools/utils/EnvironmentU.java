package com.mao.cn.mvpproject.utils.tools.utils;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;

import java.io.File;

public class EnvironmentU {
    public EnvironmentU() {
    }

    public static File getExternalCacheDir(Context context) {
        if (VERSION.SDK_INT > 8) {
            return context.getExternalCacheDir();
        } else {
            String cacheDir = "/Android/data/" + context.getPackageName() + "/cache/";
            return new File(Environment.getExternalStorageDirectory().getPath() + cacheDir);
        }
    }

    public static boolean isExitsSdcard() {
        return Environment.getExternalStorageState() == null ? false : Environment.getExternalStorageState().equals("mounted");
    }
}