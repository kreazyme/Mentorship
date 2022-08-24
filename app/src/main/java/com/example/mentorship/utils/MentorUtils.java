package com.example.mentorship.utils;

import androidx.annotation.NonNull;

import com.example.mentorship.Mentor.Mentor;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MentorUtils {
    DatabaseReference mentorRef = FirebaseDatabase.getInstance().getReference().child("Mentor");

    public void addMentor(Mentor mentor) {
        try {
            mentorRef.push().setValue(mentor);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }



    public void getTenHightlightMentors(){
        List<Mentor> result = new ArrayList<>();
        mentorRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<Mentor> mentors = new ArrayList<>();

                for (DataSnapshot mentorSnapshot: snapshot.getChildren()) {
                    mentors.add(mentorSnapshot.getValue(Mentor.class));
                }
                List<Mentor> mentors2 = mentors.stream().sorted(Comparator.comparing(Mentor::getNumOfFollowers))
                        .collect(Collectors.toList());
                for (int i = 0; i < 10; i++) {
                    result.add(mentors2.get(i));
                }
                /** Set result to your adapter **/
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                //Toast
            }
        });
    }

    public void findMentorByID (String id) {
        mentorRef.equalTo(id)
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        Mentor result = snapshot.getValue(Mentor.class);
                        /** Set result to your adapter **/
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        //Toast
                    }
                });
    }

    public void findMentorBySpecialized(List<String> specialized) {
        mentorRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<Mentor> mentors = new ArrayList<>();
                for (DataSnapshot mentorSnapshot: snapshot.getChildren()) {
                    mentors.add(mentorSnapshot.getValue(Mentor.class));
                }
                List<Mentor> result = mentors.stream().filter(mentor -> mentor.getExperienceList().containsAll(specialized))
                        .collect(Collectors.toList());
                /** Set result to your adapter **/
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                //Toast
            }
        });
    }


}