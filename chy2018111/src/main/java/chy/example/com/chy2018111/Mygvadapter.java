package chy.example.com.chy2018111;

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

/**
 * Created by 卿为谁人醉 on 2018/1/12.
 */

public class Mygvadapter extends BaseAdapter {
    private Context context;
    private List<AnyBean.DataBean.ListBean> list;
    private DisplayImageOptions options;

    public Mygvadapter(Context context, List<AnyBean.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
        //使用内存缓存
//使用磁盘缓存
//设置正在下载的图片
//url为空或请求的资源不存在时
//下载失败时显示的图片
//设置图片色彩模式 1px=2字节
//设置图片的缩放模式
//设置圆角 30代表半径 自定义
        options = new DisplayImageOptions.Builder()
                .cacheInMemory(true)//使用内存缓存
                .cacheOnDisk(true)//使用磁盘缓存
                .showImageOnLoading(R.drawable.ic_launcher_foreground)//设置正在下载的图片
                .showImageForEmptyUri(R.drawable.ic_launcher_foreground)//url为空或请求的资源不存在时
                .showImageOnFail(R.drawable.ic_launcher_foreground)//下载失败时显示的图片
                .bitmapConfig(Bitmap.Config.RGB_565)//设置图片色彩模式 1px=2字节
                .imageScaleType(ImageScaleType.EXACTLY)//设置图片的缩放模式
                .displayer(new RoundedBitmapDisplayer(100))//设置圆角 30代表半径 自定义
                .build();
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
        ViewHolder1 holder1;
        if (convertView==null){
            holder1 = new ViewHolder1();
            convertView = View.inflate(context,R.layout.gv_item,null);
            holder1.tv3 = convertView.findViewById(R.id.tv3);
            holder1.img = convertView.findViewById(R.id.img);
            convertView.setTag(holder1);

        }else {
            holder1 = (ViewHolder1) convertView.getTag();
        }
        holder1.tv3.setText(list.get(position).getName());
        ImageLoader.getInstance().displayImage(list.get(position).getIcon(),holder1.img,options);

        return convertView;
    }
    class ViewHolder1{
        TextView tv3;
        ImageView img;
    }
}
