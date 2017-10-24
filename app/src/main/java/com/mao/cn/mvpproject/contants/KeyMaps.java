package com.mao.cn.mvpproject.contants;

/**
 * Created by zhangkun on 2017/6/9.
 */

public class KeyMaps {

    public static final class ServerInfoConfig {
        public static final String SERVER_INFO_CONFIG = "server_info_config";
    }

    public static final class ImagesAssetPath {

        public static final String PICASSO_DRAWABLE = "drawable://";
        public static final String PICASSO_ASSETS = "file:///android_asset/";
        public static final String PICASSO_FILE = "file://";


        public static final String FRESCO_ASSET = "asset:///"; // 需要3个/才能正常显示asset中的图片
        public static final String FRESCO_FILE = "file://";
        public static final String FRESCO_DRAWABLE = "res://";

    }
}
