package com.example.cc.day1212;

import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Handler myHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            //获取当前正在显示的页面
            int index=viewPager.getCurrentItem();
            viewPager.setCurrentItem(index+1);

            //改变小圆点
            setSelectedPoint(index+1);

            //延迟发送消息
            sendEmptyMessageDelayed(1,2000);

        }
    };
    private ViewPager viewPager;
    private LinearLayout linPoint;
    private ImageView[] imgArray;

    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.vp);
        linPoint = (LinearLayout) findViewById(R.id.linpoint);


        //数据.....装的是path路径
        list = new ArrayList<>();
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1505151721118&di=649c9a43aed72fbc4d99ec1a031510c6&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F015c7d574b9f8f6ac72525aee98351.jpg");
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1505151956771&di=0eb6f306991d24b67a13ceb336f80102&imgtype=0&src=http%3A%2F%2Fi0.hdslb.com%2Fbfs%2Farchive%2F00613def3f1beb7a35ae136341be2b589bc46a2d.jpg_320x200.jpg");
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1505151847685&di=c7a4b5d08ec43fa629bcb690039a7629&imgtype=0&src=http%3A%2F%2Fattimg.dospy.com%2Fimg%2Fday_080625%2F20080625_2e91a10c444877e88827vri2ZKdGMvQo.jpg");
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1505151825129&di=70bf74b87d8a15cb91a2d79f15ed0eaf&imgtype=0&src=http%3A%2F%2Fattimg.dospy.com%2Fimg%2Fday_081016%2F20081016_fee215664d5740e56c13E2YB8giERFEX.jpg");
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1505746504&di=930c4d677a02328a142d6fa85ed14580&imgtype=jpg&er=1&src=http%3A%2F%2Fattimg.dospy.com%2Fimg%2Fday_090113%2F20090113_6ac58b42bea94f0b318e1B6BZb5lPZl5.jpg");

        imgArray=new ImageView[list.size()];

        viewPager.setAdapter(new MyPagerAdapter(this,list));

        //使页面 可以向左滑动
        viewPager.setCurrentItem(list.size()*100);

        //实现自动播放
        myHandler.sendEmptyMessageDelayed(1,2000);

        initPoint();

    }

    //0,1,2,3,4,......Integer.maxvalue
    public  void setSelectedPoint(int pageIndex){
        //循环imageview控件
        //计算要选中小圆点的下标
        int selectedIndex=pageIndex%list.size();

        for(int i=0;i<list.size();i++){
            if(i==selectedIndex){
                imgArray[i].setImageResource(R.drawable.my_point_selected);//小红点
            }else{
                imgArray[i].setImageResource(R.drawable.my_point_unselected);//小灰点
            }
        }

    }

    /**
     * 初使化小圆点
     */
    private void initPoint() {
        for(int i=0;i<list.size();i++){
            //第一步
            ImageView img=new ImageView(this);
            //图片的缩放方式
            img.setScaleType(ImageView.ScaleType.FIT_XY);
            if(i==0){
                //使用shape画小圆点
                img.setImageResource(R.drawable.my_point_selected);//第二步
            }else{
                img.setImageResource(R.drawable.my_point_unselected);
            }
            //img对象 设置控件的宽度与高度
            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(30,30);
            //设置右间隔 10px
            params.setMargins(0,0,10,0);
            //添加到容器中
            linPoint.addView(img,params);//第三步
            //添加到数组中
            imgArray[i]=img;

        }


    }
}
