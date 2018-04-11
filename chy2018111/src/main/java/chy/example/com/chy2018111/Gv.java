package chy.example.com.chy2018111;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;

/**
 * Created by 卿为谁人醉 on 2018/1/12.
 */

    public class Gv extends GridView {
    public Gv(Context context) {


        super(context);
    }

    public Gv(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Gv(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int newHeight = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        //传递给父类
        super.onMeasure(widthMeasureSpec, newHeight);
    }

}
