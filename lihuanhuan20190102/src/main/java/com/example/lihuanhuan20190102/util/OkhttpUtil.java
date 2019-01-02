package com.example.lihuanhuan20190102.util;

import android.os.Handler;

import com.example.lihuanhuan20190102.api.UserApi;
import com.example.lihuanhuan20190102.net.OkhttpCallback;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class OkhttpUtil {
    //okhttp二次封装
    private static OkhttpUtil instance;
    private final OkHttpClient okHttpClient;
    Handler handler = new Handler();
    //私有构造
    private OkhttpUtil() {
        //拦截器
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(httpLoggingInterceptor.getLevel());

        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .readTimeout(5,TimeUnit.SECONDS)
                .connectTimeout(5,TimeUnit.SECONDS)
                .writeTimeout(5,TimeUnit.SECONDS)
                .build();
    }
    //post方法
    public void post(HashMap<String,String> map, final OkhttpCallback callback){
        FormBody.Builder formBody = new FormBody.Builder();
        for (Map.Entry<String, String> p : map.entrySet()) {
            formBody.add(p.getKey(),p.getValue());
        }
        Request request = new Request.Builder()
                .url(UserApi.Urlapi)
                .post(formBody.build())
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                if (callback!=null) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.onFailok("请求错误！");
                        }
                    });
                }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                if (callback!=null) {
                    if (200 == response.code()) {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                callback.onSuccessok(string);
                            }
                        });
                    }
                }
            }
        });
    };
    //单例模式
    public static OkhttpUtil getInstance(){
        if (instance==null){
            synchronized (OkhttpUtil.class){
                if (instance==null){
                    instance = new OkhttpUtil();
                }
            }
        }
        return instance;
    }
    public void cancel(){
        if (okHttpClient!=null){
            okHttpClient.dispatcher().cancelAll();
        }
    }
}
