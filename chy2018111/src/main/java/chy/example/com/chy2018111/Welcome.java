package chy.example.com.chy2018111;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.gson.Gson;


import java.util.ArrayList;
import java.util.List;

public class Welcome extends AppCompatActivity {
private RadioGroup radioGroup;
private ViewPager pager;
private TextView jj;
private Button bt1;
private String url1="http://120.27.23.105/product/getProductDetail?pid=1&source=android";
    private GoodsBean goodsBean;

    private List<String> picurl = new ArrayList<>();;
    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int currentItem = pager.getCurrentItem();
            currentItem++;
            pager.setCurrentItem(currentItem);
            sendEmptyMessageDelayed(0,1000);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        radioGroup = findViewById(R.id.radio);
        pager = findViewById(R.id.pager);
        jj = findViewById(R.id.jj);
        bt1 = findViewById(R.id.bt1);

bt1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Welcome.this,MainActivity.class);
        startActivity(intent);
    }
});
        //请求数据

      //  initdata();

        if (NetStateUtil.isConn(Welcome.this)){
            requestNetData();
        }else {
            NetStateUtil.showNoNetWorkDlg(Welcome.this);
        }
    }

//    private void initdata() {
//
//        String images = goodsBean.getData().getImages();
//        Log.i("----",">"+images);
//        String[] split = images.split("\\|");
//        Log.i("------>"," "+split[0]);
//
//
//        picurl.add(split[0]);
//        picurl.add(split[1]);
//        picurl.add(split[2]);
//        Log.i("------>"," "+picurl);
//
//
//    }


    private void requestNetData() {

            MyTask myTask = new MyTask(new MyTask.Icallbacks() {
                @Override
                public void updateUiByjson(String jsonstr) {
                    Gson gson = new Gson();
                    goodsBean = gson.fromJson(jsonstr, GoodsBean.class);


                    String[] strings = goodsBean.getData().getImages().trim().split("\\|");
                    Log.i("----",">"+strings );
                    picurl.add(strings[0]);
                    picurl.add(strings[1]);
                    picurl.add(strings[2]);
                    Log.i("______",">"+strings[0]);
                    Log.i("______",">"+strings[1]);
                    Log.i("______",">"+strings[2]);
                    jj.setText(goodsBean.getData().getTitle());

                    pager.setAdapter(new Mypageradapter(Welcome.this,picurl));
                    pager.setCurrentItem(picurl.size()*10);
                    pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                        @Override
                        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                        }

                        @Override
                        public void onPageSelected(int position) {
                              switch (position%picurl.size()){
                                  case 0:
                                      radioGroup.check(R.id.rbt1);
                                      break;
                                  case 1:
                                      radioGroup.check(R.id.rbt2);
                                      break;
                                  case 2:
                                      radioGroup.check(R.id.rbt3);
                                      break;
                                      default:
                                          break;
                              }
                        }

                        @Override
                        public void onPageScrollStateChanged(int state) {

                        }
                    });
                    handler.sendEmptyMessage(0);

                }
            });
            myTask.execute(url1);
    }
}
