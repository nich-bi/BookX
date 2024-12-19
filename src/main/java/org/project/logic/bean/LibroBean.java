package org.project.logic.bean;

public class LibroBean {

    String titolo;
    String autore;
    String categoria;
    String condizioni;
    int[] rangePrezzi;
    String isbn;


    public LibroBean(String titolo, String categoria, String isbn,  String condizioni, int[] rangePrezzi) {
        this.titolo = titolo;
        this.categoria = categoria;
        this.condizioni = condizioni;
        this.rangePrezzi = rangePrezzi;
        this.isbn = isbn;
    }

    public LibroBean(String titolo, String autore, String categoria, String ISBN) {
        this.titolo = titolo;
        this.autore = autore;
        this.categoria = categoria;
        this.isbn = ISBN;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getAutore() {
        return autore;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getISBN() {
        return isbn;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setISBN(String ISBN) {
        this.isbn = ISBN;
    }
}
