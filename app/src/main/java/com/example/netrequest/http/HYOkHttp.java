package com.example.netrequest.http;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.netrequest.R;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.BitmapCallback;

import okhttp3.Call;

/**
 * 作者：earl on 16/08/02 16:59
 * 邮箱：z604458675@gmail.com
 * 描述：国内大神封装好的OkHttp，直接调用即可
 * https://github.com/hongyangAndroid/okhttputils
 */
public class HYOkHttp extends Activity {
    private static String url = "http://img.mukewang.com/55237dcc0001128c06000338-300-170.jpg";
    private ImageView iv_img;
    private ProgressBar pb_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hy_ok_http);
        iv_img = (ImageView) findViewById(R.id.iv_img);
        pb_bar = (ProgressBar) findViewById(R.id.pb_bar);
        pb_bar.setVisibility(View.VISIBLE);
        /**
         * 一切源于回调
         */
        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(new BitmapCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                    }

                    @Override
                    public void onResponse(Bitmap response, int id) {
                        iv_img.setImageBitmap(response);
                        pb_bar.setVisibility(View.GONE);
                    }
                });
    }
}
