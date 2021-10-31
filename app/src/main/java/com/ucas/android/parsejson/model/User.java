package com.ucas.android.parsejson.model;

public class User {
    int id;
    String name;
    String email;
    String gender;
    Contact contact;

    public User() {
    }

    public User(int id, String name, String email, String gender, Contact contact) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.contact = contact;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", contact=" + contact +
                '}';
    }
}
