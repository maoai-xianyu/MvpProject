package com.mao.cn.mvpproject.utils.network;

import android.net.Uri;

import java.util.concurrent.TimeUnit;

import okhttp3.CacheControl;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * author:  zhangkun .
 * date:    on 2017/8/7.
 */

public class OKHttpClientFactory {
    private static OkHttpClient client;
    private static OKHttpClientFactory mInstance;


    public OKHttpClientFactory() {
        if (client == null)
            client = defaultOkHttpClient();
    }

    public static OKHttpClientFactory getInStance() {
        if (mInstance == null) {
            synchronized (OKHttpClientFactory.class) {
                if (mInstance == null) {
                    mInstance = new OKHttpClientFactory();
                }
            }
        }
        return mInstance;
    }

    private static OkHttpClient defaultOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(1000 * 30, TimeUnit.MILLISECONDS)
                .readTimeout(1000 * 15, TimeUnit.MILLISECONDS)
                .writeTimeout(1000 * 30, TimeUnit.MILLISECONDS);
        return builder.build();
    }

    public void get(String url, Callback callback) {
        Request request = new Request.Builder().url(url).get().build();
        new OkHttpClient().newCall(request).enqueue(callback);
    }

    public Response download(Uri uri) throws Exception {
        CacheControl cacheControl = CacheControl.FORCE_NETWORK;
        Request.Builder builder = new Request.Builder().url(uri.toString());
        if (cacheControl != null) {
            builder.cacheControl(cacheControl);
        }
        return client.newCall(builder.build()).execute();
    }

    public Response post(String uri, Headers headers, String data) throws Exception {
        uri = Uri.parse(uri).toString();
        CacheControl cacheControl = CacheControl.FORCE_NETWORK;
        Request.Builder builder = new Request.Builder();
        if (headers != null && headers.size() > 0) {
            builder.headers(headers);
        }

        RequestBody requestBody = RequestBody.create(MediaType.parse("text/xml;charset=utf-8"), data.getBytes("utf-8"));
        builder.post(requestBody).url(uri);
        if (cacheControl != null) {
            builder.cacheControl(cacheControl);
        }
        Request request = builder.build();
        return client.newCall(request).execute();
    }

    public Response postJson(String uri, Headers headers, String data) throws Exception {
        uri = Uri.parse(uri).toString();
        CacheControl cacheControl = CacheControl.FORCE_NETWORK;
        Request.Builder builder = new Request.Builder();
        if (headers != null && headers.size() > 0) {
            builder.headers(headers);
        }

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=utf-8"), data.getBytes("utf-8"));
        builder.post(requestBody).url(uri);
        if (cacheControl != null) {
            builder.cacheControl(cacheControl);
        }
        Request request = builder.build();
        return client.newCall(request).execute();
    }

    public void postJson(String uri, Headers headers, String data, String token, Callback callback) throws Exception {
        uri = Uri.parse(uri).toString() + "?access_token=" + token;
        CacheControl cacheControl = CacheControl.FORCE_NETWORK;
        Request.Builder builder = new Request.Builder();
        if (headers != null && headers.size() > 0) {
            builder.headers(headers);
        }
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=utf-8"), data.getBytes("utf-8"));
        builder.post(requestBody).url(uri);
        if (cacheControl != null) {
            builder.cacheControl(cacheControl);
        }
        Request request = builder.build();
        client.newCall(request).enqueue(callback);
    }

    public Response postData(String uri, Headers headers, RequestBody requestBody) throws Exception {
        uri = Uri.parse(uri).toString();
        CacheControl cacheControl = CacheControl.FORCE_NETWORK;
        Request.Builder builder = new Request.Builder();
        if (headers != null && headers.size() > 0) {
            builder.headers(headers);
        }
        if (requestBody != null)
            builder.post(requestBody);
        builder.url(uri);
        if (cacheControl != null) {
            builder.cacheControl(cacheControl);
        }
        Request request = builder.build();
        return client.newCall(request).execute();
    }

}
