package com.kkbox.sqa.myapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * Created by amanda on 2019/2/14.
 */

public class SlowScrollView extends ScrollView {

    public  SlowScrollView(Context context, AttributeSet attrs, int  defStyle) {
        super (context, attrs, defStyle);
    }

    public  SlowScrollView(Context context, AttributeSet attrs) {
        super (context, attrs);
    }

    public  SlowScrollView(Context context) {
        super (context);
    }

    /**
     * 滑動事件
     */
    @Override
    public void  fling( int  velocityY) {
        super .fling(velocityY /  10 );
    }
}