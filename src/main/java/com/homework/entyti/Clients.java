package com.homework.entyti;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Clients {

    private Long client_id;

    private String fullName;

    private String phone;

    private String address;

    private String email;


    public Clients(String fullName, String phone, String address, String email) {
        this.fullName = fullName;
        this.phone = phone;
        this.address = address;
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
