package com.example.clientemprunt2beans.service;

import com.example.clientemprunt2beans.bean.Client;
import com.example.clientemprunt2beans.bean.Emprunt;
import com.example.clientemprunt2beans.bean.Livre;
import com.example.clientemprunt2beans.dao.EmpruntDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmpruntService {
    @Autowired
    private EmpruntDao empruntDao;
    @Autowired
    private ClientService clientService;
    @Autowired
    private LivreService livreService;

    public Emprunt findByReference(String reference) {
        return empruntDao.findByReference(reference);
    }

    public List<Emprunt> findAll() {
        return empruntDao.findAll();
    }
    @Transactional
    public int deleteByReference(String reference) {
        return empruntDao.deleteByReference(reference);
    }


    /////
    public int save(Emprunt emprunt){
        if (findByReference(emprunt.getReference()) != null) {
            return -1;
        }
        Livre livre=livreService.findByIsbn(emprunt.getLivre().getIsbn());
        Client client=clientService.findByCin(emprunt.getClient().getCin());
        emprunt.setClient(client);
        emprunt.setLivre(livre);
        if((livre==null)||(client==null)){
            return -2;
        }
        else if(client.getPoint()<7){
            return -4;
        }
        else if(livre.getStock()==0){
            return -3;
        }

        else if(livre.getStock()<emprunt.getNombreExemplaire()){
            return -5;
        }
        else{
            double nv=livre.getStock()-emprunt.getNombreExemplaire();
            livre.setStock(nv);
            emprunt.setEtat("en cours");
            livreService.update(livre);
            empruntDao.save(emprunt);
            return 1;

        }
    }

}


