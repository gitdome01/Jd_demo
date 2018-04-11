package chy.example.com.day_ofnews.Fragmentpack;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import chy.example.com.day_ofnews.R;

/**
 * Created by 卿为谁人醉 on 2018/1/12.
 */

public class Conf extends Fragment {
    private TextView textView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.conf,container,false);
        textView = view.findViewById(R.id.textView3);
        Bundle arguments = getArguments();
        
            String data = arguments.getString("data");
            textView.setText(data);

        return view;
    }
}
