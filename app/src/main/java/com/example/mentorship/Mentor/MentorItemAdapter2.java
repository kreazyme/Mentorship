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

public class MentorItemAdapter2 extends RecyclerView.Adapter<MentorItemAdapter2.ItemViewHolder> {
    List<Mentor> mentorList;
    private MentorItemClickListener mentorItemClickListener;

    public MentorItemAdapter2(List<Mentor> mentorList, MentorItemClickListener mentorItemClickListener) {
        this.mentorList = mentorList;
        this.mentorItemClickListener = mentorItemClickListener;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.mentor_item_2,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MentorItemAdapter2.ItemViewHolder holder, int position) {
        Mentor mentor = mentorList.get(position);
        holder.imageView_avatar.setImageResource(mentor.getAvatar());
        holder.textView_name.setText(mentor.getName());
        holder.textView_job.setText(mentor.getJob()+" at "+mentor.getWorkPlace());
        holder.textView_numOfMentee.setText(mentor.getNumOfMentee()+"");
        holder.textView_numOfFollowers.setText(mentor.getNumOfFollowers()+"");
    }

    @Override
    public int getItemCount() {
        return mentorList.size();
    }
    public class ItemViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView_avatar;
        private TextView textView_name,textView_job,textView_numOfMentee,textView_numOfFollowers;
        private ImageView imageView_follow;
        private MentorItemClickListener _mentorItemClickListener;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView_avatar = itemView.findViewById(R.id.mentor_item_imageView_avatar);
            textView_name = itemView.findViewById(R.id.mentor_item_textView_name);
            textView_job = itemView.findViewById(R.id.mentor_item_textView_job);
            textView_numOfMentee = itemView.findViewById(R.id.mentor_item_textView_numOfMentee);
            textView_numOfFollowers = itemView.findViewById(R.id.mentor_item_textView_numOfFollowers);
            imageView_follow = itemView.findViewById(R.id.mentor_item_imageButton_follow);
            _mentorItemClickListener = mentorItemClickListener;
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (_mentorItemClickListener!=null){
                        _mentorItemClickListener.onMentorItemClickListener(getAdapterPosition());
                    }
                }
            });
        }
    }
}

