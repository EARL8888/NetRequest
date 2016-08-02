package com.example.netrequest.http;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.zhy.http.okhttp.OkHttpUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;


public class MyApplication extends Application {
    public static RequestQueue queue;

    @Override
    public void onCreate() {
        super.onCreate();
        queue = Volley.newRequestQueue(getApplicationContext());

        // 创建默认的ImageLoader配置参数
        ImageLoaderConfiguration configuration = ImageLoaderConfiguration
                .createDefault(this);

        // Initialize ImageLoader with configuration.  
        ImageLoader.getInstance().init(configuration);

        initOkhttp();
    }

    public static RequestQueue getHttpRequestQueue() {

        return queue;
    }

    /**
     * 默认情况下，将直接使用okhttp默认的配置生成OkhttpClient，
     * 如果你有任何配置，记得在Application中调用initClient方法进行设置。
     */
    private void initOkhttp() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                //                .addInterceptor(new LoggerInterceptor("TAG"))
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                //其他配置
                .build();

        OkHttpUtils.initClient(okHttpClient);
    }
}
