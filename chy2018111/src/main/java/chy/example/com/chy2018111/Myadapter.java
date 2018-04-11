package chy.example.com.chy2018111;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.utils.L;

import java.util.List;

/**
 * Created by 卿为谁人醉 on 2018/1/12.
 */

public class Myadapter extends BaseAdapter {
private Context context;
private List<AnyBean.DataBean> listBeans;

    public Myadapter(Context context, List<AnyBean.DataBean> listBeans) {
        this.context = context;
        this.listBeans = listBeans;


    }

    @Override
    public int getCount() {
        return listBeans.size();
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
        ViewHolder holder;
        if (convertView==null){
            holder = new ViewHolder();
            convertView = View.inflate(context,R.layout.item_1,null);
            holder.tv1 = convertView.findViewById(R.id.tv1);
            holder.gv = convertView.findViewById(R.id.gv);
            convertView.setTag(holder);

        }else {
            holder = (ViewHolder) convertView.getTag();

        }
        holder.tv1.setText(listBeans.get(position).getName());
        List<AnyBean.DataBean.ListBean> list = listBeans.get(position).getList();
        holder.gv.setAdapter(new Mygvadapter(context,list));

        return convertView;
    }
    class ViewHolder{
        TextView tv1;
        GridView gv;
    }
}
