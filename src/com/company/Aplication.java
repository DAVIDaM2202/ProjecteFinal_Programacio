package com.company;

import java.sql.SQLOutput;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aplication {
    Scanner teclado = new Scanner(System.in);
    DAO_Client dao_client = new DAO_Client();
    boolean sortir = true;
    boolean sortir1 = true;
    String nomgeneral= "";
    //En els seguents metodos el primer que ens demanra sera fer un login o un registre, en el cas que el login no sigui correcte no ens deixara entrar
    //Un cop dins veurem les activitats i podrem crear una activitat.
    public void aplication(){
        do {
            System.out.println("Benvingut a la nostra web:\n" +
                    "============================\n" +
                    "1.- Login\n" +
                    "2.- Registre\n" +
                    "Quit.- Sortir del programa\n" +
                    "\n" +
                    "Seleccioni l'acció a realitzar:");
            String  opciotriada= teclado.nextLine();
            switch (opciotriada){
                case "1":login();break;
                case "2":registrarse();break;
                case "Quit":sortir=false;
                    System.out.println("Fins aviat!!!");break;
            }
        }while (sortir);

    }

    public void login(){
        System.out.print("Nom:");
        nomgeneral= teclado.nextLine();
        System.out.print("Contrasenya:");
        String contrasenya= teclado.nextLine();
        boolean resposta =dao_client.Login(nomgeneral,contrasenya);
        if (resposta) {
            veureActivitats();
            queVolsfer();
            sortir = false;

        }    }

    public void registrarse(){

        System.out.print("Nom:");
        nomgeneral= teclado.nextLine();
        System.out.print("Cognom:");
        String cognom= teclado.nextLine();
        System.out.print("Correu:");
        String correu= teclado.nextLine();
        System.out.print("Usuari:");
        String user= teclado.nextLine();
        System.out.print("Contrasenya:");
        String password= teclado.nextLine();
        boolean resposta = dao_client.Registre(nomgeneral,cognom,correu,user,password);
        if (resposta) {
            veureActivitats();
            queVolsfer();
            sortir = false;

        }

    }

    public void veureActivitats(){
        dao_client.veureActivitats();
    }

    public void queVolsfer(){
        do {
            System.out.println("Benvingut: "+nomgeneral+"\n" +
                    "========================================================\n" +
                    "Seleccioni l'acció a realitzar:\n"+
                    "1.- Crear Activitat\n" +
                    "Sortir.- Sortir");
            String  opciotriada= teclado.nextLine();
            switch (opciotriada){
                case "1":crearActivitat();break;
                case "Sortir":sortir1=false;
                    System.out.println("Fins aviat!!!");break;
            }
        }while (sortir1);
    }

    public void crearActivitat(){
        System.out.print("Nom:");
        String nom= teclado.nextLine();
        System.out.print("Desripcio:");
        String descripcio= teclado.nextLine();
        System.out.print("Dia - YYYY-MM-DD:");
        String dia= teclado.nextLine();
        System.out.print("Dia Final - YYYY-MM-DD:");
        String diafinal= teclado.nextLine();
        System.out.print("Localitat:\n");
        dao_client.veureLocalitats();
        String localitat = teclado.nextLine();
        System.out.print("Categoria:\n");
        dao_client.veureCategories();
        String categoria = teclado.nextLine();
        dao_client.crarActivitat(nom,descripcio,dia,diafinal,Integer.parseInt(localitat),Integer.parseInt(categoria),nomgeneral);
        veureActivitats();

    }

}
