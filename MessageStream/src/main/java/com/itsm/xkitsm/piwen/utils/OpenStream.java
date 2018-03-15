package com.itsm.xkitsm.piwen.utils;

import android.support.v4.app.FragmentManager;

import com.itsm.xkitsm.piwen.bean.Message;
import com.itsm.xkitsm.piwen.fragment.ClickButtonFragment;
import com.itsm.xkitsm.piwen.fragment.MessageFragment;
import com.shuzuan.sdk.AdvancedApi;

import java.util.LinkedList;
import java.util.List;

/**
 * Desc
 * Created by xupeng on 2018/2/1.
 */

public class OpenStream {
    //类型,,top(头条，默认),shehui(社会),guonei(国内),guoji(国际),
    // yule(娱乐),tiyu(体育)junshi(军事),keji(科技),caijing(财经),shishang(时尚)
    public static String TITLE_1 = "头条";
    public static String TITLE_2 = "社会";
    public static String TITLE_3 = "国内";

    public static List<String> title = new LinkedList();
    public static int position;
    public static Message.ResultBean.DataBean dataBean;
    public static FragmentManager fragmentManager;
    public static AdvancedApi adVanceApi;


    public static void preLoad() {
        //判断当advanceapi为空时，说明不走捷酷sdk成功的回调，不让展示
        if (null != fragmentManager && null != adVanceApi)
            fragmentManager.beginTransaction()
                    .add(android.R.id.content, MessageFragment.newInstance(""))
                    .addToBackStack(null)   //添加返回栈
                    .commit();
    }

    /**
     * 设置标题
     *
     * @param title1
     */
    public static void setTile(String title1) {
        title.clear();
        title.add(title1);
    }

    public static void setTile(String title1, String title2) {
        title.clear();
        title.add(title1);
        title.add(title2);
    }

    public static void setTile(String title1, String title2, String title3) {
        title.clear();
        title.add(title1);
        title.add(title2);
        title.add(title3);
    }

    /**
     * 插入广告bean
     *
     * @param posi
     * @param data
     */
    public static void addDataItem(int posi, Message.ResultBean.DataBean data) {
        position = posi;
        dataBean = data;
    }

    public static void setAdvanceApi(AdvancedApi advaancedApi) {
        adVanceApi = advaancedApi;
    }


    /**
     * 直接为主布局添加点击按钮
     */
    public static void addClickView(FragmentManager ft) {
        fragmentManager = ft;
        ft.beginTransaction()
                .add(android.R.id.content, ClickButtonFragment.newInstance())
                .commit();
    }
}
