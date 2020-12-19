package com.example.cancer.ascs;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.ArrayList;
import java.util.List;


import static com.example.cancer.ascs.PreferencesUtility.LOGGED_IN;
import static com.example.cancer.ascs.PreferencesUtility.LOGGED_IN_admin;
import static com.example.cancer.ascs.PreferencesUtility.LOGGED_IN_do;
import static com.example.cancer.ascs.PreferencesUtility.LOGGED_IN_student;
import static com.example.cancer.ascs.PreferencesUtility.LOGGED_IN_teacher;

class SaveSharedPreference {

    static SharedPreferences getPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    /*public static void setLoggedIn(Context context, boolean loggedIn) {
        SharedPreferences.Editor editor = getPreferences(context).edit();
        editor.putBoolean(LOGGED_IN_student, loggedIn);
        editor.apply();
    }
    public static void setLoggedStaff(Context context, boolean loggedIn) {
        SharedPreferences.Editor editor = getPreferences(context).edit();
        editor.putBoolean(LOGGED_IN_teacher, loggedIn);
        editor.apply();
    }

    public static void setAdmin(Context context, boolean loggedIn) {
        SharedPreferences.Editor editor = getPreferences(context).edit();
        editor.putBoolean(LOGGED_IN_admin, loggedIn);
        editor.apply();
    }

    public static void setLoggedoperator(Context context, boolean loggedIn) {
        SharedPreferences.Editor editor = getPreferences(context).edit();
        editor.putBoolean(LOGGED_IN_do, loggedIn);
        editor.apply();
    }


    public static boolean getLoggedStatus(Context context) {
        return getPreferences(context).getBoolean(LOGGED_IN_student, false);
    }
    public static boolean getLoggedStatusteacher(Context context) {
        return getPreferences(context).getBoolean(LOGGED_IN_teacher, false);
    }
    public static boolean getLoggedStatusadmin(Context context) {
        return getPreferences(context).getBoolean(LOGGED_IN_admin, false);
    }
    public static boolean getLoggedStatusdo(Context context) {
        return getPreferences(context).getBoolean(LOGGED_IN_do, false);
    }
*/
    public static void setLoggedIn(Context context, String loggedIn) {
        SharedPreferences.Editor editor = getPreferences(context).edit();
        editor.putString(LOGGED_IN, loggedIn);
        editor.apply();
    }
    public static String getLoggedIn(Context context) {
        return getPreferences(context).getString(LOGGED_IN,"No");
    }
    public static void setTeacherData(Context context,String name,String status,String id){
        SharedPreferences.Editor editor=getPreferences(context).edit();
        editor.putString("T_Name",name);
        editor.putString("T_Status",status);
        editor.putString("T_id",id);
        editor.apply();
    }
    public static ArrayList<String> getTeacherData(Context context)
    {
        ArrayList<String> t_data=new ArrayList<String>();
        t_data.add(getPreferences(context).getString("T_Name",""));
        t_data.add(getPreferences(context).getString("T_Status",""));
        t_data.add(getPreferences(context).getString("T_id",""));
        return t_data;
    }
}
