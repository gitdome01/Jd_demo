package chy.example.com.day_ofnews.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;

import java.util.List;

import chy.example.com.day_ofnews.NewsBean.Nes;
import chy.example.com.day_ofnews.R;

/**
 * Created by 卿为谁人醉 on 2018/1/10.
 */

public class Myadapter extends BaseAdapter {
    private Context context;
    private List<Nes.DataBean> list;
    private DisplayImageOptions options;
    public final int TYPEONE = 0;
    public final int TYPETWO = 1;

//    public final int TYPETHERE = 2;

    public Myadapter(Context context, List<Nes.DataBean> list) {
        this.context = context;
        this.list = list;

        //使用内存缓存
//使用磁盘缓存
//设置正在下载的图片
//url为空或请求的资源不存在时
//下载失败时显示的图片
//设置图片色彩模式 1px=2字节
//设置图片的缩放模式
//.displayer(new RoundedBitmapDisplayer(100))//设置圆角 30代表半径 自定义
        options = new DisplayImageOptions.Builder()
                 .cacheInMemory(true)//使用内存缓存
                 .cacheOnDisk(true)//使用磁盘缓存

                 .bitmapConfig(Bitmap.Config.RGB_565)//设置图片色彩模式 1px=2字节
                 .imageScaleType(ImageScaleType.EXACTLY)//设置图片的缩放模式
                 //.displayer(new RoundedBitmapDisplayer(100))//设置圆角 30代表半径 自定义
                 .build();
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        List<Nes.DataBean.LargeImageListBean> large_image_list = list.get(position).getLarge_image_list();


        if (large_image_list==null){
            return TYPEONE;
        }else {
            return TYPETWO;
        }



    }

    @Override
    public int getCount() {
        return list.size();
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

        if (itemViewType == TYPEONE) {
            ViewHolder2 holder2 = null;
            if (convertView == null) {
                holder2 = new ViewHolder2();
                convertView = View.inflate(context, R.layout.item_2, null);
                holder2.tv2 = convertView.findViewById(R.id.tv15);

                convertView.setTag(holder2);
            } else {
                holder2 = (ViewHolder2) convertView.getTag();
            }
            holder2.tv2.setText(list.get(position).getTitle());



            return convertView;
        }else {
            ViewHolder holder = null;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = View.inflate(context, R.layout.item_1, null);
                holder.tv1 = convertView.findViewById(R.id.textView);
                holder.img = convertView.findViewById(R.id.imageView2);
                holder.img1 = convertView.findViewById(R.id.imageView3);
                holder.img2 = convertView.findViewById(R.id.imageView4);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.tv1.setText(list.get(position).getTitle());

            List<Nes.DataBean.LargeImageListBean.UrlListBeanXXX> url_list = list.get(position).getLarge_image_list().get(0).getUrl_list();
            if(url_list.size()==1){
                ImageLoader.getInstance().displayImage(list.get(position).getLarge_image_list().get(0).getUrl_list().get(0).getUrl(), holder.img, options);
            }else if (url_list.size()==2){
                ImageLoader.getInstance().displayImage(list.get(position).getLarge_image_list().get(0).getUrl_list().get(0).getUrl(), holder.img, options);
                ImageLoader.getInstance().displayImage(list.get(position).getLarge_image_list().get(0).getUrl_list().get(1).getUrl(), holder.img1, options);
            }else {
                ImageLoader.getInstance().displayImage(list.get(position).getLarge_image_list().get(0).getUrl_list().get(0).getUrl(), holder.img, options);
                ImageLoader.getInstance().displayImage(list.get(position).getLarge_image_list().get(0).getUrl_list().get(1).getUrl(), holder.img1, options);
                ImageLoader.getInstance().displayImage(list.get(position).getLarge_image_list().get(0).getUrl_list().get(2).getUrl(), holder.img2, options);
            }






            return convertView;

        }
    }
    class ViewHolder{
  TextView tv1;
  ImageView img;
        ImageView img1;
        ImageView img2;

    }
    class ViewHolder2{
        TextView tv2;
    }
}
