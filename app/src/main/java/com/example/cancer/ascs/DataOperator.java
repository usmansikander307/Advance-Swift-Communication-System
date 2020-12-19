package com.example.cancer.ascs;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataOperator {
    @SerializedName("Doid")
    @Expose
    private String Doid;

    public String getDoid() {
        return Doid;
    }

    public void setDoid(String Doid) {
        this.Doid = Doid;
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


    public DataOperator() {
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


    public DataOperator(String name) {

        this.name = name;
    }
}
