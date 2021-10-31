package com.ucas.android.parsejson.model;

public class Contact {
    String mobile;
    String homee;

    public Contact(String mobile, String phone) {
        this.mobile = mobile;
        this.homee = phone;
    }

    public Contact() {
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }


    public String getHomee() {
        return homee;
    }

    public void setHomee(String homee) {
        this.homee = homee;
    }


    @Override
    public String toString() {
        return "Contact{" +
                "mobile='" + mobile + '\'' +
                ", homee='" + homee + '\'' +
                '}';
    }
}
