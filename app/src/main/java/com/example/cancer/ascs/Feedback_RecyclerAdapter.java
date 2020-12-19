package com.example.cancer.ascs;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cancer.ascs.ModelClasses.DataOperator.FeedbacksItem;

import java.util.List;

public class Feedback_RecyclerAdapter extends RecyclerView.Adapter<Feedback_RecyclerAdapter.myViewHolder> {

    Context mContext;
    List<FeedbacksItem> Feedbacklist;

    public Feedback_RecyclerAdapter(Context mContext, List<FeedbacksItem> feedbacklist) {
        this.mContext = mContext;
        Feedbacklist = feedbacklist;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.recycler_feedback, viewGroup, false);
        return new Feedback_RecyclerAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder myViewHolder, int i) {
        myViewHolder.aridNo.setText(Feedbacklist.get(i).getArid());
        myViewHolder.date.setText(Feedbacklist.get(i).getDate());
        myViewHolder.a1.setText(Feedbacklist.get(i).getQ1());
        myViewHolder.a2.setText(Feedbacklist.get(i).getQ2());
        myViewHolder.a3.setText(Feedbacklist.get(i).getQ3());
        myViewHolder.a4.setText(Feedbacklist.get(i).getQ4());
        myViewHolder.a5.setText(Feedbacklist.get(i).getQ5());
        myViewHolder.a6.setText(Feedbacklist.get(i).getQ6());


    }

    @Override
    public int getItemCount() {
        return Feedbacklist.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder
    {
        TextView a1,a2,a3,a4,a5,a6,aridNo,date;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            a1=itemView.findViewById(R.id.res1);
            a2=itemView.findViewById(R.id.res2);
            a3=itemView.findViewById(R.id.res3);
            a4=itemView.findViewById(R.id.res4);
            a5=itemView.findViewById(R.id.res5);
            a6=itemView.findViewById(R.id.res6);
            date=itemView.findViewById(R.id.txt33);
            aridNo=itemView.findViewById(R.id.etarid);
        }
    }
}
