package chy.example.com.day_ofnews.Fragmentpack;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.jane.mxlistview.view.XListView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import chy.example.com.day_ofnews.Adapter.Myadapter2;
import chy.example.com.day_ofnews.Adapter.Mypager;
import chy.example.com.day_ofnews.NewsBean.Juhebean;
import chy.example.com.day_ofnews.R;
import chy.example.com.day_ofnews.Util.MyTask;
import chy.example.com.day_ofnews.Util.NetUtil;

/**
 * Created by 卿为谁人醉 on 2018/1/8.
 */

public class Fragment03 extends Fragment {
    private XListView xListView;
    private ViewPager viewPager;
    private List<String> list;
    private String url = "http://v.juhe.cn/toutiao/index?type=top&key=89b6c98a78e2e7d365a06c380ffe38af";
    private int openType = 1;
    private List<Juhebean.ResultBean.DataBean> lists = new ArrayList<>();
    private Myadapter2 myadapter2;
    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int currentItem = viewPager.getCurrentItem();
            currentItem++;
            viewPager.setCurrentItem(currentItem);
            sendEmptyMessageDelayed(0,1000);
        }
    };
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment03,container,false);
       xListView = view.findViewById(R.id.xlv);
       viewPager = view.findViewById(R.id.viewpager);
       list = new ArrayList<>();
       list.add("http://pic.58pic.com/58pic/15/36/26/12J58PICuz4_1024.jpg");
       list.add("http://pic30.photophoto.cn/20140214/0036036862724947_b.jpg");
       list.add("http://img4.imgtn.bdimg.com/it/u=2245363424,2283929512&fm=214&gp=0.jpg");
       list.add("http://img3.imgtn.bdimg.com/it/u=1098621468,3298068712&fm=214&gp=0.jpg");
       viewPager.setAdapter(new Mypager(getActivity(),list));
       handler.sendEmptyMessage(0);



        initdata();
        requestNetData();
        return view;
    }

    private void requestNetData() {
        if (NetUtil.isConn(getActivity())){
            MyTask myTask = new MyTask(new MyTask.Icallbacks() {
                @Override
                public void updateUiByjson(String jsonstr) {
                    Gson gson = new Gson();
                    Juhebean juhebean = gson.fromJson(jsonstr, Juhebean.class);


                    if (openType==1){
                        lists.clear();
                    }
                    Log.d("-----",">"+juhebean.getResult().getData());
                    lists.addAll(juhebean.getResult().getData());
                    setadapter();
                    xListView.stopLoadMore();
                    xListView.stopRefresh();



                }


            });
            myTask.execute(url);
        }
    }

    public void setadapter() {
        if (myadapter2==null){
            myadapter2 = new Myadapter2(getActivity(),lists);
            xListView.setAdapter(myadapter2);
        }else {
            myadapter2.notifyDataSetChanged();
        }
    }
    private void initdata() {
        xListView.setPullLoadEnable(true);
        xListView.setPullRefreshEnable(true);
        xListView.setXListViewListener(new XListView.IXListViewListener() {
            @Override
            public void onRefresh() {
                openType = 1;
                url ="http://v.juhe.cn/toutiao/index?type=top&key=92a1c80201165be4bd5d49393164a922";
                requestNetData();

            }

            @Override
            public void onLoadMore() {
                url ="http://v.juhe.cn/toutiao/index?type=top&key=92a1c80201165be4bd5d49393164a922";
                requestNetData();
            }
        });



    }
}
