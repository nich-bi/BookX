package org.project.logic.model;

public class Ordine {

    Annuncio annuncio;
    User compratore;

    public Ordine(Annuncio annuncio, User compratore) {
        this.annuncio = annuncio;
        this.compratore = compratore;
    }

    public Ordine(String s) {
    }

    public Ordine() {

    }

    public Annuncio getAnnuncio() {
        return annuncio;
    }

    public User getCompratore() {
        return compratore;
    }

    public void setAnnuncio(Annuncio annuncio) {
        this.annuncio = annuncio;
    }

    public void setCompratore(User compratore) {
        this.compratore = compratore;
    }

    public String getId() {
        return compratore.getEmail();
    }
}
