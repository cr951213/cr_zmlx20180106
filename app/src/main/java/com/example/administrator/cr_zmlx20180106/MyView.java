package com.example.administrator.cr_zmlx20180106;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import io.reactivex.annotations.Nullable;

/**
 * Created by Administrator on 2018/1/6.
 */

public class MyView extends LinearLayout {

    ImageView jia;
    TextView num;
    ImageView jian;
    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        View view=View.inflate(context, R.layout.childitem,this);
        jia=view.findViewById(R.id.jia);
        num=view.findViewById(R.id.tv_num);
        jian=view.findViewById(R.id.jian);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * ++
     * @param onClickListener
     */
    public void setAdditemClick(OnClickListener onClickListener)
    {
        jia.setOnClickListener(onClickListener);
    }
    /**
     * --
     */
    public void setJianitemClick(OnClickListener onClickListener)
    {
        jian.setOnClickListener(onClickListener);
    }
    //赋值
    public void setNum(String num1)
    {
        num.setText(num1+"");
    }
}