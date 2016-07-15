package com.piotrdabrowski.Model;

import java.sql.*;

public class Communication {

    static public Connection connectToDatabase()
    {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Sterowniki zaladowane");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@ora3.elka.pw.edu.pl:1521:ora3inf","pdabrow2","pdabrow2");
            System.out.println("Polaczenie nawiązane");
            return connection;

        }
        catch(Exception wyjatek)
        {
            System.out.println("Błąd");
        }

        return null;}
}
