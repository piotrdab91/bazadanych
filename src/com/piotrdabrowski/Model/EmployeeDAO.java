package com.piotrdabrowski.Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pdabrow on 08.07.16.
 */
public class EmployeeDAO {
    private Connection connectionToOracleDatabase;


    public EmployeeDAO(Connection conn) {

        connectionToOracleDatabase = conn;
    }

    private Employee convertRowtToEmployee(ResultSet rs) throws Exception {
        Employee employee = new Employee(rs.getLong(1), rs.getString(2), rs.getString(3),
                rs.getString(4), rs.getInt(5), rs.getString(6));

        return employee;
    }

    public static void close(Statement statement, ResultSet resultSet) throws SQLException {
        if (statement != null)
            statement.close();

        if (resultSet != null)
            resultSet.close();
    }

    public List<Employee> getAllEmployees() throws Exception {
        List<Employee> list = new ArrayList<Employee>();
        Statement statement = null;
        ResultSet resultSet = null;
        list.clear();

        try{
            statement = connectionToOracleDatabase.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM PRACOWNIK");

            while (resultSet.next()) {

                Employee tempEmployee = convertRowtToEmployee(resultSet);
                list.add(tempEmployee);
            }

            return list;
        } finally {

            close(statement, resultSet);
        }
    }

    public void addEmployee(long sPESEL, String sIMIE, String sNAZWISKO, int sWYNAGRODZENIE, String sID_SIEDZIBY, String sSTANOWSIKO ){

        try {
            PreparedStatement preStatement = connectionToOracleDatabase.prepareStatement("INSERT INTO PRACOWNIK VALUES (?,?,?,?,?,?)");
            preStatement.setLong(1,sPESEL);
            preStatement.setString(2,sIMIE);
            preStatement.setString(3,sNAZWISKO);
            preStatement.setInt(4,sWYNAGRODZENIE);
            preStatement.setString(5,sID_SIEDZIBY);
            preStatement.setString(6,sSTANOWSIKO);
            preStatement.execute();
       }
       catch (Exception e){

           System.err.println("Blad wstawienie do pracwonikow " + e.getMessage());
       }
    }
    public void deleteEmployee(long peselToDelete){
        try {
            PreparedStatement preparedStatement = connectionToOracleDatabase.prepareStatement("DELETE FROM PRACOWNIK WHERE PESEL=?");
            preparedStatement.setLong(1,peselToDelete);
            preparedStatement.execute();
        }
        catch (Exception e){

            System.err.println("Nie ma takiego inedksu");
        }
    }
    public void updateEmpleoyeeName (long PESEL, String newName) {
        try {
            PreparedStatement preparedStatement = connectionToOracleDatabase.prepareStatement("UPDATE PRACOWNIK SET IMIĘ = ? WHERE PESEL=?");
            preparedStatement.setString(1,newName);
            preparedStatement.setLong(2,PESEL);
            preparedStatement.execute();
            getAllEmployees();
        }
        catch (Exception e)
        {
            System.err.println("chuj");
        }
    }

//    }


}
