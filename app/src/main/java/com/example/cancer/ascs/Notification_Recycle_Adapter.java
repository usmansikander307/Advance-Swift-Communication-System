package com.example.cancer.ascs;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cancer.ascs.ModelClasses.NotificationArrayItem;
import com.example.cancer.ascs.R;
import com.example.cancer.ascs.TimetableArray;
import com.example.cancer.ascs.Timetable_Recycle_Adapter;

import java.util.List;

public class Notification_Recycle_Adapter extends RecyclerView.Adapter<Notification_Recycle_Adapter.myViewHolder>{
    List<NotificationArrayItem> datalist;
    Context context;
    public Notification_Recycle_Adapter(Context context, List<NotificationArrayItem> data) {
        this.context = context;
        this.datalist = data;
    }

    @NonNull
    @Override
    public Notification_Recycle_Adapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.activity_notification_recycle, parent, false);
        return new Notification_Recycle_Adapter.myViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Notification_Recycle_Adapter.myViewHolder holder, int position) {
        holder.txt_admin.setText(datalist.get(position).getAName().toString());
        holder.txt_date.setText(datalist.get(position).getNtDate().toString());
        holder.txt_body.setText(datalist.get(position).getNtBody().toString());

    }

    @Override
    public int getItemCount() {return datalist.size();

    }
    public class myViewHolder extends RecyclerView.ViewHolder
    {
        TextView txt_admin,txt_date, txt_body;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_admin = itemView.findViewById(R.id.txt_admin);
            txt_date = itemView.findViewById(R.id.txt_date);
            txt_body= itemView.findViewById(R.id.txt_body);
        }
    }
}
