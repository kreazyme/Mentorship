package com.example.mentorship.Mentor;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mentorship.R;

import java.util.ArrayList;

public class MentorFragment extends Fragment implements MentorItemClickListener {
    private RecyclerView recyclerView;
    private Spinner spinner_field,spinner_lang;
    private Button button_find_mentor;
    private ArrayList<Mentor> mentorList = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mentor,container,false);
        recyclerView = view.findViewById(R.id.mentor_recyclerView_mentorList);
        spinner_field = view.findViewById(R.id.mentor_spinner_fields);
        spinner_lang = view.findViewById(R.id.mentor_spinner_lang);
        button_find_mentor = view.findViewById(R.id.mentor_button_find_mentor);
        addMentorList();
        setFieldSpinner();
        return view;
    }
    public void addMentorList(){
        ArrayList<MentorActivity> list = new ArrayList<>();
        list.add(new MentorActivity(R.drawable.android,"Định hướng và chia sẻ kinh nghiệm trong lĩnh vực Mobile Android","Java"));
        list.add(new MentorActivity(R.drawable.java,"Chia sẻ kinh nghiệm về Java","Java"));
        mentorList.add(new Mentor(R.drawable.mentor_avatar,"Đình Hiếu Lê","Java Senior","MDC Software",200,300, (float) 4.9,"Hi every one, I'm Hieu",list,78));
        mentorList.add(new Mentor(R.drawable.mentor_avatar,"Trần Đức","Java Intern","DN Software",100,400, 5.0F,"Hi, I'm Trần Đức Bo",list,80));
        mentorList.add(new Mentor(R.drawable.mentor_avatar,"Lê Thu Thảo","CEO","Korin",300,100, (float) 4.8,"Hi everyon",list,200));
        mentorList.add(new Mentor(R.drawable.mentor_avatar,"Hoãng Doãn","Java Senior","CMC Software",100,300, 4.5F,"Hi",list,100));
        recyclerView.setHasFixedSize(true);
        MentorItemAdapter adapter = new MentorItemAdapter(mentorList,this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(
                getContext(),
                LinearLayoutManager.HORIZONTAL,
                false
        );
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
    public void setFieldSpinner(){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                getContext(),
                R.array.field,
                android.R.layout.simple_spinner_item
        );
        spinner_field.setAdapter(adapter);
    }
    @Override
    public void onMentorItemClickListener(int position) {
        Mentor mentor = mentorList.get(position);
        startIntent(mentor);
    }
    public void startIntent(Mentor mentor){
        Intent intent = new Intent(getActivity(),MentorDetail.class);
        intent.putExtra("Mentor",mentor);
        startActivity(intent);
    }
}
