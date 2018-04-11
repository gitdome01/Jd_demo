package chy.example.com.chy20180115;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import chy.example.com.chy20180115.Fragmentbag.Fragment01;
import chy.example.com.chy20180115.Fragmentbag.Fragment02;
import chy.example.com.chy20180115.Fragmentbag.Fragment03;
import chy.example.com.chy20180115.Fragmentbag.Fragment04;

public class MainActivity extends AppCompatActivity {
private ViewPager viewPager;
private RadioGroup radioGroup;
private List<Fragment> fragments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.pager);
        radioGroup = findViewById(R.id.radio);
        fragments = new ArrayList<>();
        fragments.add(new Fragment01());
        fragments.add(new Fragment02());
        fragments.add(new Fragment03());
        fragments.add(new Fragment04());

        viewPager.setOffscreenPageLimit(4);

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
       viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
           @Override
           public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

           }

           @Override
           public void onPageSelected(int position) {

               switch (position){
                   case 0:
                       radioGroup.check(R.id.toppager);
                       break;
                   case 1:
                       radioGroup.check(R.id.video);
                       break;
                   case 2:
                       radioGroup.check(R.id.tt);
                       break;
                   case 3:
                       radioGroup.check(R.id.me);
                       break;
               }

           }

           @Override
           public void onPageScrollStateChanged(int state) {

           }
       });

       radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(RadioGroup group, int checkedId) {
               switch (checkedId){
                   case R.id.toppager:
                       viewPager.setCurrentItem(0);
                       break;
                   case R.id.video:
                       viewPager.setCurrentItem(1);
                       break;
                   case R.id.tt:
                       viewPager.setCurrentItem(2);
                       break;
                   case R.id.me:
                       viewPager.setCurrentItem(3);
                       break;
               }
           }
       });




    }
}
