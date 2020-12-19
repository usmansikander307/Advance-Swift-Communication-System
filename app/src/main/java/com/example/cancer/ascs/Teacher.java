package com.example.cancer.ascs;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Teacher {
    @SerializedName("T_id")
    @Expose
    private String tid;

    public String getSid() {
        return tid;
    }

    public void setSid(String sid) {
        this.tid = tid;
    }

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("error")
    @Expose
    private boolean error;

    @SerializedName("T_name")
    @Expose
    private String T_name;

    @SerializedName("T_email")
    @Expose
    private String T_email;

    @SerializedName("T_pass")
    @Expose
    private String T_pass;

    @SerializedName("T_cont")
    @Expose
    private String T_cont;

    public Teacher() {
    }



    public String getMessage() {

        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }



    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getName() {
        return T_name;
    }

    public void setName(String name) {
        this.T_name= T_name;
    }

    public String getEmail() {
        return T_email;
    }

    public void setEmail(String email) {
        this.T_email = T_email;
    }

    public String getPassword() {
        return T_pass;
    }

    public void setPassword(String password) {
        this.T_pass = T_pass;
    }

    public String getContact() { return T_cont; }

    public void setContact(String Contact) {
        this.T_cont = T_cont;
    }

    public Teacher(String name) {

        this.T_name = T_name;
    }
}
