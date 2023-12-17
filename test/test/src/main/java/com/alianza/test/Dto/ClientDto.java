package com.alianza.test.Dto;

public class ClientDto {

        private long id;
        private String name;
        private String email;
        private String phone;
        private String startDate;
        private String endDate;

        public ClientDto(String name, String email, String phone, String startDate, String endDate) {
            this.name = name;
            this.email = email;
            this.phone = phone;
            this.startDate = startDate;
            this.endDate = endDate;
        }

        public ClientDto() {
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
}
