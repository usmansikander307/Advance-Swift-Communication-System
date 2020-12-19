package com.example.cancer.ascs;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Admin {
    @SerializedName("aid")
    @Expose
    private String aid;

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("error")
    @Expose
    private boolean error;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("password")
    @Expose
    private String password;


    public Admin() {
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
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Admin(String name) {

        this.name = name;
    }
}


