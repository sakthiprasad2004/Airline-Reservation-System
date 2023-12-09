package com.example.flyhigh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseHandler extends Configs{
    private static final String DB_URL="jdbc:mysql://localhost:3306/flight_db";
    private static final String DB_USER="root";
    private static final String DB_PASSWORD="#Sakthi30";
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException
    {
                                                                                                //using configs
        Class.forName("com.mysql.cj.jdbc.Driver"); //"C:\Users\91638\Downloads\mysql-connector-j-8.2.0 (2)"             //driver manager clas
        dbConnection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/flight_db","root","#Sakthi30");
        return dbConnection;
    }


    public void userData(User user)                 //method that will add data to table "booking" using configs
    {
        String insert = "INSERT " + Const.flight + "(" + Const.first_name+ "," + Const.middle_name +
                "," + Const.last_name + "," + Const.char_passport + "," + Const.num_passport +
                "," + Const.email_address + ")" + "VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);        //prepared statement, parametrized operator
            prSt.setString(1, user.getFirstName());                        //set data to table
            prSt.setString(2, user.getMiddleName());
            prSt.setString(3, user.getLastName());
            prSt.setString(4, user.getCharPass());
            prSt.setString(5, user.getNumPass());
            prSt.setString(6, user.getEmailAddress());
            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
