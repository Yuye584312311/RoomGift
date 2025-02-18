package com.amazon.kindle.room.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.amazon.kindle.model.GlideCircleTransform;
import com.amazon.kindle.R;
import com.amazon.kindle.base.BaseAdapter;
import com.amazon.kindle.bean.UserInfo;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * Created by TinyHung@outlook.com
 * 2018/5/11
 * 在线观众列表
 */

public class LiveFansListAdapter extends BaseAdapter<UserInfo,LiveFansListAdapter.FansViewHolder> {

    public LiveFansListAdapter(Context context) {
        super(context);
    }

    @Override
    public FansViewHolder inCreateViewHolder(ViewGroup viewGroup, int viewType) {
        return new FansViewHolder(mInflater.inflate(R.layout.item_live_user_fans_item, null));
    }

    @Override
    public void inBindViewHolder(FansViewHolder viewHolder, int position) {
        UserInfo itemData = getItemData(position);
        viewHolder.itemIcon.setBackgroundResource(itemData.getUserSex() ==1 ?
                R.drawable.bg_fans_user_mad_head_shape:R.drawable.bg_fans_user_man_head_shape);
        if(null!=itemData){
            Glide.with(getContext())
                    .load(itemData.getAvatar())
                    .error(R.drawable.ic_default_user_head)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .centerCrop()
                    .transform(new GlideCircleTransform(mContext))
                    .dontAnimate()
                    .into(viewHolder.itemIcon);
        }
    }

    public class FansViewHolder extends RecyclerView.ViewHolder{
        private ImageView itemIcon;

        public FansViewHolder(View itemView) {
            super(itemView);
            itemIcon = (ImageView) itemView.findViewById(R.id.item_iv_user_icon);
        }
    }
}
