package org.project.logic.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CliUtente {
    boolean quit;
    BufferedReader br;

    public CliUtente() {
        quit = false;
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public boolean mainMenu() throws IOException {

        while(!quit) {
            Printer.printMsgln("Menu Utente");
            Printer.printMsgln("\t1) Compra libro");
            Printer.printMsgln("\t2) Vendi Libro");
            Printer.printMsgln("\t3) Profilo");
            Printer.printMsgln("\t4) Log-out");
            Printer.printMsgln("\t5) Esci");
            Printer.printMsg(": ");

            String action = br.readLine();

            switch(action) {
                case "1":
                    compraLibro();
                    break;
                case "2":
                    vendiLibro();
                    break;
                case "3":
                    profilo();
                    break;
                case "4":
                    return false;
                case "5":
                    return true;
                default:
                    break;
            }
        }
        return false;
    }


    public void compraLibro() throws IOException {

        String titoloLibro = "";
        String categoria = "";
        String condizioni = "";
        int[] rangePrezzi = {0, 100};


        while(!quit) {
            Printer.printMsgln("Compra Libro");
            Printer.printMsgln("\t1) Inserisci titolo libro [" + titoloLibro + "]");
            Printer.printMsgln("\t2) Seleziona categoria [" + categoria + "]");
            Printer.printMsgln("\t3) Seleziona condizioni libro [" + condizioni+ "]");
            Printer.printMsgln("\t4) Seleziona range prezzo " + "[" + rangePrezzi[0] + ", " + rangePrezzi[1] + "]");
            Printer.printMsgln("\t5) Cerca");
            Printer.printMsgln("\t6) Indietro");
            Printer.printMsg(": ");

            String action = br.readLine();

            switch(action) {
                case "1":
                    Printer.printMsgln("Inserisci titolo");
                    Printer.printMsg("\t: ");
                    titoloLibro = br.readLine();
                    break;
                case "2":
                    Printer.printMsgln("Seleziona categoria [0: Ingegneria, 1: Medicina, 2: Economia, 3: Lettere, 4: Matematica]");
                    Printer.printMsg("\t: ");
                    int s = Integer.parseInt(br.readLine());
                    categoria = switch (s){
                        case 0 -> "Ingegneria";
                        case 1 -> "Medicina";
                        case 2 -> "Economia";
                        case 3 -> "Lettere";
                        case 4 -> "Matematica";
                        default -> null;
                    };
                    break;
                case "3":
                    Printer.printMsgln("Seleziona condizioni [0: Come nuovo, 1: Ottimo, 2: Smart]");
                    Printer.printMsg("\t: ");
                    int s1 = Integer.parseInt(br.readLine());
                    condizioni = switch (s1){
                        case 0 -> "Come nuovo";
                        case 1 -> "Ottimo";
                        case 2 -> "Smart";
                        default -> null;
                    };
                    break;
                case "4":
                    Printer.printMsgln("Inserisci prezzo minimo");
                    Printer.printMsg("\t: ");
                    int prezzoMinimo = Integer.parseInt(br.readLine());
                    rangePrezzi[0] = prezzoMinimo;
                    Printer.printMsgln("Inserisci prezzo massimo");
                    Printer.printMsg("\t: ");
                    int prezzoMassimo = Integer.parseInt(br.readLine());
                    rangePrezzi[1] = prezzoMassimo;
                    break;
                case "5":
                    Printer.printMsgln("Cerca");
                    // TODO chiama CompraLibroController()
                    break;
                case "6":
                    return;
                default:
                    break;
            }
        }
    }


    public void vendiLibro(){
        System.out.println("Vendi Libro");
    }

    public void profilo(){
        System.out.println("Profilo");
    }
}
