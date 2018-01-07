package com.example.administrator.cr_zmlx20180106.view;

import com.example.administrator.cr_zmlx20180106.bean.CartBean;

import java.util.List;

/**
 * Created by Administrator on 2018/1/6.
 */

public interface ICart{
    void showlist(List<CartBean.DataBean> grouplist, List<List<CartBean.DataBean.ListBean>> childlist);
}
