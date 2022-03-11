package com.example.clientemprunt2beans.bean;

import javax.persistence.*;

@Entity
public class Emprunt {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int nombreExemplaire;
    private int retard;
    private String etat;
    private String reference;

    @ManyToOne
    private Livre livre;
    @ManyToOne
    private Client client;

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Emprunt() {
    }

    public Emprunt(int nombreExemplaire, int retard, String etat, String reference) {
        this.nombreExemplaire = nombreExemplaire;
        this.retard = retard;
        this.etat = etat;
        this.reference = reference;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNombreExemplaire() {
        return nombreExemplaire;
    }

    public void setNombreExemplaire(int nombreExemplaire) {
        this.nombreExemplaire = nombreExemplaire;
    }

    public int getRetard() {
        return retard;
    }

    public void setRetard(int retard) {
        this.retard = retard;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}
