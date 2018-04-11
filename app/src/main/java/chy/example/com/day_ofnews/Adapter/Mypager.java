package chy.example.com.day_ofnews.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;

import java.util.List;

/**
 * Created by 卿为谁人醉 on 2018/1/12.
 */

public class Mypager extends PagerAdapter {
    private Context context;
    private List<String> list;
    private DisplayImageOptions options;

    public Mypager(Context context, List<String> list) {
        this.context = context;
        this.list = list;
        //使用内存缓存
//使用磁盘缓存
//设置图片色彩模式
//设置图片的缩放模式
        options = new DisplayImageOptions.Builder()
                 .cacheInMemory(true)//使用内存缓存
                 .cacheOnDisk(false)//使用磁盘缓存
                 .bitmapConfig(Bitmap.Config.RGB_565)//设置图片色彩模式
                 .imageScaleType(ImageScaleType.EXACTLY)//设置图片的缩放模式
                 .build();
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
        ImageLoader.getInstance().displayImage(list.get(position%list.size()),imageView,options);
        container.addView(imageView);

        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
