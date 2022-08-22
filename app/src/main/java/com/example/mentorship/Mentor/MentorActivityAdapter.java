package com.example.mentorship.Mentor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mentorship.R;

import java.util.List;

public class MentorActivityAdapter extends RecyclerView.Adapter<MentorActivityAdapter.ItemViewHolder>{
    List<MentorActivity> mentorActivityList;
   private MentorActivityClickListener m;
    public MentorActivityAdapter(List<MentorActivity> mentorActivityList) {
        this.mentorActivityList = mentorActivityList;
    }

    public MentorActivityAdapter(List<MentorActivity> mentorActivityList, MentorActivityClickListener m) {
        this.mentorActivityList = mentorActivityList;
        this.m = m;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.mentor_detail_field_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        MentorActivity item = mentorActivityList.get(position);
        holder.picture.setImageResource(item.getActivityPicture());
        holder.activity.setText(item.getActivity());
        holder.language.setText(item.getLanguage());
    }

    @Override
    public int getItemCount() {
        return mentorActivityList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        private ImageView picture;
        private TextView activity;
        private TextView language;
        private MentorActivityClickListener _m;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            picture = itemView.findViewById(R.id.mentor_detail_field_item_imageView_act);
            activity = itemView.findViewById(R.id.mentor_detail_field_item_textView_act);
            language = itemView.findViewById(R.id.mentor_detail_field_item_textView_language);
            _m = m;
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (_m != null){
                        _m.onMentorActivityClickListener(getAdapterPosition());
                    }
                }
            });
        }
    }
}
