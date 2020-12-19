package com.example.cancer.ascs;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cancer.ascs.ModelClasses.DataOperator.RoomResponse;
import com.example.cancer.ascs.ModelClasses.DataOperator.ScheduleResponse;
import com.example.cancer.ascs.ModelClasses.DataOperator.SubjectResponse;
import com.example.cancer.ascs.ModelClasses.TeacherNameResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UploadSchedule extends Fragment {
Spinner Tspinner,Rspinner,Subspinner,Dayspinner,semspinner;
RadioGroup shift,section,degree,dept;
EditText time;
TextView date;
    String pattern2="^[0-9]$";
Button submit;
String TName,RName,SubName,sDate,sTime;
    String shifted, sections, day, degrees, department, semester;
    StudentLoginServices studentLoginService;
    String pattern= "([0-9]{4})-([0-9]{2})-([0-9]{2})";
    String negpat="-[0-9]*";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view= inflater.inflate(R.layout.fragment_upload_schedule, container, false);
        studentLoginService=RetrofitClient.getClient().create(StudentLoginServices.class);
        Tspinner=(Spinner)view.findViewById(R.id.spn_teacher);
        Rspinner=(Spinner)view.findViewById(R.id.spn_room);
        Subspinner=(Spinner)view.findViewById(R.id.spn_subjects);
        Dayspinner=view.findViewById(R.id.spn_Day);
        semspinner=view.findViewById(R.id.spn_Semester);
        shift=view.findViewById(R.id.radioGroupShift);
        section=view.findViewById(R.id.radioGroupSection);
        degree=view.findViewById(R.id.radioGroupDegree);
        dept=view.findViewById(R.id.radioGroupDepartment);
        time=view.findViewById(R.id.ettimer);
        date=view.findViewById(R.id.etdate);
        submit=view.findViewById(R.id.btn_timetable);
        showTeacherName();
        showRoom();
        showSubject();
        section.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected

                switch(checkedId) {
                    case R.id.radiobtnSectionA:
                        sections = "A";
                        break;
                    case R.id.radiobtnSectionB:
                        sections = "B";
                        break;
                    case R.id.radiobtnSectionC:
                        sections = "C";
                        break;
                }
            }
        });
        degree.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected

                switch(checkedId) {
                    case R.id.radiobtnDegreeBS:
                        degrees = "BS";
                        break;
                    case R.id.radiobtnDegreeMSc:
                        degrees = "MSc";
                        break;
                }
            }
        });
        shift.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected

                switch(checkedId) {
                    case R.id.radiobtnShiftMorning:
                        shifted = "Morning";
                        break;
                    case R.id.radiobtnShiftEvening:
                        shifted = "Evening";
                        break;
                }
            }
        });
        dept.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected

                switch(checkedId) {
                    case R.id.radiobtnDepartmentCS:
                        department = "CS";
                        break;
                    case R.id.radiobtnDepartmentIT:
                        department = "IT";
                        break;
                    case R.id.radiobtnDepartmentSE:
                        department = "SE";
                        break;
                }
            }
        });




        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                day=Dayspinner.getSelectedItem().toString();
                semester=semspinner.getSelectedItem().toString();
                sDate=date.getText().toString();
                sTime=time.getText().toString();
                if(sDate.length()==0 || sDate.matches(negpat)|| sDate.matches(pattern)==false )
                {
                    date.setError("Please Enter Correct Date format");
                }
                else if(sTime.length()==0 || sTime.matches(negpat))
                {
                    time.setError("Please Enter Correct time ");
                }
                else if(shift.getCheckedRadioButtonId()== -1)
                {
                    Toast.makeText(getContext(), "Please Select Shift", Toast.LENGTH_SHORT).show();
                }
                else if(degree.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getContext(), "Please Select Degree", Toast.LENGTH_SHORT).show();
                }
                else if(dept.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getContext(), "Please Select Department", Toast.LENGTH_SHORT).show();
                }
                else if(section.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getContext(), "Please Select Section", Toast.LENGTH_SHORT).show();
                }

                else {
                    UploadData();
                }


            }
        });
        return view;
    }

    private void UploadData() {
        Call<ScheduleResponse>call=studentLoginService.UploadeSchedule(TName,RName,sDate,shifted,day,sections,SubName,degrees,
                department,semester,sTime);
        call.enqueue(new Callback<ScheduleResponse>() {
            @Override
            public void onResponse(Call<ScheduleResponse> call, Response<ScheduleResponse> response) {
                ScheduleResponse response1=response.body();
                if(response1.getMessage().equalsIgnoreCase("success"));
                {
                    Toast.makeText(getActivity(),"Data inserted Successfully", Toast.LENGTH_SHORT).show();
                    date.setText("");
                    time.setText("");
                    shift.clearCheck();
                    section.clearCheck();
                    degree.clearCheck();
                    dept.clearCheck();
                }
            }

            @Override
            public void onFailure(Call<ScheduleResponse> call, Throwable t) {
                //Toast.makeText(getActivity(), "Data Upload failed", Toast.LENGTH_SHORT).show();
                Toast.makeText(getActivity(), "Exception: "+t.toString(), Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void showRoom() {
        Call<RoomResponse>call=studentLoginService.selectRoom();
        call.enqueue(new Callback<RoomResponse>() {
            @Override
            public void onResponse(Call<RoomResponse> call, Response<RoomResponse> response) {
                final RoomResponse Tresponse=response.body();
                //Toast.makeText(getActivity(), "Response: "+Tresponse.getTeacherArray().get(0).getTName(), Toast.LENGTH_SHORT).show();
                List<String> spnTeacherArray = new ArrayList<>();
                //spnTeacherArray.add("");
                for(int i=0;i<Tresponse.getRoom().size();i++)
                {
                    spnTeacherArray.add(Tresponse.getRoom().get(i).getName());
                }
                try
                {
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,
                            spnTeacherArray);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    Rspinner.setAdapter(adapter);
                    Rspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                            RName=Tresponse.getRoom().get(position).getName();

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });

                }
                catch (Exception e)
                {
                    Toast.makeText(getActivity(), "Catch Exception"+e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RoomResponse> call, Throwable t) {
                Toast.makeText(getActivity(), "Exception: "+t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showSubject() {
        Call<SubjectResponse>call=studentLoginService.selectSubject();
        call.enqueue(new Callback<SubjectResponse>() {
            @Override
            public void onResponse(Call<SubjectResponse> call, Response<SubjectResponse> response) {
                final SubjectResponse Tresponse=response.body();
                //Toast.makeText(getActivity(), "Response: "+Tresponse.getTeacherArray().get(0).getTName(), Toast.LENGTH_SHORT).show();
                List<String> spnTeacherArray = new ArrayList<>();
                //spnTeacherArray.add("");
                for(int i=0;i<Tresponse.getSubject().size();i++)
                {
                    spnTeacherArray.add(Tresponse.getSubject().get(i).getName());
                }
                try
                {
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,
                            spnTeacherArray);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    Subspinner.setAdapter(adapter);
                    Subspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                            SubName=Tresponse.getSubject().get(position).getName();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });

                }
                catch (Exception e)
                {
                    Toast.makeText(getActivity(), "Catch Exception"+e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<SubjectResponse> call, Throwable t) {
                Toast.makeText(getActivity(), "Exception: "+t.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }


    private void showTeacherName() {
        TeacherLoginServices teacherLoginServices=RetrofitClient.getClient().create(TeacherLoginServices.class);

        Call<TeacherNameResponse> call=teacherLoginServices.teacherName();
        call.enqueue(new Callback<TeacherNameResponse>() {
            @Override
            public void onResponse(Call<TeacherNameResponse> call, Response<TeacherNameResponse> response) {
                final TeacherNameResponse Tresponse=response.body();
                //Toast.makeText(getActivity(), "Response: "+Tresponse.getTeacherArray().get(0).getTName(), Toast.LENGTH_SHORT).show();
                List<String> spnTeacherArray = new ArrayList<>();
                //spnTeacherArray.add("");
                for(int i=0;i<Tresponse.getTeacherArray().size();i++)
                {
                    spnTeacherArray.add(Tresponse.getTeacherArray().get(i).getTName());
                }
                try
                {
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,
                            spnTeacherArray);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    Tspinner.setAdapter(adapter);
                    Tspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                            TName=Tresponse.getTeacherArray().get(position).getTName();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });

                }
                catch (Exception e)
                {
                    Toast.makeText(getActivity(), "Catch Exception"+e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<TeacherNameResponse> call, Throwable t) {
                Log.d("CheckSum", "onResponse: "+t.toString());
                Toast.makeText(getActivity(), "Exception: "+t.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }


}
