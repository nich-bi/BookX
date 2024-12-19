package org.project.logic.model;

public class Libro {

    String titolo;
    String autore;
    String categoria;
    int ISBN;

    public Libro(String categoria, String autore, String titolo) {
        this.categoria = categoria;
        this.autore = autore;
        this.titolo = titolo;
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

    public int getISBN() {
        return ISBN;
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

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }
}
