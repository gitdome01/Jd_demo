package chy.example.com.chy2018111;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private PullToRefreshListView plv;
private int cid=1;
private int openType =1;
private String url="http://120.27.23.105/product/getProductCatagory?cid="+cid;
private List<AnyBean.DataBean> listBeans = new ArrayList<>();
    private Myadapter myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        plv = findViewById(R.id.plv);
        initPlv();


    }

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
                openType = 1;
                cid = 1;
                url = "http://120.27.23.105/product/getProductCatagory?cid="+cid;
                requestNetData();


            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                openType = 2;
                cid++;
                url = "http://120.27.23.105/product/getProductCatagory?cid="+cid;
                requestNetData();

            }
        });
    }

    private void requestNetData() {
      if (NetStateUtil.isConn(MainActivity.this)){
          MyTask myTask = new MyTask(new MyTask.Icallbacks() {
              @Override
              public void updateUiByjson(String jsonstr) {
                  Gson gson = new Gson();
                  AnyBean anyBean = gson.fromJson(jsonstr, AnyBean.class);
                  List<AnyBean.DataBean> data = anyBean.getData();
                  if (openType==1){
                      listBeans.clear();
                  }
                  listBeans.addAll(data);
                  setadapter();


                  plv.onRefreshComplete();


              }
          });
          myTask.execute(url);
      }else {
          NetStateUtil.showNoNetWorkDlg(MainActivity.this);
      }
    }
    public void setadapter(){
        if (myadapter==null){
            myadapter = new Myadapter(MainActivity.this,listBeans);
            plv.setAdapter(myadapter);
        }else {
            myadapter.notifyDataSetChanged();
        }
    }
}
