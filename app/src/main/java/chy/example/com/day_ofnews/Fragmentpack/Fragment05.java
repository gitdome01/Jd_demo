package chy.example.com.day_ofnews.Fragmentpack;

import android.os.AsyncTask;
import android.os.Bundle;
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

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import chy.example.com.day_ofnews.Adapter.Myadapter;
import chy.example.com.day_ofnews.NewsBean.Nes;
import chy.example.com.day_ofnews.R;
import chy.example.com.day_ofnews.Util.MyTask;
import chy.example.com.day_ofnews.Util.NetUtil;
import chy.example.com.day_ofnews.Util.StreamToString;


/**
 * Created by 卿为谁人醉 on 2018/1/9.
 */

public class Fragment05 extends Fragment {


    private String url;
    private int pagerIndex = 1;
    private int openType=1;
    private PullToRefreshListView pullToRefreshListView;
   private List<Nes.DataBean> list = new ArrayList<>();
    Myadapter myadapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment05,container,false);
        pullToRefreshListView = view.findViewById(R.id.plv);

        Bundle arguments = getArguments();
        url = arguments.getString("news");
        Log.d("zzzz","----->"+ url);

        initPlv();
        requestNetData();

        return view;
    }

    private void requestNetData() {
if (NetUtil.isConn(getActivity())){
    MyTask myTask = new MyTask(new MyTask.Icallbacks() {
        @Override
        public void updateUiByjson(String jsonstr) {
            Log.i("-----",">"+jsonstr);
          Gson gson = new Gson();
            Nes nes = gson.fromJson(jsonstr, Nes.class);
            List<Nes.DataBean> data = nes.getData();
            Log.i("-----",">"+data);
            if (openType==1){
                list.clear();
            }
            list.addAll(nes.getData());
            Log.i("-----",">"+nes.getData());
            setadapter();
            pullToRefreshListView.onRefreshComplete();
        }

    });
    myTask.execute(url);
}else {
    NetUtil.openNetDialog(getActivity());
}
    }
    public void setadapter(){
        if (myadapter==null){
            myadapter = new Myadapter(getActivity(),list);
            pullToRefreshListView.setAdapter(myadapter);
        }else {
            myadapter.notifyDataSetChanged();
        }
    }

    private void initPlv() {
        pullToRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);

        //2.设置头尾布局显示的文字
        ILoadingLayout startLabels = pullToRefreshListView.getLoadingLayoutProxy(true, false);
        startLabels.setPullLabel("下拉刷新");//第一次下拉时显示的文字
        startLabels.setRefreshingLabel("正在拉");//下拉的过程中显示的文字
        startLabels.setReleaseLabel("放开刷新");//不能在下拉时，显示的文字

        ILoadingLayout endLabels = pullToRefreshListView.getLoadingLayoutProxy(false, true);
        endLabels.setPullLabel("加载中...");
        endLabels.setRefreshingLabel("正在载入你关心的新闻。。。");
        endLabels.setReleaseLabel("放开刷新...");

        pullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                openType = 1;

                requestNetData();


            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                openType = 2;

                requestNetData();

            }
        });

    }


}
