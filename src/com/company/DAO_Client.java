package com.company;


import java.sql.ResultSet;
import java.sql.SQLException;


public class DAO_Client {
    //Fem el Login
    public boolean Login(String nom, String Contra) {
        DB_Utils db_utils = new DB_Utils();

            try {
                String query = "select * from userdjango where username='"+nom+"' and password = '"+Contra+"'";
                ResultSet select = db_utils.DB_Execute(query, db_utils.ConnectDB());
                select.first();

            if (select.getRow() !=0){
                System.out.println("Loguejat");
                return true;
            }else {
                System.out.println("No estas Registrat");
                return false;
            }

            }catch (SQLException e) {
                e.printStackTrace();
            }
        db_utils.DB_Disconnect(db_utils.ConnectDB());

        return false;
    }

    //Fem el Registre
    public boolean Registre(String nom, String cognom,String correu,String user,String password){
        DB_Utils db_utils = new DB_Utils();
        String query = "select * from userdjango";
        ResultSet select = db_utils.DB_Execute(query, db_utils.ConnectDB());
        try {
        select.last();
        int id = select.getInt("id");
        id +=1;
            String query1= "INSERT INTO `userdjango`(`id`, `username`, `password`) VALUES ("+id+",'"+user+"','"+password+"')";
            db_utils.DB_Execute(query1, db_utils.ConnectDB());
            String query2= "INSERT INTO `persona`(`id`, `userdjango`, `nom`, `cognom`, `correu`) VALUES ("+id+","+id+",'"+nom+"','"+cognom+"','"+correu+"')";
            db_utils.DB_Execute(query2, db_utils.ConnectDB());
            return true;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        db_utils.DB_Disconnect(db_utils.ConnectDB());


        return false;
    }
    //Creem una activitat
    public void crarActivitat(String nom,String descripcio,String dia,String diafinal,Integer localitat,Integer categoria,String nomgeneral){
        DB_Utils db_utils = new DB_Utils();
        String query1 = "select * from activitat";
        ResultSet select = db_utils.DB_Execute(query1, db_utils.ConnectDB());

        try {
            select.last();
            int id = select.getInt("id");
            id +=1;
            String query= "INSERT INTO `activitat`(`id`, `nom`, `descripcio`, `dia`, `diafinal`, `localitat`, `categoria`, `creador`) VALUES ("+id+",'"+nom+"','"+descripcio+"','"+dia+"','"+diafinal+"',"+localitat+","+categoria+",'"+nomgeneral+"')";
            System.out.println(query);
            System.out.println("Creada Correctament");
            db_utils.DB_Execute(query, db_utils.ConnectDB());
        }catch (SQLException e) {
            e.printStackTrace();
        }
        db_utils.DB_Disconnect(db_utils.ConnectDB());
    }
    //Mostrem les Activitats
    public void veureActivitats() {
        DB_Utils db_utils = new DB_Utils();
        String query = "select * from activitat";
        try {
            ResultSet select = db_utils.DB_Execute(query, db_utils.ConnectDB());

            System.out.println("Li mostrem les nostres activitats \n"+
                    "============================"
            );
            while (select.next()) {
                System.out.println(select.getString("nom") + "\n\t" + select.getString("descripcio") + "\n\t" + select.getString("dia")
                        + "\n\t" + select.getString("diafinal"));
                System.out.println("Categoria: "+veureCategoriesEspecifica(select.getInt("categoria")));
                System.out.println("Localitat: "+veureLocalitatEspecifica(select.getInt("localitat")));            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db_utils.DB_Disconnect(db_utils.ConnectDB());
    }
    //Mostrem les meves Activitats
    public void lesMevesActivitats(String nom) {
        DB_Utils db_utils = new DB_Utils();
        String query = "select * from activitat a inner join persona p on a.id = p.id where p.nom= '"+nom+"'";
        try {
            ResultSet select = db_utils.DB_Execute(query, db_utils.ConnectDB());

            System.out.println("Li mostrem les nostres activitats \n"+
                    "============================"
            );

            while (select.next()) {
                System.out.println(select.getString("nom") + "\n\t" + select.getString("descripcio") + "\n\t" + select.getString("dia")
                        + "\n\t" + select.getString("diafinal"));
                System.out.println("Categoria: "+veureCategoriesEspecifica(select.getInt("categoria")));
                System.out.println("Localitat: "+veureLocalitatEspecifica(select.getInt("localitat")));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db_utils.DB_Disconnect(db_utils.ConnectDB());
    }
    //Mostrem les localitats
    public void veureLocalitats() {
        DB_Utils db_utils = new DB_Utils();
        String query = "select * from localitat";
        try {
            ResultSet select = db_utils.DB_Execute(query, db_utils.ConnectDB());

                while (select.next()) {
                System.out.println(""+select.getString("id") + " - " + select.getString("nom") + "");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db_utils.DB_Disconnect(db_utils.ConnectDB());
    }
    //Mostrem les categories
    public void veureCategories() {
        DB_Utils db_utils = new DB_Utils();
        String query = "select * from categoria";
        try {
            ResultSet select = db_utils.DB_Execute(query, db_utils.ConnectDB());

            while (select.next()) {
                System.out.println(""+select.getString("id") + " - " + select.getString("nom") + "");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db_utils.DB_Disconnect(db_utils.ConnectDB());
    }
    //Mostrem la Categoria Especifica
    public String veureCategoriesEspecifica(int id) {
        DB_Utils db_utils = new DB_Utils();
        String query = "select * from categoria where id ="+id;
        try {
            ResultSet select = db_utils.DB_Execute(query, db_utils.ConnectDB());
String nom ="";
            while (select.next()) {
               nom=""+select.getString("nom") + "";
            }
            db_utils.DB_Disconnect(db_utils.ConnectDB());
            return nom;


        } catch (SQLException e) {
            e.printStackTrace();
        }
        db_utils.DB_Disconnect(db_utils.ConnectDB());
        return null;

    }
    //Mostrem la Localitat Especifica
    public String veureLocalitatEspecifica(int id) {
        DB_Utils db_utils = new DB_Utils();
        String query = "select * from localitat where id ="+id;
        try {
            ResultSet select = db_utils.DB_Execute(query, db_utils.ConnectDB());
            String nom ="";
            while (select.next()) {
                nom=""+select.getString("nom") + "";
            }
            db_utils.DB_Disconnect(db_utils.ConnectDB());
            return nom;


        } catch (SQLException e) {
            e.printStackTrace();
        }
        db_utils.DB_Disconnect(db_utils.ConnectDB());
        return null;

    }
}


