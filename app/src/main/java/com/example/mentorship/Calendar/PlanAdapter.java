package com.example.mentorship.Calendar;

import android.content.ClipData;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mentorship.R;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class PlanAdapter extends RecyclerView.Adapter<PlanAdapter.ItemViewHolder>{
    List<Plan> planList = new ArrayList<>();
    private PlanClickListener p;

    public PlanAdapter(List<Plan> planList, PlanClickListener p) {
        this.planList = planList;
        this.p = p;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.calendar_plan_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Plan plan = planList.get(position);
        holder.textView_time_start.setText(plan.getTime_start());
        holder.textView_time_end.setText(plan.getTime_end());
        holder.textView_activity.setText(plan.getActivity());

    }


    @Override
    public int getItemCount() {
        return planList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
       private TextView textView_time_start,textView_time_end;
       private TextView textView_activity;
       private PlanClickListener _p;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            textView_time_start = itemView.findViewById(R.id.calendar_plan_item_textView_time_start);
            textView_time_end = itemView.findViewById(R.id.calendar_plan_item_textView_time_end);
            textView_activity = itemView.findViewById(R.id.calendar_plan_item_textView_activity);
            _p = p;
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (_p != null){
                        _p.onPlanClickListener(getAdapterPosition());
                    }
                }
            });
        }
    }
}
