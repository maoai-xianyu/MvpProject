package com.mao.cn.mvpproject.utils.config;

import com.mao.cn.mvpproject.BuildConfig;

/**
 * author:  zhangkun .
 * date:    on 2017/8/1.
 */

public class Config {

    public static final String DEFAULT_SERVER_NAME = "正式服务器";
    public static final String DEFAULT_SERVER_HOST = "https://api.top.movie/";
    public static final String DEFAULT_SERVER_APIURL_RECOMMEND = "http://base.top.movie/";

    public static final String URL_ASSETS = BuildConfig.ASSETS_URL;
    public static final String HEADER_MAO= "x-be-product: cn" +
            ".xx.xxx.xxxx:" + BuildConfig.VERSION_NAME;
    public static final String VERSION = "version:android_" + BuildConfig.VERSION_NAME + "_build" + BuildConfig.VERSION_CODE;

}
