package com.example.mentorship.Mentor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.example.mentorship.Calendar.CalendarActivity;
import com.example.mentorship.Chat.ChatScreen;
import com.example.mentorship.R;

import java.util.ArrayList;

public class MentorDetail extends AppCompatActivity implements MentorActivityClickListener {
   private TextView textView_numOfMentee,textView_numOfHourMent,textView_rate,textView_intro,textView_name;
   private RecyclerView recyclerView;
   private Mentor mentor = new Mentor();
   private ImageButton button_back;
   public Button button_set_schedule,button_message,button_like;
   private Button Chat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mentor_detail_activity);
        Intent intent = getIntent();
        mentor = (Mentor) intent.getSerializableExtra("Mentor");
        refer();
        textView_numOfHourMent = findViewById(R.id.mentor_detail_textView_numOfHourMentor);
        textView_rate = findViewById(R.id.mentor_detail_textView_rate);
        textView_intro = findViewById(R.id.mentor_detail_textView_introduce);
        textView_name = findViewById(R.id.mentor_detail_textView_name);
        recyclerView = findViewById(R.id.mentor_detail_recyclerView_fields);
        button_back = findViewById(R.id.mentor_detail_imageButton_back);
        textView_numOfMentee.setText(mentor.getNumOfMentee()+"");
        textView_numOfHourMent.setText(mentor.getNumOfHourMent()+"");
        textView_rate.setText(mentor.getRate()+"");
        textView_intro.setText(mentor.getIntroduction());
        textView_name.setText(mentor.getName());
        renderRecyclerView(mentor.getMentorActivities());
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        button_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MentorDetail.this, ChatScreen.class));
            }
        });

    }
    public void renderRecyclerView(ArrayList<MentorActivity> list){
        recyclerView.setHasFixedSize(true);
        MentorActivityAdapter adapter = new MentorActivityAdapter(list,this);
        RecyclerView.LayoutManager l = new LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false
        );
        recyclerView.setLayoutManager(l);
        recyclerView.setAdapter(adapter);
    }
    public void refer(){
        textView_numOfMentee = findViewById(R.id.mentor_detail_textView_numOfMentee);
        textView_numOfHourMent = findViewById(R.id.mentor_detail_textView_numOfHourMentor);
        textView_rate = findViewById(R.id.mentor_detail_textView_rate);
        textView_intro = findViewById(R.id.mentor_detail_textView_introduce);
        textView_name = findViewById(R.id.mentor_detail_textView_name);
        recyclerView = findViewById(R.id.mentor_detail_recyclerView_fields);
        button_back = findViewById(R.id.mentor_detail_imageButton_back);
        button_set_schedule = findViewById(R.id.mentor_detail_button_setSchedule);
        button_message = findViewById(R.id.mentor_detail_button_message);
        button_like = findViewById(R.id.mentor_detail_button_like);
    }
    @Override
    public void onMentorActivityClickListener(int i) {

    }
    public void toSettingSchedule(View view){
        Intent intent = new Intent(this, CalendarActivity.class);
        intent.putExtra("Mentor",mentor);
        startActivity(intent);
    }
    public void toLike(View view){
        Toast.makeText(this, "Like", Toast.LENGTH_SHORT).show();
    }
    public void toSendingMessage(View view){
        Toast.makeText(this, "Message", Toast.LENGTH_SHORT).show();
    }
}