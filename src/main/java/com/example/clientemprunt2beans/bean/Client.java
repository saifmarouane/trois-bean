package com.example.clientemprunt2beans.bean;

import javax.persistence.*;
import java.util.List;

@Entity
public class Client {
     @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cin;
    private int point;
    @OneToMany
    private List<Emprunt> emprunts;


    public Client() {
    }

    public Client(String cin, int point) {
        this.cin = cin;
        this.point = point;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
