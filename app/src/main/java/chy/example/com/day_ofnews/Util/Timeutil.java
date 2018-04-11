package chy.example.com.day_ofnews.Util;

import android.app.Activity;
import android.content.Intent;

import chy.example.com.day_ofnews.R;

/**
 * Created by 卿为谁人醉 on 2018/1/16.
 */

public class Timeutil {
    private static int theme=0;
    private static final int DAY_THEME=0;
    private static final int NIGHT_THEME=1;

    public static void onStartTheme(Activity activity){
        switch (theme){
            case DAY_THEME:
                activity.setTheme(R.style.AppTheme);
                break;
            case NIGHT_THEME:
                activity.setTheme(R.style.Night_mode);
                break;
        }
    }

    public static void changeTheme(Activity activity){
        switch (theme){
            case DAY_THEME:
                theme=NIGHT_THEME;
                break;
            case NIGHT_THEME:
                theme=DAY_THEME;
                break;
        }
        activity.finish();
        activity.overridePendingTransition(R.anim.sliding_in, R.anim.sliding_out);
        activity.startActivity(new Intent(activity,activity.getClass()));
    }


}
