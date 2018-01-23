package com.example.cc.day1212;

import android.content.Context;
import android.graphics.Bitmap;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;

import java.io.File;

/**
 * Created by e531 on 2017/11/13.
 */
public class ImageUtils {

    /**
     * 对ImageLoader进行初使化
     * @param context
     */
    public static void initImageLoader(Context context){

        File cacheFile=context.getExternalCacheDir();//android认为的缓存目录

        ImageLoaderConfiguration configuration=new ImageLoaderConfiguration.Builder(context)
                .memoryCacheExtraOptions(480, 800)//缓存图片最大的长和宽
                .threadPoolSize(2)//线程池的数量
                .threadPriority(4)
                .memoryCacheSize(2*1024*1024)//设置内存缓存区大小
                .diskCacheSize(20*1024*1024)//设置sd卡缓存区大小
                .diskCache(new UnlimitedDiscCache(cacheFile))//自定义缓存目录
                .writeDebugLogs()//打印日志内容
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())//给缓存的文件名进行md5加密处理
                .build();

        ImageLoader.getInstance().init(configuration);

    }

    /**
     * 得到图片的显示设置类
     * @return
     */
    public static DisplayImageOptions getImageOptions(){

        DisplayImageOptions options=new DisplayImageOptions.Builder()
                .cacheInMemory(true)//使用内存缓存
                .cacheOnDisk(true)//使用磁盘缓存
                .bitmapConfig(Bitmap.Config.RGB_565)//设置图片的色彩模式
                .imageScaleType(ImageScaleType.EXACTLY)//设置图片的缩放方式
                .build();
        return options;

    }


}
