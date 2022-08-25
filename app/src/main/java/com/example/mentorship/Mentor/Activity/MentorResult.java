package com.example.mentorship.Mentor.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.mentorship.Mentor.Mentor;
import com.example.mentorship.Mentor.MentorActivity;
import com.example.mentorship.Mentor.MentorItemAdapter2;
import com.example.mentorship.Mentor.MentorItemClickListener;
import com.example.mentorship.R;

import java.util.ArrayList;
import java.util.Arrays;

public class MentorResult extends AppCompatActivity implements MentorItemClickListener {
    ArrayList<MentorActivity> list = new ArrayList<>(Arrays.asList(
            new MentorActivity(R.drawable.android, "Định hướng và chia sẻ kinh nghiệm trong lĩnh vực Mobile Android", "Java"),
            new MentorActivity(R.drawable.java, "Chia sẻ kinh nghiệm về Java", "Java")
    ));
    ArrayList<Mentor> mentorList = new ArrayList<>(Arrays.asList(
            new Mentor(R.drawable.mentor_avatar, "Đình Hiếu Lê", "Java Senior", "MDC Software", 100, 200, 300, (float) 4.9, "Hi every one, I'm Hieu", list, 78),
            new Mentor(R.drawable.mentor_avatar, "Trần Đức", "Java Intern", "DN Software", 100, 100, 400, 5.0F, "Hi, I'm Trần Đức Bo", list, 80),
            new Mentor(R.drawable.mentor_avatar, "Lê Thu Thảo", "CEO", "Korin", 100, 300, 100, (float) 4.8, "Hi everyon", list, 200),
            new Mentor(R.drawable.mentor_avatar, "Hoàng Doãn", "Java Senior", "CMC Software", 100, 100, 300, 4.5F, "Hi", list, 100)
    ));
    private RecyclerView rMentList;
    private ImageButton imageButton_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mentor_result_activity);
        refer();
        renderMentorList();
        imageButton_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void refer() {
        rMentList = findViewById(R.id.mentor_result_recyclerView_mentor_list);
        imageButton_back = findViewById(R.id.mentor_result_imageButton_back);
    }

    public void renderMentorList() {
        rMentList.setHasFixedSize(true);
        MentorItemAdapter2 adapter = new MentorItemAdapter2(mentorList, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(
                this,
                RecyclerView.VERTICAL,
                false
        );
        rMentList.setLayoutManager(layoutManager);
        rMentList.setAdapter(adapter);
    }

    @Override
    public void onMentorItemClickListener(int position) {
        Intent intent = new Intent(this,MentorDetail.class);
        Mentor mentor = mentorList.get(position);
        intent.putExtra("Mentor",mentor);
        startActivity(intent);
    }
}