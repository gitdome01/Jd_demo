package chy.example.com.chy20180115.Fragmentbag;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import chy.example.com.chy20180115.R;

/**
 * Created by 卿为谁人醉 on 2018/1/15.
 */

public class Fragment03 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment03,container,false);
        return view;
    }
}
