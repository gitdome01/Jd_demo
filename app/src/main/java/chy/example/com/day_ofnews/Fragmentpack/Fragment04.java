package chy.example.com.day_ofnews.Fragmentpack;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import chy.example.com.day_ofnews.Main3Activity;
import chy.example.com.day_ofnews.NewsBean.LoginBean;
import chy.example.com.day_ofnews.R;
import chy.example.com.day_ofnews.Util.Imageutil;
import chy.example.com.day_ofnews.Util.MyTask;
import chy.example.com.day_ofnews.Util.NetUtil;
import chy.example.com.day_ofnews.Util.Timeutil;

/**
 * Created by 卿为谁人醉 on 2018/1/8.
 */

public class Fragment04 extends Fragment {
    private DrawerLayout drawerLayout;
    private LinearLayout linout;
    private ImageView qqlogin,sh;
    private ListView loginlv;
    private ListView lv;
    private int i = 0;
    private List<String> datas;
    private String url;

    private TextView user;
    private List<LoginBean.DataBean> data = new ArrayList<>();;
    private LoginBean loginBean;
    private RadioButton yj;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment04,container,false);
        drawerLayout = view.findViewById(R.id.mydrawer);
        linout = view.findViewById(R.id.linout);
        lv = view.findViewById(R.id.lv);
        loginlv = view.findViewById(R.id.loginlv);
        qqlogin = view.findViewById(R.id.qq);
        sh = view.findViewById(R.id.phone);
        user =view.findViewById(R.id.textView2);
        yj = view.findViewById(R.id.yj);

        yj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Timeutil.changeTheme(getActivity());



            }
        });

//        Bundle arguments = getArguments();
//        url = arguments.getString("url");


        qqlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Main3Activity.class);
               startActivityForResult(intent,1);
            }
        });
                drawerLayout.closeDrawer(linout);


loginlv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        drawerLayout.openDrawer(linout);

        String[] stringArray = loginlv.getResources().getStringArray(R.array.tm);

//                Toast.makeText(MainActivity.this,s,Toast.LENGTH_SHORT).show();
        //关闭菜单




        Bundle bundle=new Bundle();
        bundle.putString("data",stringArray.toString());
        Conf conf = new Conf();
        conf.setArguments(bundle);
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.loginlayout,conf).commit();



    }
});



        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==1&resultCode==1){
            Bundle arguments = getArguments();
            String icon = arguments.getString("icon");
            String nick = arguments.getString("nick");
            ImageLoader.getInstance().displayImage(icon,sh,Imageutil.getImageOptions(getActivity()));
            user.setText(nick);

        }

    }


    }



