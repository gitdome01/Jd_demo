package chy.example.com.chy20180115.AdapterBag;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import chy.example.com.chy20180115.Beans.Newsbaen;
import chy.example.com.chy20180115.R;
import chy.example.com.chy20180115.Util.Imageutil;

/**
 * Created by 卿为谁人醉 on 2018/1/15.
 */

public class Myadapter extends BaseAdapter {
    private Context context;
    private List<Newsbaen.ResultBean.DataBean> list;
    public final int TYPEONE=0;
    public final int TYPETWO=1;
    public final int TYPETHERE=2;


    public Myadapter(Context context, List<Newsbaen.ResultBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }

    @Override
    public int getItemViewType(int position) {
        String pic = list.get(position).getThumbnail_pic_s();
        String pic2 = list.get(position).getThumbnail_pic_s02();
        String pic03 = list.get(position).getThumbnail_pic_s03();
        if (pic!=null&&pic2==null&&pic03==null){
            return TYPEONE;
        }else if (pic!=null&&pic2!=null&&pic03==null){
            return TYPETWO;
        }else {
            return TYPETHERE;
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
        if (itemViewType==TYPEONE){
            ViewHolder holder;
            if (convertView==null){
                holder = new ViewHolder();
                convertView = View.inflate(context, R.layout.item_1,null);
                holder.ti1 = convertView.findViewById(R.id.tv1);
                holder.img = convertView.findViewById(R.id.img);
                convertView.setTag(holder);
            }else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.ti1.setText(list.get(position).getTitle());
            ImageLoader.getInstance().displayImage(list.get(position).getThumbnail_pic_s(),holder.img, Imageutil.getImageOptions(context));
            return convertView;
        }else if (itemViewType==TYPETWO){
            ViewHolder2 holder2;
            if (convertView==null){
                holder2 = new ViewHolder2();
                convertView = View.inflate(context,R.layout.item_2,null);
                holder2.ti1 = convertView.findViewById(R.id.tv2);
                holder2.img = convertView.findViewById(R.id.img2);
                holder2.img2 = convertView.findViewById(R.id.img3);
                convertView.setTag(holder2);
            }else {
                holder2 = (ViewHolder2) convertView.getTag();
            }
            holder2.ti1.setText(list.get(position).getTitle());
            ImageLoader.getInstance().displayImage(list.get(position).getThumbnail_pic_s(),holder2.img,Imageutil.getImageOptions(context));
            ImageLoader.getInstance().displayImage(list.get(position).getThumbnail_pic_s02(),holder2.img2,Imageutil.getImageOptions(context));
            return convertView;
        }else {
            ViewHolder3 holder3;
            if (convertView==null){
                holder3 = new ViewHolder3();
                convertView = View.inflate(context,R.layout.item_3,null);
                holder3.ti1 = convertView.findViewById(R.id.tv3);
                holder3.img = convertView.findViewById(R.id.img4);
                holder3.img2 = convertView.findViewById(R.id.img5);
                holder3.img3 = convertView.findViewById(R.id.img6);
                convertView.setTag(holder3);

            }else {
                holder3 = (ViewHolder3) convertView.getTag();
            }
            holder3.ti1.setText(list.get(position).getTitle());
            ImageLoader.getInstance().displayImage(list.get(position).getThumbnail_pic_s(),holder3.img,Imageutil.getImageOptions(context));
            ImageLoader.getInstance().displayImage(list.get(position).getThumbnail_pic_s02(),holder3.img2,Imageutil.getImageOptions(context));
            ImageLoader.getInstance().displayImage(list.get(position).getThumbnail_pic_s02(),holder3.img3,Imageutil.getImageOptions(context));
            return convertView;
        }

    }
    class ViewHolder{
        TextView ti1;
        ImageView img;
    }
    class ViewHolder2{
        TextView ti1;
        ImageView img,img2;
    }
    class ViewHolder3{
        TextView ti1;
        ImageView img,img2,img3;
    }
}
