package com.example.administrator.cr_zmlx20180106.model;

import com.example.administrator.cr_zmlx20180106.bean.CartBean;
import com.example.administrator.cr_zmlx20180106.net.CGSB;
import com.example.administrator.cr_zmlx20180106.net.RetrofitHepler;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/1/6.
 */

public class CarModel {
    public void getCart(int uid, String str, final CGSB<CartBean> cgsb){
        Flowable<CartBean> flowable = RetrofitHepler.getSerViceAPI().getCart(uid,str);
        flowable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<CartBean>() {
                    @Override
                    public void accept(CartBean cartBean) throws Exception {
                        cgsb.chengGong(cartBean);
                    }
                });
    }
}
