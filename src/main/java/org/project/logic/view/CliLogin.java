package org.project.logic.view;

import org.project.logic.bean.LoginBean;
import org.project.logic.control.LoginController;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class CliLogin {
    boolean quit;
    BufferedReader br;
    LoginController lc;

    public CliLogin() {
        quit = false;
        br = new BufferedReader(new InputStreamReader(System.in));
        lc = LoginController.getInstance();
    }

    public void loginMenu() throws IOException {

        String username = "";
        String password = "";

        while(!quit) {

            Printer.printMsgln("BookX Login");
            Printer.printMsgln("\t1) Inserisci Username [" + username + "]");
            Printer.printMsgln("\t2) Inserisci Password [" + password + "]");
            Printer.printMsgln("\t3) Login");
            Printer.printMsgln("\t4) Registrati");
            Printer.printMsgln("\t5) Esci");
            Printer.printMsg(": ");

            String action = br.readLine();

            switch(action) {
                case "1":
                    Printer.printMsgln("Inserisci Username");
                    Printer.printMsg("\t: ");
                    username = br.readLine();
                    break;
                case "2":
                    Printer.printMsgln("Inserisci Password");
                    Printer.printMsg("\t: ");
                    password = br.readLine();
                    break;
                case "3":
                    int val = lc.validateLogin(new LoginBean(username, password));
                    if (val == 1){
                        Printer.printMsgln("Login riuscito: Utente");
                        CliUtente view = new CliUtente();
                        quit = view.mainMenu();
                    }
                    else if (val == 2){
                        Printer.printMsgln("Login riuscito: Fornitore");
                        CliFornitore view = new CliFornitore();
                        quit = view.mainMenu();
                    }
                    else Printer.printMsgln("Username o Password invalido");
                    break;
                case "4":
                    registerMenu();
                    break;
                case "5":
                    quit = true;
                    break;
                default:
                    break;
            }

        }

    }


    void registerMenu() throws IOException {

        String nome = "";
        String cognome = "";
        String email = "";
        String password = "";
        String telefono = "";
        int role = 0;

        while(!quit) {

            Printer.printMsgln("Registrati");
            Printer.printMsgln("\t1) Inserisci Email [" + email + "]");
            Printer.printMsgln("\t2) Inserisci Password [" + password + "]");
            Printer.printMsg("\t3) Seleziona ruolo [");
            Printer.printMsg(getCurrentRole(role));
            Printer.printMsgln("]");
            Printer.printMsgln("\t4) informazioni personali (opzionale)");
            Printer.printMsgln("\t5) Registrati");
            Printer.printMsgln("\t6) Indietro");
            Printer.printMsg(": ");

            String action = br.readLine();

            switch(action) {
                case "1":
                    Printer.printMsgln("Inserisci Email");
                    Printer.printMsg("\t: ");
                    email = br.readLine();
                    break;
                case "2":
                    Printer.printMsgln("Inserisci Password");
                    Printer.printMsg("\t: ");
                    password = br.readLine();
                    break;
                case "3":
                    Printer.printMsgln("Seleziona ruolo [0: Utente, 1: Fornitore]");
                    Printer.printMsg("\t: ");
                    role = Integer.parseInt(br.readLine());
                    if (role != 0 && role != 1) role = 0;
                    break;
                case "4":
                    String[] personalInfo = registerPersonalDataMenu(nome, cognome, telefono);
                    if (Arrays.equals(personalInfo, new String[0])) break;
                    nome = personalInfo[0];
                    cognome = personalInfo[1];
                    telefono = personalInfo[2];
                    break;
                case "5":
                    if (lc.register(new LoginBean(nome, cognome, email, password, telefono, role))) {
                        Printer.printMsgln("Registrazione effettuata");
                        loginMenu();
                    }
                    else Printer.printMsgln("Registrazione fallita");
                    break;
                case "6":
                    return;
                default:
                    break;
            }
        }
    }


    String[] registerPersonalDataMenu(String nome, String cognome, String telefono) throws IOException {

        while(!quit) {

            Printer.printMsgln("Dati personali");
            Printer.printMsgln("\t1) Inserisci nome [" + nome + "]");
            Printer.printMsgln("\t2) Inserisci cognome [" + cognome + "]");
            Printer.printMsgln("\t3) Inserisci numero telefono [" + telefono + "]");
            Printer.printMsgln("\t4) Conferma");
            Printer.printMsgln("\t5) Indietro");
            Printer.printMsg(": ");

            String action = br.readLine();

            switch (action) {
                case "1":
                    Printer.printMsgln("Inserisci nome");
                    Printer.printMsg("\t: ");
                    nome = br.readLine();
                    break;
                case "2":
                    Printer.printMsgln("Inserisci cognome");
                    Printer.printMsg("\t: ");
                    cognome = br.readLine();
                    break;
                case "3":
                    Printer.printMsgln("Inserisci numero telefono");
                    Printer.printMsg("\t: ");
                    telefono = br.readLine();
                    break;
                case "4":
                    return new String[]{nome, cognome, telefono};
                case "5":
                    return new String[0];
                default:
                    break;
            }
        }
        return new String[0];
    }


    String getCurrentRole(int role){
        return switch (role) {
            case 0 -> "Utente";
            case 1 -> "Fornitore";
            default -> "Invalid Role";
        };
    }


}
