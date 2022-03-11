package com.example.clientemprunt2beans.service;

import com.example.clientemprunt2beans.bean.Client;
import com.example.clientemprunt2beans.dao.ClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public  class ClientService {
    @Autowired
    private ClientDao clientDao;

    public int save(Client client){
        if (findByCin(client.getCin()) != null) {
            return -1;
        }
        else{
            clientDao.save(client);
            return 1;
        }
    }
    @Transactional
    public int deleteByCin(String cin) {
        return clientDao.deleteByCin(cin);
    }

    public Client findByCin(String cin) {
        return clientDao.findByCin(cin);
    }

    public List<Client> findAll() {
        return clientDao.findAll();
    }

    public List<Client> findFiable() {
        return clientDao.findFiable();
    }
}