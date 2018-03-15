package com.itsm.xkitsm.piwen.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.itsm.xkitsm.piwen.R;
import com.itsm.xkitsm.piwen.utils.OpenStream;

/**
 * Desc
 * Created by xupeng on 2018/2/5.
 */

public class DetailFragment extends Fragment {
    private static final String URLSTR = "url";
    WebView webWebview;
    private String url;
    private static DetailFragment fragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_library, container, false);
        webWebview = (WebView) view.findViewById(R.id.web_webview);
        initPage();
        return view;
    }

    /**
     * 初始化webview
     */
    private void initPage() {
        Bundle bundle = getArguments();
        url = bundle.getString(URLSTR);

        webWebview.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_OVERLAY);
        webWebview.loadUrl(url);
        WebSettings webSettings = webWebview.getSettings();
        webSettings.setJavaScriptEnabled(true);

        //点击进入webview的子页面的返回逻辑
        webWebview.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == KeyEvent.ACTION_DOWN) {
                    if (keyEvent.getKeyCode() == KeyEvent.KEYCODE_BACK) {
                        //这里处理返回键事件
                        if (webWebview.canGoBack()) {
                            webWebview.goBack();
                            return true;
                        }
                    }
                }
                return false;
            }
        });
    }

    /**
     * 实例化并传递数据
     *
     * @param url
     * @return
     */
    public static DetailFragment newInstance(String url) {
        if (null == fragment)
            fragment = new DetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString(URLSTR, url);
        fragment.setArguments(bundle);          // Fragment传递数据方式
        return fragment;
    }

    public static void startDetailFragment(String url) {
        OpenStream.fragmentManager.beginTransaction()
                .add(android.R.id.content, DetailFragment.newInstance(url))
                .addToBackStack(null)   //添加返回栈
                .commit();
    }


}
