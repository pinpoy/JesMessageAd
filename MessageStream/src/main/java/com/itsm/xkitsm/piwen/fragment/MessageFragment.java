package com.itsm.xkitsm.piwen.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.itsm.xkitsm.piwen.R;
import com.itsm.xkitsm.piwen.adapter.MainViewPagerAdapter;
import com.itsm.xkitsm.piwen.utils.OpenStream;

import java.util.ArrayList;

/**
 * Desc
 * Created by xupeng on 2018/1/31.
 */

public class MessageFragment extends Fragment implements View.OnClickListener {
    private TabLayout messageTab;
    private ViewPager messageViewPager;

    private FragmentPagerAdapter mAdapter;
    private ArrayList<Fragment> mFragments;
    private final String[] mTabs = new String[3];

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_message_library, container, false);
        messageTab = (TabLayout) view.findViewById(R.id.message_tab);
        messageViewPager = (ViewPager) view.findViewById(R.id.message_viewPager);
        view.findViewById(R.id.ll_outing).setOnClickListener(this);
        //初始化布局
        initData();
        return view;
    }

//    @OnClick({R.id.ll_outing})
//    public void onClickEvent(View view) {
//        switch (view.getId()) {
//            case R.id.ll_outing:
//                //隐藏
//                getFragmentManager().beginTransaction().hide(this).commit();
//                break;
//        }
//    }

    private void initData() {
        //初始化控件
//        setTitleData();
        initFragments();
        initView();
    }

    public static MessageFragment newInstance(String OrderType) {
        MessageFragment fragment = new MessageFragment();
        Bundle bundle = new Bundle();
//        bundle.putString(ORDER_TYPE, OrderType);
//        fragment.setArguments(bundle);          // Fragment传递数据方式
        return fragment;
    }


    private void initFragments() {
        mFragments = new ArrayList<>();
        for (String s : OpenStream.title) {
            mFragments.add(TabFragment.newInstance(s));
        }

//        mFragments.add(TabFragment.newInstance());
//        mFragments.add(TabFragment.newInstance());

    }

    /**
     * 设置order的tablebar三个标题
     */
    private void setTitleData() {
        mTabs[0] = OpenStream.TITLE_1;
        mTabs[1] = OpenStream.TITLE_2;
        mTabs[2] = OpenStream.TITLE_3;

//        tabLayout.addTab(tabOrder.newTab().setText(mTabs[0]));
//        tabLayout.addTab(tabOrder.newTab().setText(mTabs[1]));
//        tabLayout.addTab(tabOrder.newTab().setText(mTabs[2]));

        //initTabDate();
    }

    private void initView() {

        mAdapter = new MainViewPagerAdapter(getChildFragmentManager(), mFragments);
        messageViewPager.setOffscreenPageLimit(2);
        messageViewPager.setAdapter(mAdapter);
        messageTab.setupWithViewPager(messageViewPager);
        messageViewPager.setCurrentItem(0);
        messageViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }



    @Override
    public void onClick(View view) {
        //隐藏
        getFragmentManager().beginTransaction().hide(this).commit();
    }
}
