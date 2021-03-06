package com.c9mj.platform.live.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.c9mj.platform.R;
import com.c9mj.platform.live.mvp.model.bean.LiveListItemBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;

import java.util.List;

/**
 * author: LMJ
 * date: 2016/9/12
 * 直播房间列表的Adapter
 */
public class LiveListAdapter extends BaseQuickAdapter<LiveListItemBean, BaseViewHolder>{
    public LiveListAdapter(List<LiveListItemBean> data) {
        super(R.layout.item_live_list_layout, data);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, LiveListItemBean bean) {
        viewHolder.setText(R.id.live_tv_roomname, bean.getLive_title())//房间名称
                .setText(R.id.live_tv_nickname, bean.getLive_nickname())//主播昵称
                .setText(R.id.live_tv_online, String.valueOf(bean.getLive_online()))//在线人数
                .addOnClickListener(R.id.live_cardview);//添加子Item点击监听，在UI中实现回调接口

        Glide.with(mContext)//直播房间截图
                .load(bean.getLive_img())
                .crossFade()
                .centerCrop()
                .into((ImageView) viewHolder.getView(R.id.live_iv_roomsrc));

        Glide.with(mContext)//主播头像
                .load(bean.getLive_userimg())
                .crossFade()
                .centerCrop()
                .into((ImageView) viewHolder.getView(R.id.live_iv_avatar));
    }
}
