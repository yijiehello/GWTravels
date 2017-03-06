package com.gwtravel.view.app;

import android.app.Application;
import android.graphics.Bitmap;

import com.gwtravel.R;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.https.HttpsUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;


/**
 * Created by yiheyu on 2016/11/23.
 */

public class ImageLoaderApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        init();

//        ClearableCookieJar cookieJar1 = new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(getApplicationContext()));

        HttpsUtils.SSLParams sslParams = HttpsUtils.getSslSocketFactory(null, null, null);

//        CookieJarImpl cookieJar1 = new CookieJarImpl(new MemoryCookieStore());
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
//                .addInterceptor(new LoggerInterceptor("TAG"))
//                .cookieJar(cookieJar1)
//                .hostnameVerifier(new HostnameVerifier()
//                {
//                    @Override
//                    public boolean verify(String hostname, SSLSession session)
//                    {
//                        return true;
//                    }
//                })
//                .sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager)
                .build();
        OkHttpUtils.initClient(okHttpClient);

    }

    private void init() {
        initImageLoader();
    }


    //初始化imageLoader
    public void initImageLoader()
    {
        //创建ImageLoaderConfiguration.Builder
        ImageLoaderConfiguration.Builder configBuilder = new ImageLoaderConfiguration.Builder(this);
        //配置相关信息
        configBuilder.diskCacheFileNameGenerator(new Md5FileNameGenerator())//sd卡缓存文件名字生成器
                .threadPoolSize(3)//设置下载线程池数量
                .threadPriority(Thread.NORM_PRIORITY-2)//设置图片线程优先级
                .denyCacheImageMultipleSizesInMemory() //设置不允许内存中存在同一图片的多个尺寸对象（只允许内存有且仅有一个指定图片的对象）
                .memoryCacheSize(2 * 1024 * 1024) //设置内存缓存大小
                .diskCacheFileCount(50) ;//设置缓存文件的总个数

        //初始化ImageLoader
        ImageLoader.getInstance().init(configBuilder.build());

    }

    //设置图片展示参数
    public DisplayImageOptions initDisplayImageOptions()
    {
        //创建DisplayImageOptions.Builder
        DisplayImageOptions.Builder optionsBuilder = new DisplayImageOptions.Builder();

        //设置相关的图片展示参数
        optionsBuilder.bitmapConfig(Bitmap.Config.RGB_565)
                .cacheInMemory(true)//允许内存缓存
                .cacheOnDisk(true) //允许SD卡缓存
                .imageScaleType(ImageScaleType.EXACTLY) //设置缩放模式
                .showImageOnLoading(R.mipmap.loading) //设置正在加载时显示的默认图片
                .showImageOnFail(R.mipmap.no_pic); //设置加载失败时展示的图片

        //实例化options
        return optionsBuilder.build();
    }
}
