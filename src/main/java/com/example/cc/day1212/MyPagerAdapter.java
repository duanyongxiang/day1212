package com.example.cc.day1212;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;


/**
 * Created by e531 on 2017/11/13.
 */
public class MyPagerAdapter  extends PagerAdapter{


    private Context context;
//    private int[] imgArray=new int[]{R.mipmap.a0,R.mipmap.a1,R.mipmap.a2};
    //用于存放网络图片的url地址
    private List<String> imgUrl;


    public MyPagerAdapter(Context context,List<String> imgUrl) {
        this.context = context;
        this.imgUrl=imgUrl;
    }

    //返回页面的数量
    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    //0~getCount返回的值-1
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        //返回当前显示的视图
        ImageView imageView = new ImageView(context);
        //图片的绽放方式
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);

        //0,1,2
//        imageView.setImageResource(imgArray[position%imgArray.length]);

        //使用ImageLoader下载图片
        ImageLoader.getInstance().displayImage(imgUrl.get(position%imgUrl.size()),
                imageView, ImageUtils.getImageOptions());


        //添加到容器
        container.addView(imageView);

        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((View) object);
    }
}
