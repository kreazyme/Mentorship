package com.example.mentorship.Chat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mentorship.R;

import java.util.ArrayList;

public class ChatScreen extends AppCompatActivity {
    private ArrayList<Message> lsChat = new ArrayList<>();
    private RecyclerView rcvChat;
    private ChatAdapter chatAdapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_screen);

        rcvChat = findViewById(R.id.chat_recyclerview);

        lsChat.add(new Message("Hello", true));
        lsChat.add(new Message("Chao bạn nhé", true));
        lsChat.add(new Message("Chao bạn nhéChao bạn nhéChao bạn nhéChao bạn nhéChao bạn nhé", false));
        lsChat.add(new Message("Chao bạn nhéChao bạn nhéChao bạn nhé", true));
        lsChat.add(new Message("Chao bạn nhé  Chao bạn nhé", true));
        lsChat.add(new Message("Hello", true));
        lsChat.add(new Message("Hello", true));
        lsChat.add(new Message("Chao bạn nhé", true));
        lsChat.add(new Message("Chao bạn nhéChao bạn nhéChao bạn nhéChao bạn nhéChao bạn nhé", false));
        lsChat.add(new Message("Chao bạn nhéChao bạn nhéChao bạn nhé", true));
        lsChat.add(new Message("Chao bạn nhé  Chao bạn nhé", true));
        lsChat.add(new Message("Hello", true));

//        chatAdapter = new HeroAdapter(this,mHeros);
//        mRecyclerHero.setAdapter(mHeroAdapter);
//        mRecyclerHero.setLayoutManager(new LinearLayoutManager(this));
        chatAdapter = new ChatAdapter(lsChat);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcvChat.setHasFixedSize(true);
        rcvChat.setLayoutManager(manager);
        rcvChat.setAdapter(chatAdapter);
    }
}