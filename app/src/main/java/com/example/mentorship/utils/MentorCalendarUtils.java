package com.example.mentorship.utils;

import androidx.annotation.NonNull;

import com.example.mentorship.entity.MentorCalendar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MentorCalendarUtils {
    DatabaseReference calendarRef = FirebaseDatabase.getInstance().getReference().child("MentorCalendar");

    public void addMentorCalendar(MentorCalendar calendar) {

        calendarRef.push().setValue(calendar);
    }

    public List<MentorCalendar> getMentorCalendarByMentorID(int mentorID) {
        List<MentorCalendar> calendarList = new ArrayList<>();
        calendarRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot calendarSnapshot : snapshot.getChildren()) {
                    MentorCalendar calendar = calendarSnapshot.getValue(MentorCalendar.class);
                    if(calendar.getMentorID() == mentorID) {
                        calendarList.add(calendar);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return calendarList;
    }

}
