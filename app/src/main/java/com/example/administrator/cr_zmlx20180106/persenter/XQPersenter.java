package com.example.administrator.cr_zmlx20180106.persenter;

import com.example.administrator.cr_zmlx20180106.bean.Tianjia;
import com.example.administrator.cr_zmlx20180106.bean.XQBean;
import com.example.administrator.cr_zmlx20180106.model.XQModel;
import com.example.administrator.cr_zmlx20180106.net.CGSB;
import com.example.administrator.cr_zmlx20180106.view.Iview;

/**
 * Created by Administrator on 2018/1/6.
 */

public class XQPersenter {
    private final XQModel xqModel;
    private Iview iview;
    public XQPersenter(Iview iview) {
        xqModel = new XQModel();
        this.iview=iview;
    }
    public void getXQ(){
        xqModel.getXQ(12, "android", new CGSB<XQBean>() {
            @Override
            public void chengGong(XQBean xqBean) {
                iview.showBean(xqBean);
            }
        });
    }
    public void getTJ(){
        xqModel.getTJ(3043, 12, "android", new CGSB<Tianjia>() {
            @Override
            public void chengGong(Tianjia tianjia) {
                iview.showStr(tianjia.getMsg());
            }
        });
    }
}
