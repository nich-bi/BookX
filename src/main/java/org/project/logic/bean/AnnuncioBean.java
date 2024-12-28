package org.project.logic.bean;

import org.project.logic.model.Utente;

public class AnnuncioBean {

    String titoloLibro;
    String autore;
    String isbn;
    String categoria;
    String condizioni;
    int[] rangePrezzo = new int[2];
    int prezzo;
    Utente venditore;


    public AnnuncioBean(String titoloLibro, String autore, String isbn,  String categoria, String condizioni, int prezzo) {
        this.titoloLibro = titoloLibro;
        this.autore = autore;
        this.isbn = isbn;
        this.categoria = categoria;
        this.condizioni = condizioni;
        this.prezzo = prezzo;
    }

    public AnnuncioBean(String titoloLibro, String categoria, String isbn, String condizioni, int[] rangePrezzi) {
        this.titoloLibro = titoloLibro;
        this.categoria = categoria;
        this.isbn = isbn;
        this.condizioni = condizioni;
        this.rangePrezzo[0] = rangePrezzi[0];
        this.rangePrezzo[1] = rangePrezzi[1];

    }


    public String getTitoloLibro() {
        return titoloLibro;
    }

    public String getAutore() {
        return autore;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getCondizioni() {
        return condizioni;
    }

    public int getPrezzo() {
        return prezzo;
    }

    public void setTitoloLibro(String titoloLibro) {
        this.titoloLibro = titoloLibro;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setCondizioni(String condizioni) {
        this.condizioni = condizioni;
    }

    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }

    public String getIsbn() {
        return isbn;
    }

    public Utente getVenditore() {
        return venditore;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setVenditore(Utente venditore) {
        this.venditore = venditore;
    }

    public int[] getRangePrezzo() {
        return rangePrezzo;
    }

    public void setRangePrezzo(int[] rangePrezzo) {
        this.rangePrezzo = rangePrezzo;
    }
}
