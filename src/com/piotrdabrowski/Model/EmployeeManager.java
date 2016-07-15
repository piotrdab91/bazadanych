package com.piotrdabrowski.Model;

import com.piotrdabrowski.Model.Communication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by pdabrow on 08.07.16.
 */
public class EmployeeManager {
    private Connection connectionToOracleDatabase;

   public EmployeeManager(){

          connectionToOracleDatabase = Communication.connectToDatabase();
    }

    public void showAll (){
        try{
            Statement statement = connectionToOracleDatabase.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * from PRACOWNIK");
            System.out.println("Pracownicy: ");
            while (resultSet.next()){

                System.out.println(resultSet.getString(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3)+" " +
                                    resultSet.getInt(4)+ " " + resultSet.getString(5)+" "+ resultSet.getString(6));
            }
        }
        catch(Exception e){
            System.out.println("Blad");
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
           System.err.println("Blad wstawienie do pracwonikow");
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
            showAll();
        }
        catch (Exception e)
        {
            System.err.println("chuj");
        }
    }

//    }


}
