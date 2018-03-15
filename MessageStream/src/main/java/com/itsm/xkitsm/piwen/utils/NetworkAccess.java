package com.itsm.xkitsm.piwen.utils;

import android.widget.Toast;

import com.itsm.xkitsm.piwen.Retrofit.ApiServiceFactory;
import com.itsm.xkitsm.piwen.Retrofit.HttpUrls;
import com.itsm.xkitsm.piwen.bean.Message;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Desc 网络访问
 * Created by xupeng on 2018/1/31.
 */

public class NetworkAccess {
//    public static void getData() {
//        ApiServiceFactory.getSpiderApiService(HttpUrls.HTTP_BASE_URL)
//                .getFromJuhe()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<Message>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onNext(Message message) {
//
//                    }
//                });
//    }
}
