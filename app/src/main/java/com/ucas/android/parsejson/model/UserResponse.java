package com.ucas.android.parsejson.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserResponse {
    @SerializedName("data")
    @Expose
    List<UserExam> userList;

    public UserResponse() {
    }

    public UserResponse(List<UserExam> userList) {
        this.userList = userList;
    }

    public void setUserList(List<UserExam> userList) {
        this.userList = userList;
    }

    public List<UserExam> getUserList() {
        return userList;
    }
}
