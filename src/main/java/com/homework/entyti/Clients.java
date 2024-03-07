package com.homework.entyti;

public class Clients {

    private Long client_id;

    private String fullName;

    private String phone;

    private String address;

    private String email;

    public Clients() {
    }

    public Clients(String fullName, String phone, String address, String email) {
        this.fullName = fullName;
        this.phone = phone;
        this.address = address;
        this.email = email;
    }

    public Clients(Long client_id, String fullName, String phone, String address, String email) {
        this.client_id = client_id;
        this.fullName = fullName;
        this.phone = phone;
        this.address = address;
        this.email = email;
    }

    public Long getId() {
        return client_id;
    }

    public void setId(Long client_id) {
        this.client_id = client_id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Client " +
                "id=" + client_id +
                ", fullName='" + fullName + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'';
    }
}
