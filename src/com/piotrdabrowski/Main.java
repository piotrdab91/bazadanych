package com.piotrdabrowski;


import java.sql.Connection;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        Communication oracle = new Communication();
        Connection connection = oracle.connectToDatabase();
        EmployeeManager employeeMan = new EmployeeManager();
        employeeMan.addEmployee(connection);
        employeeMan.showAll(connection);


       }
}
