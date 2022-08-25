package com.example.mentorship.Profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mentorship.Mentor.Mentor;
import com.example.mentorship.R;
import com.example.mentorship.entity.Degree;

import java.util.ArrayList;

public class ProfileDetail extends AppCompatActivity {
    TextView textView_intro,textView_numOfMentor,textView_numOfMentee,textView_numOfHourMent,textView_numOfFollowers;
    ListView rExperience,rStudy,rSkill,rDegree,rAward;
    Mentor mentor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_detail_activity);
        Intent intent = getIntent();
        mentor = (Mentor) intent.getSerializableExtra("Mentor");
        refer();
        setValueToView();
    }
    public void refer(){
        textView_intro = findViewById(R.id.profile_detail_textView_intro);
        textView_numOfMentor = findViewById(R.id.profile_detail_textView_numOfMentor);
        textView_numOfMentee = findViewById(R.id.profile_detail_textView_numOfMentee);
        textView_numOfHourMent = findViewById(R.id.profile_detail_textView_numOfHourMent);
        textView_numOfFollowers = findViewById(R.id.profile_detail_textView_numOfFollowers);
        rExperience = findViewById(R.id.profile_detail_listView_exper);
        rStudy = findViewById(R.id.profile_detail_listView_study);
        rSkill = findViewById(R.id.profile_detail_listView_skill);
        rDegree = findViewById(R.id.profile_detail_listView_degree);
        rAward = findViewById(R.id.profile_detail_listView_award);
    }
    public void setValueToView(){
        textView_intro.setText(mentor.getIntroduction());
        textView_numOfMentor.setText(mentor.getNumOfMentor()+"");
        textView_numOfMentee.setText(mentor.getNumOfMentee()+"");
        textView_numOfHourMent.setText(mentor.getNumOfHourMent()+"");
        textView_numOfFollowers.setText(mentor.getNumOfFollowers()+"");
        setValueToListView(mentor.getExperienceList(),rExperience,R.drawable.profile_experience);
        setValueToListView(mentor.getStudyList(),rStudy,R.drawable.profile_study);
        setValueToListView(mentor.getSkillList(),rSkill,R.drawable.profile_skill);
        setValueToListView(getDegreeNameList(mentor.getDegreeList()),rDegree,R.drawable.profile_degree);
        setValueToListView(mentor.getAwardList(),rAward,R.drawable.profile_award);
    }
    public void setValueToListView(ArrayList<String> list, ListView listView,int pic){
        ArrayList<OtherInfo> otherInfoList = new ArrayList<>();
        OtherInfoAdapter adapter;
        for (String x : list){
            otherInfoList.add(new OtherInfo(pic,x));
        }
        adapter = new OtherInfoAdapter(this, R.layout.profile_detail_info_item,otherInfoList);
        listView.setAdapter(adapter);
    }
    public void back(View view){
        finish();
    }
    public ArrayList<String> getDegreeNameList(ArrayList<Degree> list){
        ArrayList<String> temp = new ArrayList<>();
        for (Degree x: mentor.getDegreeList()){
            temp.add(x.getSpecialized()+" :"+x.getLink());
        }
        return temp;
    }
}