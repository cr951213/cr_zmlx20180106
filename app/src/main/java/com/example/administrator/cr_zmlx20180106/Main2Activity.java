package com.example.administrator.cr_zmlx20180106;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.cr_zmlx20180106.bean.XQBean;
import com.example.administrator.cr_zmlx20180106.persenter.XQPersenter;
import com.example.administrator.cr_zmlx20180106.view.Iview;
import com.facebook.drawee.view.SimpleDraweeView;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener,Iview {
    private SimpleDraweeView mXqsdv;
    private TextView mTvtitle;
    /**
     * 跳转到购物车
     */
    private Button mTiaozhuan;
    /**
     * 添加到购物车
     */
    private Button mTianjia;
    private LinearLayout mActivityMain2;
    private XQPersenter xqPersenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        xqPersenter = new XQPersenter(this);
        xqPersenter.getXQ();
    }
    private void initView() {
        mXqsdv = (SimpleDraweeView) findViewById(R.id.xqsdv1);
        mTvtitle = (TextView) findViewById(R.id.tvtitle1);
        mTiaozhuan = (Button) findViewById(R.id.tiaozhuan1);
        mTiaozhuan.setOnClickListener(this);
        mTianjia = (Button) findViewById(R.id.tianjia1);
        mTianjia.setOnClickListener(this);
        mActivityMain2 = (LinearLayout) findViewById(R.id.activity_main2);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tiaozhuan1:
                startActivity(new Intent(this,MainActivity.class));//跳到MainActivity （购物车）
                break;
            case R.id.tianjia1:
                xqPersenter.getTJ();
                break;
        }
    }


    @Override
    public void showBean(XQBean xqBean) {
        XQBean xqBean1=new XQBean();
        XQBean.DataBean data = xqBean1.getData();
        String s = data.getImages().split("\\|")[0];
        Uri uri =Uri.parse(s);//地址转换成URI
        mXqsdv.setImageURI(uri);
        mTvtitle.setText(data.getTitle()+"\n"+data.getPrice());
    }

    @Override
    public void showStr(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
