package org.project.logic.view;

import org.project.logic.bean.AnnuncioBean;
import org.project.logic.control.CompraLibroController;
import org.project.logic.control.LoginController;
import org.project.logic.control.VendiLibroController;
import org.project.logic.model.Annuncio;
import org.project.logic.model.Utente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;


public class CliUtente {
    boolean quit;
    BufferedReader br;
    CompraLibroController cl;
    VendiLibroController vl;
    LoginController lc = LoginController.getInstance();

    public CliUtente() {
        quit = false;
        br = new BufferedReader(new InputStreamReader(System.in));
        cl = new CompraLibroController();
        vl = new VendiLibroController();
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
        String isbn = "";
        int[] rangePrezzi = {0, 100};


        while(!quit) {
            Printer.printMsgln("Cerca Libro");
            Printer.printMsgln("\t1) Inserisci titolo libro [" + titoloLibro + "]");
            Printer.printMsgln("\t2) Seleziona isbn [" + isbn + "]");
            Printer.printMsgln("\t3) Applica filtri (opzionale) [ categoria:" + categoria + ", condizioni: " + condizioni +  ", range prezzo: " + "(" + rangePrezzi[0] + ", " + rangePrezzi[1] + ")"+ "]");
            Printer.printMsgln("\t4) Cerca");
            Printer.printMsgln("\t5) Indietro");
            Printer.printMsg(": ");

            String action = br.readLine();

            switch(action) {
                case "1":
                    Printer.printMsgln("Inserisci titolo libro");
                    Printer.printMsg("\t: ");
                    titoloLibro = br.readLine();
                    break;
                case "2":
                    Printer.printMsgln("Inserisci isbn libro");
                    Printer.printMsg("\t: ");
                    isbn = br.readLine();
                    break;
                case "3":
                    Printer.printMsgln("Seleziona categoria [0: Ingegneria, 1: Medicina, 2: Economia, 3: Lettere, 4: Matematica]");
                    Printer.printMsg("\t: ");
                    int s = Integer.parseInt(br.readLine());
                    categoria = getString(s);

                    Printer.printMsgln("Seleziona condizioni [0: Come nuovo, 1: Ottimo, 2: Smart]");
                    Printer.printMsg("\t: ");
                    int s1 = Integer.parseInt(br.readLine());
                    condizioni = switch (s1){
                        case 0 -> "Come nuovo";
                        case 1 -> "Ottimo";
                        case 2 -> "Smart";
                        default -> null;
                    };

                    Printer.printMsgln("Inserisci prezzo minimo");
                    Printer.printMsg("\t: ");
                    int prezzoMinimo = Integer.parseInt(br.readLine());
                    rangePrezzi[0] = prezzoMinimo;
                    Printer.printMsgln("Inserisci prezzo massimo");
                    Printer.printMsg("\t: ");
                    int prezzoMassimo = Integer.parseInt(br.readLine());
                    rangePrezzi[1] = prezzoMassimo;

                    break;
                case "4":
                    Printer.printMsgln("Cerca");

                    List<Annuncio> res;
                    res = cl.cercaAnnuncio(new AnnuncioBean(titoloLibro, categoria, isbn, condizioni, rangePrezzi));
                    printRicerca(res);

                    if(res.isEmpty()){
                        Printer.printMsgln("Nessun annuncio trovato");
                        return;
                    }
                    int i = scegliAnnuncio(res);

                    visualizzaAnnuncio(res.get(i));

                    break;
                case "5":
                    return;
                default:
                    break;
            }
        }
    }



    public void vendiLibro() throws IOException {

        String titoloLibro = "";
        String autore = "";
        String categoria = "";
        String condizioni = "";
        String isbn = "";
        int prezzo = 0;

        while(!quit) {
            Printer.printMsgln("Vendi Libro");
            Printer.printMsgln("\t1) Inserisci titolo libro [" + titoloLibro + "]");
            Printer.printMsgln("\t2) Seleziona autore del libro [" + autore + "]");
            Printer.printMsgln("\t3) Seleziona ISBN del libro [" + isbn + "]");
            Printer.printMsgln("\t4) Seleziona categoria [" + categoria + "]");
            Printer.printMsgln("\t5) Seleziona condizioni libro [" + condizioni + "]");
            Printer.printMsgln("\t6) Seleziona prezzo " + "[" + prezzo + "€]");
            Printer.printMsgln("\t7) Crea annuncio");
            Printer.printMsgln("\t8) Indietro");
            Printer.printMsg(": ");

            String action = br.readLine();

            switch(action) {
                case "1":
                    Printer.printMsgln("Inserisci titolo del libro da vendere");
                    Printer.printMsg("\t: ");
                    titoloLibro = br.readLine();
                    break;
                case "2":
                    Printer.printMsgln("Inserisci autore del libro da vendere");
                    Printer.printMsg("\t: ");
                    autore = br.readLine();
                    break;
                case "3":
                    Printer.printMsgln("Inserisci isbn del libro da vendere");
                    Printer.printMsg("\t: ");
                    isbn = br.readLine();
                    break;
                case "4":
                    Printer.printMsgln("Seleziona categoria libro [0: Ingegneria, 1: Medicina, 2: Economia, 3: Lettere, 4: Matematica]");
                    Printer.printMsg("\t: ");
                    int s = Integer.parseInt(br.readLine());
                    categoria = getString(s);
                    break;
                case "5":
                    Printer.printMsgln("Seleziona condizioni libro [0: Come nuovo, 1: Ottimo, 2: Smart]");
                    Printer.printMsg("\t: ");
                    int s1 = Integer.parseInt(br.readLine());
                    condizioni = switch (s1){
                        case 0 -> "Come nuovo";
                        case 1 -> "Ottimo";
                        case 2 -> "Smart";
                        default -> null;
                    };
                    break;
                case "6":
                    Printer.printMsgln("Inserisci prezzo libro");
                    Printer.printMsg("\t: ");
                    prezzo = Integer.parseInt(br.readLine());
                    break;
                case "7":
                    vl.creaAnnuncio(new AnnuncioBean(titoloLibro, autore, isbn, categoria, condizioni, prezzo));
                    break;
                case "8":
                    return;
                default:
                    break;
            }
        }
    }

    private String getString(int s) {
        String categoria;
        categoria = switch (s){
            case 0 -> "Ingegneria";
            case 1 -> "Medicina";
            case 2 -> "Economia";
            case 3 -> "Lettere";
            case 4 -> "Matematica";
            default -> null;
        };
        return categoria;
    }

    public void profilo(){
        System.out.println("Profilo");
    }

    public void printRicerca(List<Annuncio> l){
        int i = 0;
        for(Annuncio a : l){
            Printer.printMsg(i + ") ");
            Printer.printMsgln("Titolo: " + a.getLibro().getTitolo() + " Autore: " + a.getLibro().getAutore() + " Categoria: " + a.getLibro().getCategoria() + " Prezzo: " + a.getPrice() + "€" );
            i++;
        }
    }

    // nel controller?
    public int scegliAnnuncio(List<Annuncio> l) throws IOException {

        while(true){
            Printer.printMsgln("Seleziona il numero dell'annuncio");
            Printer.printMsg("\t: ");
            int s = Integer.parseInt(br.readLine());
            if(s >= 0 && s < l.size()){
                return s;
            }
            Printer.printMsgln("Numero non valido");
        }
    }

    public void visualizzaAnnuncio(Annuncio a) throws IOException {

        Utente compratore = (Utente) lc.getCurrentUser();

        while(!quit) {
            Printer.printMsgln("Annuncio");
            Printer.printMsgln("\t1) Visualizza informazioni annuncio");
            Printer.printMsgln("\t2) Compra libro");
            Printer.printMsgln("\t3) Contatta venditore");
            Printer.printMsgln("\t4) Indietro");
            Printer.printMsg(": ");

            String action = br.readLine();

            switch(action) {
                case "1":
                    Printer.printMsg("Titolo libro: " + a.getLibro().getTitolo());
                    Printer.printMsg("Autore libro: " + a.getLibro().getAutore());
                    Printer.printMsg("ISBN libro: " + a.getLibro().getIsbn());
                    Printer.printMsg("Categoria libro: " + a.getLibro().getCategoria());
                    Printer.printMsg("Condizioni libro: " + a.getLibro().getCondizioni());
                    Printer.printMsg("Prezzo libro: " + a.getPrice());
                    Printer.printMsgln("Venditore: " + compratore.getEmail());
                    break;
                case "2":

                    boolean b = cl.compraLibro(a, compratore);

                    if(b){
                        Printer.printMsgln("Andato a buon fine");
                    }else{
                        Printer.printMsgln("Errore");
                    }

                    break;
                case "3":
                    profilo();
                    break;
                case "4":
                    return;
                default:
                    break;
            }
        }
    }



}


