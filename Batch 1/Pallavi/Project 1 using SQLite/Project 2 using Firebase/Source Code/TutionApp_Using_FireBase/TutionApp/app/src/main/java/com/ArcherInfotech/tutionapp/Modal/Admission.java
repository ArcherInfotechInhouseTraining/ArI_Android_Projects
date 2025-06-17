package com.ArcherInfotech.tutionapp.Model;

public class Admission {
    private String userId;
    private String name;
    private String email;
    private String phone;
    private String courseLevel;
    private String birthDate;

    public Admission() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public Admission(String userId, String name, String email, String phone, String courseLevel, String birthDate) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.courseLevel = courseLevel;
        this.birthDate = birthDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getCourseLevel() {
        return courseLevel;
    }

    public void setCourseLevel(String courseLevel) {
        this.courseLevel = courseLevel;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
