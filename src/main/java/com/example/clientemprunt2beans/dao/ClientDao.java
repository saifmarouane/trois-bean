package com.example.clientemprunt2beans.dao;

import com.example.clientemprunt2beans.bean.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ClientDao extends JpaRepository<Client,Long> {

    int deleteByCin(String cin);
    Client findByCin(String cin);
    List<Client> findAll();

    @Query("SELECT c from Client c where c.point>=7")
    List<Client> findFiable();
}
