package demo.com.recyclerviewmultipletype;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leobui on 10/5/2017.
 */

public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final static int TYPE_PHOTO = 1;
    private final static int TYPE_TEXT = 2;
    private List<Object> chatListData = new ArrayList();
    private Context context;

    public ChatAdapter(Context context, List<Object> callSMSFeed) {
        this.context = context;
        this.chatListData = callSMSFeed;
    }

    @Override
    public int getItemViewType(int position) {
        if (chatListData.get(position) instanceof PhotoMessage) {
            return TYPE_PHOTO;
        } else if (chatListData.get(position) instanceof TextMessage) {
            return TYPE_TEXT;
        }
        return -1;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        int viewType = holder.getItemViewType();
        switch (viewType) {
            case TYPE_PHOTO:
                PhotoMessage call = (PhotoMessage) chatListData.get(position);
                ((PhotoViewHolder) holder).showCallDetails(call);
                break;
            case TYPE_TEXT:
                TextMessage sms = (TextMessage) chatListData.get(position);
                ((TextViewHolder) holder).showSmsDetails(sms);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return chatListData.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layout = 0;
        RecyclerView.ViewHolder viewHolder;
        switch (viewType) {
            case TYPE_PHOTO:
                layout = R.layout.item_photo;
                View callsView = LayoutInflater
                        .from(parent.getContext())
                        .inflate(layout, parent, false);
                viewHolder = new PhotoViewHolder(callsView);
                break;
            case TYPE_TEXT:
                layout = R.layout.item_text;
                View smsView = LayoutInflater
                        .from(parent.getContext())
                        .inflate(layout, parent, false);
                viewHolder = new TextViewHolder(smsView);
                break;
            default:
                viewHolder = null;
                break;
        }
        return viewHolder;
    }

    public class PhotoViewHolder extends RecyclerView.ViewHolder {

        private TextView callerNameTextView, callTimeTextView;

        public PhotoViewHolder(View itemView) {
            super(itemView);
            callerNameTextView = (TextView) itemView.findViewById(R.id.callerName);
            callTimeTextView = (TextView) itemView.findViewById(R.id.callTime);
        }

        public void showCallDetails(PhotoMessage call) {
            String callerName = call.getCallerName();
            String callTime = call.getCallTime();
            callerNameTextView.setText(callerName);
            callTimeTextView.setText(callTime);
        }
    }

    public class TextViewHolder extends RecyclerView.ViewHolder {

        private TextView senderNameTextView, smsContentTextView, smsTimeTextView;

        public TextViewHolder(View itemView) {
            super(itemView);
            senderNameTextView = (TextView) itemView.findViewById(R.id.senderName);
            smsContentTextView = (TextView) itemView.findViewById(R.id.smsContent);
            smsTimeTextView = (TextView) itemView.findViewById(R.id.smsTime);
        }

        public void showSmsDetails(TextMessage sms) {
            String senderName = sms.getSenderName();
            String smsContent = sms.getSmsContent();
            String smsTime = sms.getSmsTime();
            senderNameTextView.setText(senderName);
            smsContentTextView.setText(smsContent);
            smsTimeTextView.setText(smsTime);
        }
    }
}