package chy.example.com.day_ofnews;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import chy.example.com.day_ofnews.Util.Timeutil;

public class MainActivity extends AppCompatActivity {
private TextView jamp;
private int i=10;
private Handler handler = new Handler(){
    @Override
    public void handleMessage(Message msg) {
        jamp.setText("剩余"+i+"秒");
        if (i==0){
            Intent intent = new Intent(MainActivity.this,Main2Activity.class);
            startActivity(intent);
            finish();
        }
    }
};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jamp = findViewById(R.id.jump);
        SharedPreferences pref = this.getSharedPreferences("myActivityName", MODE_PRIVATE);
        //取得相应的值，如果没有该值， 说明还未写入，用true作为默认值
        boolean isFirstIn = pref.getBoolean("isFirstIn", false);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("isFirstIn", true);
        if(isFirstIn == true){
            startActivity(new Intent(this, Main2Activity.class));
            finish();
//切换动画
        }else {
            new Thread(){
                @Override
                public void run() {
                    while (true) {
                        try {
                            sleep(1000);
                            i--;
                            handler.sendEmptyMessage(i);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                }
            }.start();
        }
        editor.commit();


        Timeutil.onStartTheme(MainActivity.this);
        jamp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
                finish();
            }
        });



    }
}
