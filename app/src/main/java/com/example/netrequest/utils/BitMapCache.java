package com.example.netrequest.utils;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.toolbox.ImageLoader.ImageCache;

/**
 * 
* <p>Title: BitMapCache</p>
* <p>Description: 	图片缓存处理类	</p>
* <p>Company: maxrocky</p>
* @author    earl
* @date       2015-11-12
 */
public class BitMapCache implements ImageCache{

	//注意图片缓存原来LruCache 类实现的
	public LruCache<String, Bitmap> cache;
	//超过10兆，自动回收
	public int max = 10*1024*1024;
	public BitMapCache(){
		cache = new LruCache<String, Bitmap>(max){
			@Override
			protected int sizeOf(String key, Bitmap value) {
				return value.getRowBytes()*value.getHeight();
			}
		};
	}
	@Override
	public Bitmap getBitmap(String arg0) {
		return cache.get(arg0);
	}

	@Override
	public void putBitmap(String arg0, Bitmap arg1) {
		cache.put(arg0, arg1);
	}
	

}
