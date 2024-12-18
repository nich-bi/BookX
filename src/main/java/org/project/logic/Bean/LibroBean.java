package org.project.logic.Bean;

public class LibroBean {

    String titolo;
    String autore;
    String categoria;
    String condizioni;
    int[] rangePrezzi;
    int ISBN;


    public LibroBean(String titolo, String categoria, String condizioni, int[] rangePrezzi) {
        this.titolo = titolo;
        this.categoria = categoria;
        this.condizioni = condizioni;
        this.rangePrezzi = rangePrezzi;
    }

    public LibroBean(String titolo, String autore, String categoria, int ISBN) {
        this.titolo = titolo;
        this.autore = autore;
        this.categoria = categoria;
        this.ISBN = ISBN;
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
