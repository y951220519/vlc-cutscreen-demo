package com.nmbb.vlc.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nmbb.vlc.R;

import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2017/10/19.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    private List<Map<String, Object>> mData;

    /**
     * 事件回调监听
     */
    private MyAdapter.OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);
    }

    public MyAdapter(List<Map<String, Object>> data) {
        this.mData = data;
    }

    /**
     * 设置回调监听
     *
     * @param listener
     */
    public void setOnItemClickListener(MyAdapter.OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public void updateData(List<Map<String, Object>> data) {
        this.mData = data;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 实例化展示的view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_rv_item, parent, false);
        // 实例化viewholder
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        // 绑定数据
//            holder.mTv.setText(mData.get(position));
        holder.mTitle.setText(mData.get(position).get("title").toString());
        holder.mInfo.setText(mData.get(position).get("info").toString());
        holder.mImg.setImageResource((int)mData.get(position).get("img"));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if(onItemClickListener != null) {
                    int pos = holder.getLayoutPosition();
                    onItemClickListener.onItemClick(holder.itemView, pos);
                }
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(onItemClickListener != null) {
                    int pos = holder.getLayoutPosition();
                    onItemClickListener.onItemLongClick(holder.itemView, pos);
                }
                //表示此事件已经消费，不会触发单击事件
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        //R.id.title,R.id.info,R.id.img
        TextView mTitle;
        TextView mInfo;
        ImageView mImg;

        public ViewHolder(View itemView) {
            super(itemView);
//                mTv = (TextView) itemView.findViewById(R.id.item_tv);
            mTitle = (TextView) itemView.findViewById(R.id.title);
            mInfo = (TextView) itemView.findViewById(R.id.info);
            mImg = (ImageView) itemView.findViewById(R.id.img);
        }
    }
}

