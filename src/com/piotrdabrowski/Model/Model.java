package com.piotrdabrowski.Model;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by pdabrow on 14.09.16.
 */
public class Model {
    static Connection conn;
    private Employee employee;
    private EmployeeDAO employeeDAO;

    public Model() {
        conn = null;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public EmployeeDAO getEmployeeDAO() {
        return employeeDAO;
    }

    public void setEmployeeDAO(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public void connectToDatabase() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Sterowniki zaladowane");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@ora3.elka.pw.edu.pl:1521:ora3inf", "pdabrow2", "pdabrow2");
            System.out.println("Polaczenie nawiązane");
            this.conn = connection;
            employeeDAO = new EmployeeDAO(conn);

        } catch (Exception wyjatek) {
            System.out.println("Błąd");
        }

    }
}

