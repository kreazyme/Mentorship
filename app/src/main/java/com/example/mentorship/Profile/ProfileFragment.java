package com.example.mentorship.Profile;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import com.example.mentorship.Mentor.Activity.RegisterToBeMentorActivity;
import com.example.mentorship.Mentor.Mentor;
import com.example.mentorship.Mentor.MentorActivity;
import com.example.mentorship.R;

import java.util.ArrayList;
import java.util.Arrays;

public class ProfileFragment extends Fragment {
    private Button button_watch_file;
    private CardView cardView_love, cardView_reg_to_be_mentor, cardView_share, cardView_care, cardView_feedback;
    private ImageButton button_settings;
    private ImageView imageView_avatar;
    ArrayList<MentorActivity> list = new ArrayList<>(Arrays.asList(
            new MentorActivity(R.drawable.java, "Java Senior", "Java")
    ));
    private Mentor mentor = new Mentor(R.drawable.mentor_avatar, "Đình Hiếu Lê", "Java Senior", "MDC Software", 100, 200, 300, (float) 4.9, "Hi every one, I'm Hieu", list, 78);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile, container, false);
        button_watch_file = view.findViewById(R.id.profile_button_watch_file);
        cardView_love = view.findViewById(R.id.profile_cardView_love);
        cardView_reg_to_be_mentor = view.findViewById(R.id.profile_cardView_register_to_be_mentor);
        cardView_care = view.findViewById(R.id.profile_cardView_care);
        cardView_feedback = view.findViewById(R.id.profile_cardView_feedback);
        imageView_avatar = view.findViewById(R.id.profile_imageView_avatar);
        imageView_avatar.setImageResource(mentor.getAvatar());
        button_watch_file.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ProfileDetail.class);
                intent.putExtra("Mentor", mentor);
                startActivity(intent);
            }
        });
        cardView_reg_to_be_mentor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), RegisterToBeMentorActivity.class));
            }
        });
        return view;
    }
}
