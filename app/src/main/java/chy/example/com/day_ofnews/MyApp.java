package chy.example.com.day_ofnews;

import android.app.Application;
import android.os.Environment;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.io.File;

/**
 * Created by 卿为谁人醉 on 2018/1/11.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //自定义sd卡缓存目录 1.android默认cache-app被卸载时，缓存的目录一并被删除    2.自定义
//        File cachefile=getExternalCacheDir();
        File cachefile= new File(Environment.getExternalStorageDirectory().getPath()+"/images");
        //1.初使化--进行一下全局配置 Application
        ImageLoaderConfiguration configuration=new ImageLoaderConfiguration.Builder(this)
                .memoryCacheExtraOptions(400, 700)//缓存图片最大的长和宽
                .threadPoolSize(3)//线程池的数量
                .threadPriority(4)
                .memoryCacheSize(20*1024*1024)//设置内存缓存区大小
                .diskCacheSize(80*1024*1024)//设置sd卡缓存区大小
                .diskCache(new UnlimitedDiscCache(cachefile))//自定义sd卡缓存目录
                .writeDebugLogs()//打印日志内容
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())//给缓存的文件名进行md5加密处理
                .build();
        ImageLoader.getInstance().init(configuration);
    }
}
