package chy.example.com.chy20180115.Fragmentbag;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import chy.example.com.chy20180115.R;

/**
 * Created by 卿为谁人醉 on 2018/1/15.
 */

public class Fragment01 extends Fragment {
    private TabLayout mytab;
    private ViewPager vp;
    private List<String> tite;
    private List<String> url;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment01,container,false);
        mytab = view.findViewById(R.id.mytab);
        vp = view.findViewById(R.id.vp);
        tite = new ArrayList<>();
        tite.add("头条");
        tite.add("社会");
        tite.add("国内");
        tite.add("国际");
        tite.add("娱乐");
        tite.add("体育");
        tite.add("军事");
        tite.add("科技");
        tite.add("财经");
        tite.add("时尚");
        url = new ArrayList<>();
        url.add("http://v.juhe.cn/toutiao/index?type=top&key=89b6c98a78e2e7d365a06c380ffe38af");
        url.add("http://v.juhe.cn/toutiao/index?type=shehui&key=89b6c98a78e2e7d365a06c380ffe38af");
        url.add("http://v.juhe.cn/toutiao/index?type=guonei&key=89b6c98a78e2e7d365a06c380ffe38af");
        url.add("http://v.juhe.cn/toutiao/index?type=guoji&key=89b6c98a78e2e7d365a06c380ffe38af");
        url.add("http://v.juhe.cn/toutiao/index?type=yule&key=89b6c98a78e2e7d365a06c380ffe38af");
        url.add("http://v.juhe.cn/toutiao/index?type=tiyu&key=89b6c98a78e2e7d365a06c380ffe38af");
        url.add("http://v.juhe.cn/toutiao/index?type=junshi&key=89b6c98a78e2e7d365a06c380ffe38af");
        url.add("http://v.juhe.cn/toutiao/index?type=keji&key=89b6c98a78e2e7d365a06c380ffe38af");
        url.add("http://v.juhe.cn/toutiao/index?type=caijing&key=89b6c98a78e2e7d365a06c380ffe38af");
        url.add("http://v.juhe.cn/toutiao/index?type=shishang&key=89b6c98a78e2e7d365a06c380ffe38af");

        vp.setOffscreenPageLimit(9);
        vp.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return tite.get(position);
            }

            @Override
            public Fragment getItem(int position) {
                Fragment05 fragment05 = new Fragment05();
                Bundle bundle = new Bundle();
                bundle.putString("url",url.get(position));

                fragment05.setArguments(bundle);


                return fragment05;
            }

            @Override
            public int getCount() {
                return tite.size();
            }
        });

        mytab.setupWithViewPager(vp);

        return view;
    }
}
