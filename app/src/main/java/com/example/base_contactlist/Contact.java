package com.example.base_contactlist;

import androidx.annotation.NonNull;

public class Contact {

    private String name;
    private String lastName;
    private String email;
    private int phoneNumber;

    public Contact(String _name, String _lastName, String _email, int _phoneNumber) {

        this.name = _name;
        this.lastName = _lastName;
        this.email = _email;
        this.phoneNumber = _phoneNumber;

    }

    @NonNull
    @Override
    public String toString() {
        return "name: " + name + ", " + "lastName: " + lastName + ", "
                + "email: " + email + ", " + "phoneNumber: " + phoneNumber;
    }
}
