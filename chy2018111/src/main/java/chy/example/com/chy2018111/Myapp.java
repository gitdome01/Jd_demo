package chy.example.com.chy2018111;

import android.app.Application;

/**
 * Created by 卿为谁人醉 on 2018/1/12.
 */

public class Myapp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Imageutil.initImageLoader(this);
    }
}
