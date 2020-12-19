package com.example.cancer.ascs;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.cancer.ascs.ModelClasses.DataOperator.FeedbackResponse;
import com.example.cancer.ascs.ModelClasses.DataOperator.FeedbacksItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class ManageFeedback extends Fragment {
RecyclerView recyclerView;

    public ManageFeedback() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_manage_schedule, container, false);
        recyclerView = view.findViewById(R.id.feedbackrecyleList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        StudentLoginServices studentLoginServices=RetrofitClient.getClient().create(StudentLoginServices.class);
        Call<FeedbackResponse> call=studentLoginServices.FeedbackView();
        call.enqueue(new Callback<FeedbackResponse>() {
            @Override
            public void onResponse(Call<FeedbackResponse> call, Response<FeedbackResponse> response) {
               FeedbackResponse response1=response.body();
                if(response1.getSuccess()==1)
                {
                    List<FeedbacksItem>list=response.body().getFeedbacks();
                    Feedback_RecyclerAdapter recyclerAdapter=new Feedback_RecyclerAdapter(getActivity(),list);
                    recyclerView.setAdapter(recyclerAdapter);
                }
                else
                {
                    Toast.makeText(getActivity(), "Failed to get the data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<FeedbackResponse> call, Throwable t) {
                Toast.makeText(getActivity(), "Exception: "+t.toString(), Toast.LENGTH_SHORT).show();

            }
        });
        return view;
    }

}
