package com.ucas.android.parsejson.model;

public class Company {
    private int id;
    private String name;
    private String[] websites;
    private Address address;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setWebsites(String[] websites) {
        this.websites = websites;
    }

    public int getId() {
        return id;
    }

    public Address getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public String[] getWebsites() {
        return websites;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("\n id:" + this.id);
        sb.append("\n name:" + this.name);
        if (this.websites != null) {
            sb.append("\n website: ");
            for (String website : this.websites) {
                sb.append(website + ", ");
            }
        }
        if (this.address != null) {
            sb.append("\n address:" + this.address.toString());
        }
        return sb.toString();
    }

}