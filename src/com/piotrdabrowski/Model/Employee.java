package com.piotrdabrowski.Model;

/**
 * Created by pdabrow on 13.09.16.
 */
public class Employee {
    private long personalIdNumber;
    private String headquaterId;
    private String name;
    private String last_name;
    private int salary;
    private String job_title;

    public Employee(long personalIdNumber, String headquaterId, String name, String last_name, int salary, String job_title) {
        this.personalIdNumber = personalIdNumber;
        this.headquaterId = headquaterId;
        this.name = name;
        this.last_name = last_name;
        this.salary = salary;
        this.job_title = job_title;
    }

    public long getPersonalIdNumber() {
        return personalIdNumber;
    }

    public void setPersonalIdNumber(long personalIdNumber) {
        this.personalIdNumber = personalIdNumber;
    }

    public String getHeadquaterId() {
        return headquaterId;
    }

    public void setHeadquaterId(String headquaterId) {
        this.headquaterId = headquaterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }
}
