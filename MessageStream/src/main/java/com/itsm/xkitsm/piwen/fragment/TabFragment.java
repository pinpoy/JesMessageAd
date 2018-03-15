package com.itsm.xkitsm.piwen.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.itsm.xkitsm.piwen.R;
import com.itsm.xkitsm.piwen.Retrofit.ApiServiceFactory;
import com.itsm.xkitsm.piwen.Retrofit.HttpUrls;
import com.itsm.xkitsm.piwen.adapter.TabAdapter;
import com.itsm.xkitsm.piwen.bean.Message;
import com.itsm.xkitsm.piwen.utils.OpenStream;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Desc 标签页的Fragment
 * Created by xupeng on 2018/1/31.
 */

public class TabFragment extends Fragment {

    RecyclerView recycler;

    public Context mContext;
    private static String tabType;
    private static final String TAB_TYPE = "tab_type";
    private LinearLayoutManager linearLayoutManager;
    private TabAdapter tabAdapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab_library, container, false);
        recycler = (RecyclerView) view.findViewById(R.id.recycler);
        //分离类型进行请求网络
        switchToType();
        return view;
    }

    /**
     * 实例化并传递数据
     *
     * @param type
     * @return
     */
    public static TabFragment newInstance(String type) {
        TabFragment fragment = new TabFragment();
        Bundle bundle = new Bundle();
        bundle.putString(TAB_TYPE, type);
        fragment.setArguments(bundle);          // Fragment传递数据方式
        return fragment;
    }

    /**
     * 类型,top(头条，默认),shehui(社会),
     * guoji(国际),yule(娱乐),tiyu(体育)junshi(军事),keji(科技),caijing(财经),shishang(时尚)
     */
    private void switchToType() {
        Bundle bundle = getArguments();
        tabType = bundle.getString(TAB_TYPE);
        switch (tabType) {
            case "头条":
                requestData("top");
                break;
            case "社会":
                requestData("shehui");
                break;
            case "国内":
                requestData("guonei");
                break;
            case "国际":
                requestData("guoji");
                break;
            case "娱乐":
                requestData("yule");
                break;
            case "体育":
                requestData("tiyu");
                break;
            case "军事":
                requestData("junshi");
                break;
            case "科技":
                requestData("keji");
                break;
            case "财经":
                requestData("caijing");
                break;
            case "时尚":
                requestData("shishang");
                break;
        }
    }

    /**
     * 请求数据
     */
    private void requestData(String type) {
        ApiServiceFactory.getSpiderApiService(HttpUrls.HTTP_BASE_URL)
                .getFromJuhe(getDataMap(type))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Message>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Message message) {
                        if (null != message) {
                            initData(message.getResult());
                        }
                    }
                });
    }

    private Map<String, String> getDataMap(String type) {
        Map<String, String> map = new HashMap<>();
        map.put("type", type);
        map.put("key", "dca490edff1205ae40eab07d90c71d8b");

        return map;
    }

    private void initData(Message.ResultBean result) {
        if (null == result)
            return;
        //添加自己的条目广告
        List<Message.ResultBean.DataBean> data = result.getData();
        if (null != OpenStream.dataBean) {
            data.set(OpenStream.position, OpenStream.dataBean);
        }

        //线性布局管理器
        linearLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        tabAdapter = new TabAdapter(mContext, data);
        recycler.setLayoutManager(linearLayoutManager);
        recycler.setAdapter(tabAdapter);
    }


}
