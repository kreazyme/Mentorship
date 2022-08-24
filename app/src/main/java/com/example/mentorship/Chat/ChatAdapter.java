package com.example.mentorship.Chat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mentorship.R;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {

    private ArrayList<Message> mChat;
    public static  final int MSG_TYPE_LEFT = 0;
    public static  final int MSG_TYPE_RIGHT = 1;
    public ChatAdapter( ArrayList<Message> chat) {
        this.mChat = chat;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == MSG_TYPE_LEFT){
            return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.chatitem, parent, false));
        }
        else {
            return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_item_me, parent, false));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (mChat.get(position).isFromme()){
            return MSG_TYPE_RIGHT;
        } else {
            return MSG_TYPE_LEFT;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String chatitem = mChat.get(position).getMessage();

        holder.txtView.setText(chatitem);
    }

    @Override
    public int getItemCount() {
        return mChat.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtView = itemView.findViewById(R.id.chat_text);
        }

    }
}
