package com.example.mentorship.Mentor.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.mentorship.R;

public class RegisterToBeMentorActivity extends AppCompatActivity {
    private EditText editText_exper, editText_study, editText_skill, editText_degree_link, editText_degree_des, editText_award;
    private Button button_reg;
    private ImageButton imageButton_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.mentorship.R.layout.register_to_be_mentor_activity);
        refer();
    }

    public void refer() {
        editText_exper = findViewById(R.id.reg_mentor_editText_experience);
        editText_study = findViewById(R.id.reg_mentor_editText_study);
        editText_skill = findViewById(R.id.reg_mentor_editText_skill);
        editText_degree_link = findViewById(R.id.reg_mentor_editText_degree_link);
        editText_degree_des = findViewById(R.id.reg_mentor_editText_degree_description);
        editText_award = findViewById(R.id.reg_mentor_editText_award);
        button_reg = findViewById(R.id.reg_mentor_button_register);
        imageButton_back = findViewById(R.id.reg_mentor_imageButton_back);
    }

    public void reg_mentor_register(View view) {
        if (editText_exper.getText().toString().length() == 0 || editText_degree_des.getText().toString().length() == 0
                || editText_skill.getText().toString().length() == 0 || editText_degree_link.getText().toString().length() == 0
                || editText_degree_link.getText().toString().length() == 0 || editText_degree_des.getText().toString().length() == 0
                || editText_award.getText().toString().length() == 0 || editText_study.getText().toString().length() == 0)
            Toast.makeText(this, "Điền thiếu", Toast.LENGTH_SHORT).show();
        else {
            startActivity(new Intent(this, RegisterToBeMentorResult.class));
            finish();
        }
    }

    public void reg_mentor_back(View view) {
        finish();
    }
}