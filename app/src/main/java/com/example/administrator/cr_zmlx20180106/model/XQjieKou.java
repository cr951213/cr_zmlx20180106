package com.example.administrator.cr_zmlx20180106.model;

import com.example.administrator.cr_zmlx20180106.bean.XQBean;
import com.example.administrator.cr_zmlx20180106.net.CGSB;

/**
 * Created by Administrator on 2018/1/6.
 */

public interface XQjieKou {
    public void getXQ(int pid, String str, final CGSB<XQBean> cgsb);
}