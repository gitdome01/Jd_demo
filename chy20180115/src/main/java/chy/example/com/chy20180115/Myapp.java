package chy.example.com.chy20180115;

import android.app.Application;

import chy.example.com.chy20180115.Util.Imageutil;

/**
 * Created by 卿为谁人醉 on 2018/1/15.
 */

public class Myapp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Imageutil.initImageLoader(this);
    }
}
