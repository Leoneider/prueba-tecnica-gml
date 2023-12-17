package com.alianza.test.Entity;

import jakarta.persistence.*;

import java.util.Arrays;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String sharedKey;

    private String businessId;

    @Column(nullable = false, length = 50)
    private String name;
    @Column(nullable = false, length = 50)
    private String email;
    @Column(nullable = false, length = 50)
    private String phone;
    @Column(nullable = false, length = 50)
    private String startDate;
    @Column(nullable = false, length = 50)
    private String endDate;


    public Client(String sharedKey, String businessId, String name, String email, String phone, String startDate, String endDate) {
        this.sharedKey = sharedKey;
        this.businessId = businessId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Client() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getSharedKey() {
        return sharedKey;
    }

    public void setSharedKey(String name) {
        String[] words = name.split(" ");
        if (words.length == 2) {
            String initial = String.valueOf(words[0].charAt(0));
            String second = words[1];
            this.sharedKey = initial + second;
        } else {
            this.sharedKey = name;
        }
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String name) {
        this.businessId = name;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}
