package com.example.clientemprunt2beans.bean;

import javax.persistence.*;
import java.util.List;

@Entity
public class Livre {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String isbn;
    private String titre;
    private  double prix;
    private double seuilAlert;//represente le seuil d'alerte emprente
    private double stock;//le nombre d'exemplaire en stock


    //les constructeurs


    public Livre() {
    }

    public Livre(String isbn, String titre, double prix, double seuilAlert, double stock) {
        this.isbn = isbn;
        this.titre = titre;
        this.prix = prix;
        this.seuilAlert = seuilAlert;
        this.stock = stock;
    }

    //geters and seeters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public double getSeuilAlert() {
        return seuilAlert;
    }

    public void setSeuilAlert(double seuilAlert) {
        this.seuilAlert = seuilAlert;
    }

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }

}
