package chy.example.com.day_ofnews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import chy.example.com.day_ofnews.Fragmentpack.Fragment04;
import chy.example.com.day_ofnews.NewsBean.LoginBean;
import chy.example.com.day_ofnews.Util.MyTask;
import chy.example.com.day_ofnews.Util.NetUtil;

public class Main3Activity extends AppCompatActivity {
private EditText mobli,password;
private Button login;
    private String url;
    private LoginBean loginBean1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        mobli = findViewById(R.id.edit1);
        password = findViewById(R.id.edit2);
        login = findViewById(R.id.btn);

        String mobli1 = mobli.getText().toString();
        String password = this.password.getText().toString();
        url = "https://www.zhaoapi.cn/user/login?mobile=18612991023&&password=111111";
       login.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               requestNetData();
           }
       });


        }


    private void requestNetData() {
        if (NetUtil.isConn(Main3Activity.this)){
            MyTask myTask = new MyTask(new MyTask.Icallbacks() {


                @Override
                public void updateUiByjson(String jsonstr) {
                    Gson gson = new Gson();
                    loginBean1 = gson.fromJson(jsonstr, LoginBean.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("icon",loginBean1.getData().getIcon());
                    bundle.putString("nick",loginBean1.getData().getNickname());
                    Intent intent = new Intent(Main3Activity.this,Main2Activity.class);
                    intent.putExtras(bundle);
                    startActivityForResult(intent,1);
                    Toast.makeText(Main3Activity.this,"用户：18612991023 登录成功",Toast.LENGTH_LONG).show();

                }
            });
            myTask.execute(url);
}else {
            NetUtil.openNetDialog(Main3Activity.this);
        }
    }
}