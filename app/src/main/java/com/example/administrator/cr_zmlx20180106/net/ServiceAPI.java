package com.example.administrator.cr_zmlx20180106.net;

import com.example.administrator.cr_zmlx20180106.bean.CartBean;
import com.example.administrator.cr_zmlx20180106.bean.Tianjia;
import com.example.administrator.cr_zmlx20180106.bean.XQBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2018/1/6.
 */

public interface ServiceAPI {
    @GET("getProductDetail")
    Flowable<XQBean> getXQ(@Query("pid")int pid, @Query("source")String str);
    @GET("addCart")
    Flowable<Tianjia> getMsg(@Query("uid")int uid, @Query("pid")int pid, @Query("source")String str);
    @GET("getCarts")
    Flowable<CartBean> getCart(@Query("uid")int uid, @Query("source")String str);
}