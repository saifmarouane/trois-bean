package com.example.clientemprunt2beans.dao;

import com.example.clientemprunt2beans.bean.Emprunt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmpruntDao extends JpaRepository<Emprunt,Long> {
    Emprunt findByReference(String reference);
    List<Emprunt> findAll();
    int deleteByReference(String reference);
}
