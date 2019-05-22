package com.company;

import java.sql.*;

public class DB_Utils {
    //La connexio a ala BD
    public Connection ConnectDB(){
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/projectefinal","root","");


        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("No s'ha pogut connectar");
            return null;
        }
    }
    //Ens desconnectem de la BD
    public void DB_Disconnect(Connection connection){
        try {
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    //Aquí es on executarem les queris
    public  ResultSet DB_Execute(String query, Connection connection){

        try {
            Statement x = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE,ResultSet.CLOSE_CURSORS_AT_COMMIT);//preparar la query
            if (query.contains("INSERT")|| query.contains("insert")) {
                x.execute(query);
                return null;
            }else {
                ResultSet select = x.executeQuery(query);
                return select;
            }


        } catch (SQLException e) {
            e.printStackTrace();
            return null;

        }
    }
}
