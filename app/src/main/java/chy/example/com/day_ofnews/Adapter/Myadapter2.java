package chy.example.com.day_ofnews.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import java.util.List;

import chy.example.com.day_ofnews.NewsBean.Juhebean;
import chy.example.com.day_ofnews.R;

/**
 * Created by 卿为谁人醉 on 2018/1/12.
 */

public class Myadapter2 extends BaseAdapter{
    private Context context;
    private List<Juhebean.ResultBean.DataBean> lists;
    private DisplayImageOptions options;
    public final int TYPEONE=0;
    public final int TYPETWO=1;
    public final int TYPEOTHERE=2;

    public Myadapter2(Context context, List<Juhebean.ResultBean.DataBean> lists) {
        this.context = context;
        this.lists = lists;
        //使用内存缓存
//使用磁盘缓存
//设置图片色彩模式 1px=2字节
//设置图片的缩放模式
//设置圆角 30代表半径 自定义
        options = new DisplayImageOptions.Builder()
                 .cacheInMemory(true)//使用内存缓存
                 .cacheOnDisk(true)//使用磁盘缓存

                 .bitmapConfig(Bitmap.Config.RGB_565)//设置图片色彩模式 1px=2字节
                 .imageScaleType(ImageScaleType.EXACTLY)//设置图片的缩放模式

                 .build();
    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }

    @Override
    public int getItemViewType(int position) {
        String pic = lists.get(position).getThumbnail_pic_s();
        String pic02 = lists.get(position).getThumbnail_pic_s02();
        String pic03 = lists.get(position).getThumbnail_pic_s03();
        if (pic!=null&&pic02==null&&pic03==null){
            return TYPEONE;
        }else if (pic!= null&&pic02!=null&&pic03==null){
            return TYPETWO;
        }else {
            return TYPEOTHERE;
        }
    }

    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int itemViewType = getItemViewType(position);
        if (itemViewType==TYPEONE) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = View.inflate(context, R.layout.item_3, null);
                holder.ta = convertView.findViewById(R.id.wenzi);
                holder.img = convertView.findViewById(R.id.tupian);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.ta.setText(lists.get(position).getTitle());
            ImageLoader.getInstance().displayImage(lists.get(position).getThumbnail_pic_s(),holder.img,options);
            return convertView;
        }else if (itemViewType==TYPETWO){
            ViewHolder2 holder2;
            if (convertView == null) {
                holder2 = new ViewHolder2();
                convertView = View.inflate(context, R.layout.item_4, null);
                holder2.ta = convertView.findViewById(R.id.wenzi3);
                holder2.img = convertView.findViewById(R.id.tupian2);
                holder2.img2 = convertView.findViewById(R.id.tupian3);
                convertView.setTag(holder2);
            } else {
                holder2 = (ViewHolder2) convertView.getTag();
            }
            holder2.ta.setText(lists.get(position).getTitle());
            ImageLoader.getInstance().displayImage(lists.get(position).getThumbnail_pic_s(),holder2.img,options);
            ImageLoader.getInstance().displayImage(lists.get(position).getThumbnail_pic_s02(),holder2.img2,options);
            return convertView;
        }else {
            ViewHolder3 holder3;
            if (convertView == null) {
                holder3 = new ViewHolder3();
                convertView = View.inflate(context, R.layout.item_5, null);
                holder3.ta = convertView.findViewById(R.id.wenzi2);
                holder3.img = convertView.findViewById(R.id.tupian4);
                holder3.img2 = convertView.findViewById(R.id.tupian5);
                holder3.img3 = convertView.findViewById(R.id.tupian6);
                convertView.setTag(holder3);
            } else {
                holder3 = (ViewHolder3) convertView.getTag();
            }
            holder3.ta.setText(lists.get(position).getTitle());
            ImageLoader.getInstance().displayImage(lists.get(position).getThumbnail_pic_s(),holder3.img,options);
            ImageLoader.getInstance().displayImage(lists.get(position).getThumbnail_pic_s02(),holder3.img2,options);
            ImageLoader.getInstance().displayImage(lists.get(position).getThumbnail_pic_s03(),holder3.img3,options);
            return convertView;
        }
    }
    class ViewHolder{
        TextView ta;
        ImageView img;
    }
    class ViewHolder2{
        TextView ta;
        ImageView img;
        ImageView img2;
    }
    class ViewHolder3{
        TextView ta;
        ImageView img;
        ImageView img2;
        ImageView img3;
    }
}
