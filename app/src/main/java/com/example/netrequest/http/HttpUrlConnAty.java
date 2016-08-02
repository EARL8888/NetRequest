package com.example.netrequest.http;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.example.netrequest.R;
import com.example.netrequest.utils.HttpThread;


/**
 * <p>Title: HttpUrlConnAty</p>
 * <p>Description: 	HttpUrlConnAty 加载网络
 * 本类主要是通过HttpThread 实现网络请求的	</p>
 * <p>Company: maxrocky</p>
 *
 * @author earl
 * @date 2015-11-12
 */
public class HttpUrlConnAty extends Activity {

    private ImageView imageView;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.http_url_conn);
        imageView = (ImageView) findViewById(R.id.imageView);
        new HttpThread("http://img.mukewang.com/552640c300018a9606000338-300-170.jpg", imageView, handler).start();
    }
}
