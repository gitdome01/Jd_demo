package chy.example.com.day_ofnews.Fragmentpack;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import chy.example.com.day_ofnews.R;

/**
 * Created by 卿为谁人醉 on 2018/1/8.
 */

public class Fragment01 extends Fragment {
   private TabLayout tab;
   private ViewPager viewPager;
   private List<String> lists;
    private List<String> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment01,container,false);
        tab = view.findViewById(R.id.mytab);
        viewPager = view.findViewById(R.id.vp);
        lists = new ArrayList<>();
        lists.add("推荐");
        lists.add("热点");
        lists.add("北京");
        lists.add("视频");
        lists.add("社会");
        lists.add("科技");
        lists.add("汽车");
        lists.add("体育");
        lists.add("财经");
        lists.add("娱乐");

        list = new ArrayList<>();
        list.add("http://ic.snssdk.com/2/article/v25/stream/?count=20&min_behot_time=1457659690&bd_latitude=4.9E-324&bd_longitude=4.9E-324&bd_loc_time=1457672153&loc_mode=5&lac=4527&cid=28883&iid=3839760160&device_id=12246291682&ac=wifi&channel=baidu&aid=13&app_name=news_article&version_code=460&device_platform=android&device_type=iToolsAVM&os_api=19&os_version=4.4.4&uuid=352284045861006&openudid=84c1c7b192991cc6");
        list.add("http://ic.snssdk.com/2/article/v25/stream/?category=news_hot&count=20&min_behot_time=1457659116&bd_latitude=4.9E-324&bd_longitude=4.9E-324&bd_loc_time=1457672153&loc_mode=5&lac=4527&cid=28883&iid=3839760160&device_id=12246291682&ac=wifi&channel=baidu&aid=13&app_name=news_article&version_code=460&device_platform=android&device_type=iToolsAVM&os_api=19&os_version=4.4.4&uuid=352284045861006&openudid=84c1c7b192991cc6");
        list.add("http://ic.snssdk.com/2/article/v25/stream/?count=20&min_behot_time=1457659690&bd_latitude=4.9E-324&bd_longitude=4.9E-324&bd_loc_time=1457672153&loc_mode=5&lac=4527&cid=28883&iid=3839760160&device_id=12246291682&ac=wifi&channel=baidu&aid=13&app_name=news_article&version_code=460&device_platform=android&device_type=iToolsAVM&os_api=19&os_version=4.4.4&uuid=352284045861006&openudid=84c1c7b192991cc6");
        list.add("http://ic.snssdk.com/2/article/v25/stream/?category=news_hot&count=20&min_behot_time=1457659116&bd_latitude=4.9E-324&bd_longitude=4.9E-324&bd_loc_time=1457672153&loc_mode=5&lac=4527&cid=28883&iid=3839760160&device_id=12246291682&ac=wifi&channel=baidu&aid=13&app_name=news_article&version_code=460&device_platform=android&device_type=iToolsAVM&os_api=19&os_version=4.4.4&uuid=352284045861006&openudid=84c1c7b192991cc6");
        list.add("http://ic.snssdk.com/2/article/v25/stream/?count=20&min_behot_time=1457659690&bd_latitude=4.9E-324&bd_longitude=4.9E-324&bd_loc_time=1457672153&loc_mode=5&lac=4527&cid=28883&iid=3839760160&device_id=12246291682&ac=wifi&channel=baidu&aid=13&app_name=news_article&version_code=460&device_platform=android&device_type=iToolsAVM&os_api=19&os_version=4.4.4&uuid=352284045861006&openudid=84c1c7b192991cc6");
        list.add("http://ic.snssdk.com/2/article/v25/stream/?category=news_hot&count=20&min_behot_time=1457659116&bd_latitude=4.9E-324&bd_longitude=4.9E-324&bd_loc_time=1457672153&loc_mode=5&lac=4527&cid=28883&iid=3839760160&device_id=12246291682&ac=wifi&channel=baidu&aid=13&app_name=news_article&version_code=460&device_platform=android&device_type=iToolsAVM&os_api=19&os_version=4.4.4&uuid=352284045861006&openudid=84c1c7b192991cc6");
        list.add("http://ic.snssdk.com/2/article/v25/stream/?count=20&min_behot_time=1457659690&bd_latitude=4.9E-324&bd_longitude=4.9E-324&bd_loc_time=1457672153&loc_mode=5&lac=4527&cid=28883&iid=3839760160&device_id=12246291682&ac=wifi&channel=baidu&aid=13&app_name=news_article&version_code=460&device_platform=android&device_type=iToolsAVM&os_api=19&os_version=4.4.4&uuid=352284045861006&openudid=84c1c7b192991cc6");
        list.add("http://ic.snssdk.com/2/article/v25/stream/?category=news_hot&count=20&min_behot_time=1457659116&bd_latitude=4.9E-324&bd_longitude=4.9E-324&bd_loc_time=1457672153&loc_mode=5&lac=4527&cid=28883&iid=3839760160&device_id=12246291682&ac=wifi&channel=baidu&aid=13&app_name=news_article&version_code=460&device_platform=android&device_type=iToolsAVM&os_api=19&os_version=4.4.4&uuid=352284045861006&openudid=84c1c7b192991cc6");
        list.add("http://ic.snssdk.com/2/article/v25/stream/?count=20&min_behot_time=1457659690&bd_latitude=4.9E-324&bd_longitude=4.9E-324&bd_loc_time=1457672153&loc_mode=5&lac=4527&cid=28883&iid=3839760160&device_id=12246291682&ac=wifi&channel=baidu&aid=13&app_name=news_article&version_code=460&device_platform=android&device_type=iToolsAVM&os_api=19&os_version=4.4.4&uuid=352284045861006&openudid=84c1c7b192991cc6");
        list.add("http://ic.snssdk.com/2/article/v25/stream/?category=news_hot&count=20&min_behot_time=1457659116&bd_latitude=4.9E-324&bd_longitude=4.9E-324&bd_loc_time=1457672153&loc_mode=5&lac=4527&cid=28883&iid=3839760160&device_id=12246291682&ac=wifi&channel=baidu&aid=13&app_name=news_article&version_code=460&device_platform=android&device_type=iToolsAVM&os_api=19&os_version=4.4.4&uuid=352284045861006&openudid=84c1c7b192991cc6");

        viewPager.setOffscreenPageLimit(9);


        viewPager.setAdapter(new FragmentPagerAdapter(getActivity().getSupportFragmentManager()) {

            @Override
            public CharSequence getPageTitle(int position) {
                return lists.get(position);
            }
            @Override
            public Fragment getItem(int position) {

              Fragment05 fragment05 = new Fragment05();

              Bundle bundle = new Bundle();
              bundle.putString("news", list.get(position));
              fragment05.setArguments(bundle);

                return fragment05;
            }


            @Override
            public int getCount() {
                return lists.size();
            }
        });
        tab.setupWithViewPager(viewPager);






        return view;
    }




    }

