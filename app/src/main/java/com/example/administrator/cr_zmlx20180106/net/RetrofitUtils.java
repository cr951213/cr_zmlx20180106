package com.example.administrator.cr_zmlx20180106.net;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2018/1/5.
 */

public class RetrofitUtils {

    private RetrofitUtils() {
    }

    private static API apiService;

    public static API getApiService() {
        if (apiService == null) {
            synchronized (RetrofitUtils.class) {


                if (apiService == null) {


                    OkHttpClient okHttpClient = new OkHttpClient.Builder()
                            .addInterceptor(new Interceptor() {
                                @Override
                                public okhttp3.Response intercept(Chain chain) throws IOException {
                                    Request request = chain.request();
                                    Log.i("zzz", "request====111111111111111111111111111111");
                                    Log.i("zzz", "request====" + request.headers().toString());
                                    okhttp3.Response proceed = chain.proceed(request);
                                    Log.i("zzz", "proceed====" + proceed.headers().toString());
                                    return proceed;
                                }
                            })

                            .build();
                    Retrofit retrofit = new Retrofit.Builder()
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .client(okHttpClient)
                            .baseUrl(API.HOST)
                            .build();
                    apiService = retrofit.create(API.class);
                }
            }
        }

        return apiService;
    }

}
