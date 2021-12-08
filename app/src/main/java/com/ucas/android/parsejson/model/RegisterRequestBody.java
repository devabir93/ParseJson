package com.ucas.android.parsejson.model;

public class RegisterRequestBody {

    String email;
    String password;


    public RegisterRequestBody() {
    }

    public RegisterRequestBody(String email, String password) {
        this.email = email;
        this.password = password;
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
}
