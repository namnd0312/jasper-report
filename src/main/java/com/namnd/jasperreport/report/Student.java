package com.namnd.jasperreport.report;

public class Student {


    private Long id;

    private String name;

    private Integer age;

    private String address;

    private String email;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Student(Long id, String name, Integer age, String address, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.email = email;
    }

    public Student() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
