package com.itsm.xkitsm.piwen.Retrofit;

import com.itsm.xkitsm.piwen.bean.Message;

import java.util.Map;

import retrofit.http.GET;
import retrofit.http.QueryMap;
import rx.Observable;

/**
 * Desc
 * Created by xupeng on 2018/1/31.
 */

public interface ApiService {

    /**
     * 获取城市列表
     *
     * @return
     */
    @GET("toutiao/index")
    Observable<Message> getFromJuhe(@QueryMap Map<String, String> param);
}
