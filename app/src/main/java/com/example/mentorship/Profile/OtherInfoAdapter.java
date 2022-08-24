package com.example.mentorship.Profile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mentorship.R;

import java.util.ArrayList;
import java.util.List;

public class OtherInfoAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<OtherInfo> otherInfoList = new ArrayList<>() ;

    public OtherInfoAdapter(Context context, int layout, List<OtherInfo> otherInfoList) {
        this.context = context;
        this.layout = layout;
        this.otherInfoList = otherInfoList;
    }

    @Override
    public int getCount() {
        return otherInfoList.size();
    }

    @Override
    public Object getItem(int i) {
        return 0;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout,null);

        // ánh xạ view
        ImageView imageView = view.findViewById(R.id.profile_detail_info_item_imageView_pic);
        TextView textView = view.findViewById(R.id.profile_detail_info_item_textView_content);
        OtherInfo other = otherInfoList.get(i);
        imageView.setImageResource(other.getPic());
        textView.setText(other.getInfo());
        return view;
    }
}
