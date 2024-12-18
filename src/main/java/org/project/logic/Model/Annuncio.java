package org.project.logic.Model;


public class Annuncio {

    Utente venditore;
    Libro libro;
    int price;
    int id;

    public Annuncio(int id, int price, Libro libro, Utente venditore) {
        this.id = id;
        this.price = price;
        this.libro = libro;
        this.venditore = venditore;
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

    public int getId() {
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

    public void setId(int id) {
        this.id = id;
    }
}