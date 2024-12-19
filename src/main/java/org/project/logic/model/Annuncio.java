package org.project.logic.model;


public class Annuncio {

    Utente venditore;
    Libro libro;
    int price;
    String id;

    public Annuncio(String id, int price, Libro libro, Utente venditore) {
        this.id = id;
        this.price = price;
        this.libro = libro;
        this.venditore = venditore;
    }

    public Annuncio(String id) {
        this.id = id;
    }

    public Utente getVenditore() {
        return venditore;
    }

    public Libro getLibro() {
        return libro;
    }

    public int getPrice() {
        return price;
    }

    public String getId() {
        return id;
    }

    public void setVenditore(Utente venditore) {
        this.venditore = venditore;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setId(String id) {
        this.id = id;
    }
}
