package org.project.logic.model;

public class Libro {

    String titolo;
    String autore;
    String categoria;
    String isbn;

    public Libro(String isbn){
        this.isbn = isbn;
    }

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

    public String getIsbn() {
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

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}

