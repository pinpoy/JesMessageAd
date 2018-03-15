package com.itsm.xkitsm.piwen.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.itsm.xkitsm.piwen.R;
import com.itsm.xkitsm.piwen.bean.Message;
import com.itsm.xkitsm.piwen.fragment.DetailFragment;
import com.itsm.xkitsm.piwen.utils.GlideUtils;
import com.itsm.xkitsm.piwen.utils.OpenStream;

import java.util.List;

/**
 * Desc
 * Created by xupeng on 2018/1/31.
 */

public class TabAdapter extends RecyclerView.Adapter<TabAdapter.ItemViewHolder> {

    private Context mContext;
    private List<Message.ResultBean.DataBean> data;

    public TabAdapter(Context mContext, List<Message.ResultBean.DataBean> data) {
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tab_library, parent, false);
        ItemViewHolder vh = new ItemViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, final int position) {
        holder.title.setText(data.get(position).getTitle());
        holder.author.setText(data.get(position).getAuthor_name());
        if ("广告".equals(data.get(position).getAuthor_name())) {
            holder.author.setTextColor(Color.RED);
            //新方式----上报广告点击view
            if (null != OpenStream.adVanceApi) {
                OpenStream.adVanceApi.register(mContext.getApplicationContext(), holder.itemView);
            }

        } else {
            holder.author.setTextColor(Color.GRAY);
            //条目点击事件
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DetailFragment.startDetailFragment(data.get(position).getUrl());
                }
            });
        }
        holder.date.setText(data.get(position).getDate());
        GlideUtils.loadImg(mContext, data.get(position).getThumbnail_pic_s(), holder.iv);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView author;
        private TextView date;
        private ImageView iv;

        public ItemViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            author = (TextView) view.findViewById(R.id.author);
            date = (TextView) view.findViewById(R.id.date);
            iv = (ImageView) view.findViewById(R.id.iv);
        }
    }


}
