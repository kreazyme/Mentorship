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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mentorship.Mentor.Activity.MentorDetail;
import com.example.mentorship.Mentor.Activity.MentorResult;
import com.example.mentorship.R;
import com.example.mentorship.utils.MentorUtils;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MentorFragment extends Fragment implements MentorItemClickListener {
    private RecyclerView recyclerView;
    private Spinner spinner_field,spinner_lang;
    private Button button_find_mentor;
    private List<Mentor> mentorList = new ArrayList<>();
    DatabaseReference mentorRef = FirebaseDatabase.getInstance().getReference().child("Mentor");
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mentor,container,false);
        refer(view);
        addMentorList();
        setFieldSpinner();
        setLanguageSpinner();
        button_find_mentor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), MentorResult.class));
            }
        });
        return view;
    }
    public void addMentorList(){
        ArrayList<MentorActivity> list = new ArrayList<>();
        list.add(new MentorActivity(R.drawable.android,"Định hướng và chia sẻ kinh nghiệm trong lĩnh vực Mobile Android","Java"));
        list.add(new MentorActivity(R.drawable.java,"Chia sẻ kinh nghiệm về Java","Java"));
        recyclerView.setHasFixedSize(true);
        MentorItemAdapter adapter = new MentorItemAdapter(mentorList, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(
                getContext(),
                LinearLayoutManager.HORIZONTAL,
                false
        );
        recyclerView.setLayoutManager(layoutManager);
        //recyclerView.setAdapter(adapter);
        getFullListMentor();
    }
    public void setFieldSpinner(){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                getContext(),
                R.array.field,
                android.R.layout.simple_spinner_item
        );
        spinner_field.setAdapter(adapter);
    }
    public void setLanguageSpinner(){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                getContext(),
                R.array.language,
                android.R.layout.simple_spinner_item
        );
        spinner_lang.setAdapter(adapter);
    }
    @Override
    public void onMentorItemClickListener(int position) {
        Mentor mentor = mentorList.get(position);
        startIntent(mentor);
    }
    public void startIntent(Mentor mentor){
        Intent intent = new Intent(getActivity(), MentorDetail.class);
        intent.putExtra("Mentor",mentor);
        startActivity(intent);
    }
    public void refer(View view){
        recyclerView = view.findViewById(R.id.mentor_recyclerView_mentorList);
        spinner_field = view.findViewById(R.id.mentor_spinner_fields);
        spinner_lang = view.findViewById(R.id.mentor_spinner_lang);
        button_find_mentor = view.findViewById(R.id.mentor_button_find_mentor);
    }


    public void getFullListMentor() {
        // TODO: return list of ... mentor and set to adapter
        List<Mentor> result = new ArrayList<>();
        mentorRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot mentorSnapshot: snapshot.getChildren()) {
                    Mentor mentor = mentorSnapshot.getValue(Mentor.class);
                    mentorList.add(mentor);
                }
                MentorItemAdapter adapter = new MentorItemAdapter(mentorList,MentorFragment.this);
                recyclerView.setAdapter(adapter);
                //setDataRecycleView(recyclerView,result);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                //Toast
            }
        });
    }

}

