package com.piotrdabrowski;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by pdabrow on 08.07.16.
 */
public class EmployeeManager {
//    EmployeeManager(){
//        Connection connection

//    }
    public void showAll (Connection connection){
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * from PRACOWNIK");
            System.out.println("Pracownicy: ");
            while (resultSet.next()){

                System.out.println(resultSet.getString(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3));
            }
        }
        catch(Exception e){
            System.out.println("Blad");
        }
    }
    public void addEmployee(Connection connection){
        long sPESEL= 123_456_789_11L;
        String sIMIE ="TEST";
        String sNAZWISKO = "TESTERSKI";
        int sWYNAGRODZENIE = 6666;
        String sID_SIEDZIBY = "1";
        String sSTANOWSIKO = "TESTER";


        try {
            PreparedStatement preStatement = connection.prepareStatement("INSERT INTO PRACOWNIK VALUES (?,?,?,?,?,?)");
            preStatement.setLong(1,sPESEL);
            preStatement.setString(2,sIMIE);
            preStatement.setString(3,sNAZWISKO);
            preStatement.setInt(4,sWYNAGRODZENIE);
            preStatement.setString(5,sID_SIEDZIBY);
            preStatement.setString(6,sSTANOWSIKO);
            preStatement.execute();
       }
       catch (Exception e){
           System.err.println("Blad wstawienie do pracwonikow");

       }
    }
//    public void deleteEmployee(Connection connection){


//    }


}
