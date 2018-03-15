package com.itsm.xkitsm.piwen.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.itsm.xkitsm.piwen.R;


/**
 * ProjectName: GlideUtils
 * Description: 图片加载器
 * <p>
 * review by chenpan, wangkang, wangdong 2017/8/24
 * edit by JeyZheng 2017/8/24
 * author: JeyZheng
 * version: 4.0
 * created at: 2017/8/24 17:57
 */
public class GlideUtils {
    /**
     * 缓存加载图片
     *
     * @param context
     * @param imgUrl
     * @param imageView
     */
    public static void loadImg(Context context, String imgUrl, ImageView imageView) {
        Glide.with(context).load(imgUrl)
                .skipMemoryCache(false)                             // 内存缓存（默认，可不加）
                .diskCacheStrategy(DiskCacheStrategy.ALL)           // 硬盘缓存（默认，可不加）
                .crossFade()
//                .centerCrop()
                .placeholder(R.mipmap.place_holder)
//                .placeholder(R.mipmap.loading_animimation)
                .into(imageView);
    }

    /**
     * 无缓存加载图片
     *
     * @param context
     * @param imgUrl
     * @param imageView
     */
    public static void loadImgNoCache(Context context, String imgUrl, ImageView imageView) {
        Glide.with(context).load(imgUrl)
                .skipMemoryCache(true)                                  // 跳过内存缓存
                .diskCacheStrategy(DiskCacheStrategy.NONE)              // 跳过硬盘缓存
                .crossFade()
                .placeholder(R.mipmap.place_holder)
                .into(imageView);
    }
}
