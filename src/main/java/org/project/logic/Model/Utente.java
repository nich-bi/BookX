package org.project.logic.Model;

public class Utente extends User{

    String nome;
    String cognome;
    String telefono;

    public Utente(User user) {
        super(user.getEmail());
        this.password = user.getPassword();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
