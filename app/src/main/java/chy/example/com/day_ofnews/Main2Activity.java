package chy.example.com.day_ofnews;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import chy.example.com.day_ofnews.Fragmentpack.Fragment01;
import chy.example.com.day_ofnews.Fragmentpack.Fragment02;
import chy.example.com.day_ofnews.Fragmentpack.Fragment03;
import chy.example.com.day_ofnews.Fragmentpack.Fragment04;

public class Main2Activity extends AppCompatActivity {
private ViewPager viewPager;
private RadioGroup radioGroup;
private List<Fragment> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        viewPager = findViewById(R.id.pager);
        radioGroup = findViewById(R.id.radio);

        list = new ArrayList<>();
        list.add(new Fragment01());
        list.add(new Fragment02());
        list.add(new Fragment03());
        list.add(new Fragment04());

        viewPager.setOffscreenPageLimit(3);

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                switch (position){
                    case 0:
                        radioGroup.check(R.id.shouye);
                        break;
                    case 1:
                        radioGroup.check(R.id.shipin);
                        break;
                    case 2:
                        radioGroup.check(R.id.toutiao);
                        break;
                    case 3:
                        radioGroup.check(R.id.wode);
                        break;
                        default:
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
                    case R.id.shouye:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.shipin:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.toutiao:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.wode:
                        viewPager.setCurrentItem(3);
                        break;
                        default:
                            break;
                }
            }
        });


    }
}
