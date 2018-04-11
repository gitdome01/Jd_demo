package chy.example.com.chy20180115.Fragmentbag;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

import chy.example.com.chy20180115.AdapterBag.Myadapter;
import chy.example.com.chy20180115.Beans.Newsbaen;
import chy.example.com.chy20180115.R;
import chy.example.com.chy20180115.Util.MyTask;
import chy.example.com.chy20180115.Util.NetUtil;

/**
 * Created by 卿为谁人醉 on 2018/1/15.
 */

public class Fragment05 extends Fragment {
    private PullToRefreshListView plv;
    private String url;
    private int openType=1;
    private List<Newsbaen.ResultBean.DataBean> list = new ArrayList<>();
    private Myadapter myadapter;
    private List<Newsbaen.ResultBean.DataBean> data;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment05,container,false);
        plv = view.findViewById(R.id.plv);
        Bundle arguments = getArguments();
        url = arguments.getString("url");
        Log.i("----",">"+url);

        initPlv();
        requestNetData();

        return view;
    }
//获取数据
    private void requestNetData() {
        if (NetUtil.isConn(getActivity())){
            MyTask myTask = new MyTask(new MyTask.Icallbacks() {
                @Override
                public void updateUiByjson(String jsonstr) {
                    Gson gson = new Gson();
                    Newsbaen newsbaen = gson.fromJson(jsonstr, Newsbaen.class);
                    data = newsbaen.getResult().getData();
//                    Log.d("----",">"+data.size());
                    if (openType==1){
                        list.clear();
                    }

                    list.addAll(newsbaen.getResult().getData());
                    setadapter();
                    plv.onRefreshComplete();

                }
            });
            myTask.execute(url);
        }else {
            NetUtil.openNetDialog(getActivity());
        }

    }

    private void setadapter() {
       if (myadapter==null){
           myadapter = new Myadapter(getActivity(),data);
           plv.setAdapter(myadapter);
       }else {
           myadapter.notifyDataSetChanged();
       }
    }


    //初始化view
    private void initPlv() {
        plv.setMode(PullToRefreshBase.Mode.BOTH);

        //2.设置头尾布局显示的文字
        ILoadingLayout startLabels = plv.getLoadingLayoutProxy(true, false);
        startLabels.setPullLabel("下拉刷新");//第一次下拉时显示的文字
        startLabels.setRefreshingLabel("正在拉");//下拉的过程中显示的文字
        startLabels.setReleaseLabel("放开刷新");//不能在下拉时，显示的文字

        ILoadingLayout endLabels = plv.getLoadingLayoutProxy(false, true);
        endLabels.setPullLabel("加载中...");
        endLabels.setRefreshingLabel("正在载入你关心的新闻。。。");
        endLabels.setReleaseLabel("放开刷新...");
        plv.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {

            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                openType=1;
                requestNetData();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                openType=2;
                requestNetData();
            }
        });
    }
}
