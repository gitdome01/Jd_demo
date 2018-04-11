package chy.example.com.chy2018111;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import java.util.List;

/**
 * Created by 卿为谁人醉 on 2018/1/11.
 */

public class Mypageradapter extends PagerAdapter{
    private Context context;
    private List<String> picurl;


    public Mypageradapter(Context context, List<String> picurl) {
        this.context = context;
        this.picurl = picurl;
        //使用内存缓存
//使用磁盘缓存
//设置图片色彩模式 1px=2字节
//设置图片的缩放模式
//设置圆角 30代表半径 自定义

    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        ImageView imageView = new ImageView(context);
        ImageLoader.getInstance().displayImage(picurl.get(position%picurl.size()),imageView,Imageutil.getImageOptions(context));
        container.addView(imageView);

        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
