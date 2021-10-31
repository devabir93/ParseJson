package com.ucas.android.parsejson.model;

public class Address {
    private String street;
    private String city;
    public Address(){

    }
    public Address(String street,String city){
        this.city = city;
        this.street = street;
    }
    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }
    @Override
    public String toString(){
        return street+","+city;
    }
}