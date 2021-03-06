package com.example.a83776.netease.entertainment.viewholder;

import com.example.a83776.netease.base.ui.TViewHolder;
import com.example.a83776.netease.im.session.viewholder.MsgViewHolderFactory;
import com.example.a83776.netease.im.session.viewholder.MsgViewHolderUnknown;
import com.netease.nimlib.sdk.msg.attachment.MsgAttachment;
import com.netease.nimlib.sdk.msg.constant.MsgTypeEnum;
import com.netease.nimlib.sdk.msg.model.IMMessage;

import java.util.HashMap;

/**
 * 聊天室消息项展示ViewHolder工厂类。
 */
public class ChatRoomMsgViewHolderFactory {

    private static HashMap<Class<? extends MsgAttachment>, Class<? extends TViewHolder>> viewHolders = new HashMap<>();

    static {
        // built in
    }

    public static void register(Class<? extends MsgAttachment> attach, Class<? extends TViewHolder> viewHolder) {
        viewHolders.put(attach, viewHolder);
    }

    public static Class<? extends TViewHolder> getViewHolderByType(IMMessage message) {
        if (message.getMsgType() == MsgTypeEnum.text) {
            return MsgViewHolderChat.class;
        } else {
            Class<? extends TViewHolder> viewHolder = null;
            if (message.getAttachment() != null) {
                Class<? extends MsgAttachment> clazz = message.getAttachment().getClass();
                while (viewHolder == null && clazz != null) {
                    viewHolder = viewHolders.get(clazz);
                    if (viewHolder == null) {
                        clazz = MsgViewHolderFactory.getSuperClass(clazz);
                    }
                }
            }
            return viewHolder == null ? MsgViewHolderUnknown.class : viewHolder;
        }
    }

    public static int getViewTypeCount() {
        // plus text and unknown
        return viewHolders.size() + 2;
    }
}
