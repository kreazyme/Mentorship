package com.example.mentorship.Calendar;
import android.app.Dialog;
import android.app.Fragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mentorship.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class CalendarFragment extends Fragment implements PlanClickListener {
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
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.calendar_fragment,container,false);
        refer(view);
        renderActList();
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                //String str = s_calendar.format(calendarView.getDate());
                day = i2+"-"+(i1+1)+"-"+i;
                Toast.makeText(getContext(), day, Toast.LENGTH_SHORT).show();
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
        return view;
    }
    public void refer(View view){
        textView_time = view.findViewById(R.id.calendar_textView_time);
        textView_numOfAct = view.findViewById(R.id.calendar_textView_numOfAct);
        calendarView = view.findViewById(R.id.calendar_calendarView);
        rActList = view.findViewById(R.id.calendar_recyclerView_act_list);
    }
    public void openPickActDialog(){
        Dialog dialog = new Dialog(getContext());
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
        imageButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
                getContext(),
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
                getContext(),
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
}
