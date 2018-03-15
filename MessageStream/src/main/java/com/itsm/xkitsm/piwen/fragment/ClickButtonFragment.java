package com.itsm.xkitsm.piwen.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.itsm.xkitsm.piwen.R;
import com.itsm.xkitsm.piwen.utils.OpenStream;

/**
 * Desc
 * Created by xupeng on 2018/1/31.
 */

public class ClickButtonFragment extends Fragment implements View.OnClickListener {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_click_button, container, false);
        view.findViewById(R.id.iv_click_show).setOnClickListener(this);
        return view;
    }


    public static ClickButtonFragment newInstance() {
        ClickButtonFragment fragment = new ClickButtonFragment();
        return fragment;
    }


    @Override
    public void onClick(View view) {
        OpenStream.preLoad();
    }
}