package com.example.mentorship.Calendar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.mentorship.Mentor.Mentor;
import com.example.mentorship.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class CalendarActivity extends AppCompatActivity implements PlanClickListener {
   private Mentor mentor;
    private TextView textView_time,textView_numOfAct;
    private CalendarView calendarView;
    private RecyclerView rActList;
    private PlanAdapter adapter;
    private ArrayList<Plan> planList = new ArrayList<>(Arrays.asList(
            new Plan("12:00 PM","13:00 PM","Tư vấn Android")
    ));
    String day;
    private Map<String,ArrayList<Plan>> mapPlan = new HashMap<>();
    SimpleDateFormat s = new SimpleDateFormat("HH:mm");
    SimpleDateFormat s_calendar = new SimpleDateFormat("DD-MM-YY");
    ImageButton imageButtonBack ;
    TextView textView_pick_time_start,textView_pick_time_end ;
    EditText editText_act;
    Button button_add_act ;
    ImageView imageView_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_activity);
        Intent intent = getIntent();
        mentor = (Mentor) intent.getSerializableExtra("Mentor");
        refer();
        renderActList();
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                //String str = s_calendar.format(calendarView.getDate());
                day = i2+"-"+(i1+1)+"-"+i;
                Toast.makeText(getApplicationContext(), day, Toast.LENGTH_SHORT).show();
                //hiển thị danh sách hoạt động + hiển thị số hoạt động trong ngày
                //nếu danh sách hoạt động khác null thì render ra
                //nếu không thì in ra mặc định
                if (mapPlan.get(day)!=null){
                    setTextViewNumOfAct(mapPlan.get(day).size(),day);
                    planList = mapPlan.get(day);
                }
                else{
                    planList = new ArrayList<>(Arrays.asList(
                            new Plan("12:00 PM","13:00 PM","Tư vấn Android")
                    ));
                    setTextViewNumOfAct(1,day);
                }
                renderActList();
                //hiển thị dialog add hoạt động
                openPickActDialog();
            }
        });
    }
    public void refer(){
        textView_time = findViewById(R.id.calendar_acti_textView_time);
        textView_numOfAct = findViewById(R.id.calendar_acti_textView_numOfAct);
        calendarView = findViewById(R.id.calendar_acti_calendarView);
        rActList = findViewById(R.id.calendar_acti_recyclerView_act_list);
        imageView_back = findViewById(R.id.calendar_acti_imageView_back);
    }
    public void openPickActDialog(){
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.calendar_dialog_pick_date);
        imageButtonBack = dialog.findViewById(R.id.calendar_dialog_imageButton_back);
        textView_pick_time_start = dialog.findViewById(R.id.calendar_dialog_textView_pick_time_start);
        textView_pick_time_end = dialog.findViewById(R.id.calendar_dialog_textView_pick_time_end);
        editText_act = dialog.findViewById(R.id.calendar_dialog_editText_activity);
        button_add_act = dialog.findViewById(R.id.calendar_dialog_button_add_act);
        textView_pick_time_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTimePicker(textView_pick_time_start);
            }
        });
        textView_pick_time_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTimePicker(textView_pick_time_end);
            }
        });
        button_add_act.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String act = editText_act.getText().toString();
                String time_start = textView_pick_time_start.getText().toString();
                String time_end = textView_pick_time_end.getText().toString();
//                String str = s_calendar.format(calendarView.getDate());
                planList.add(new Plan(time_start,time_end,act));
                //nếu danh sách hoạt động là null => thêm danh sách hoạt động tương ứng với ngày đó vào map
                //nếu không thì làm bth
                if (mapPlan.get(day) == null) {
                    mapPlan.put(day,new ArrayList<>(Arrays.asList(
                            new Plan("12:00 PM","13:00 PM","Tư vấn android")
                    )));
                }
                mapPlan.get(day).add(new Plan(time_start,time_end,act));
                renderActList();
                setTextViewNumOfAct(mapPlan.get(day).size(),day);
                dialog.dismiss();
            }
        });
        dialog.show();
    }
    public void renderActList(){
        if (mapPlan.get(day) != null){
            planList = mapPlan.get(day);
        }
        rActList.setHasFixedSize(true);
        adapter = new PlanAdapter(planList,this);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(
                this,
                RecyclerView.VERTICAL,
                false
        );
        rActList.setLayoutManager(manager);
        rActList.setAdapter(adapter);
    }
    public void openTimePicker(TextView textView){
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR);
        int min = calendar.get(Calendar.MINUTE);
        int sec = calendar.get(Calendar.SECOND);
        TimePickerDialog timePicker = new TimePickerDialog(
                this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        calendar.set(0,0,0,i,i1);
                        //textView_pick_time.setText(calendar.getTime()+"");
                        textView.setText(s.format(calendar.getTime())+"");
                    }
                },hour,min,true
        );
        timePicker.show();
    }
    @Override
    public void onPlanClickListener(int i) {

    }
    public void setTextViewNumOfAct(int i,String day){
        textView_numOfAct.setText("Bạn có "+i+" hoạt động vào "+day);
    }
    public void goBack(View view){
        finish();
    }
}