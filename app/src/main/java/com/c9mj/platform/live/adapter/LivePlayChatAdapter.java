package com.c9mj.platform.live.adapter;

import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.c9mj.platform.R;
import com.c9mj.platform.live.mvp.model.bean.DanmuBean;
import com.c9mj.platform.live.mvp.model.bean.LiveListItemBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;
import java.util.Queue;

/**
 * author: LMJ
 * date: 2016/9/12
 * 直播弹幕聊天室的Adapter
 */
public class LivePlayChatAdapter extends BaseQuickAdapter<DanmuBean, BaseViewHolder>{
    public LivePlayChatAdapter(List<DanmuBean> data) {
        super(R.layout.item_live_play_chat_list_layout, data);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, DanmuBean bean) {

        String name = TextUtils.isEmpty(bean.getData().getFrom().getNickName()) ? bean.getData().getFrom().getUserName() : bean.getData().getFrom().getNickName();
        if (TextUtils.isEmpty(name)){
            name = "游客";
        }
        String content = bean.getData().getContent();
        viewHolder.setText(R.id.chat_tv_nickname, name)//昵称
                .setTextColor(R.id.chat_tv_nickname, mContext.getResources().getColor(R.color.color_primary_dark))
                .setText(R.id.chat_tv_content, content);//弹幕内容
        if (!TextUtils.isEmpty(name) && mContext != null) {
            if (name.equals(mContext.getString(R.string.chat_name))) {
                viewHolder.setTextColor(R.id.chat_tv_nickname, mContext.getResources().getColor(R.color.color_accent));
            }
        }
    }
}
