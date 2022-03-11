package com.example.clientemprunt2beans.dao;
import com.example.clientemprunt2beans.bean.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivreDao extends JpaRepository<Livre,Long>{
    Livre findByIsbn(String isbn);
    int deleteByIsbn(String isbn);
    List<Livre> findAll();
    List<Livre> findByStockEquals(double a);
    int findByTitreIsNull();
    // List<Livre> findByStockGreaterThanSeuilAlert();
    @Query("SELECT l FROM Livre l where l.stock=0")
    List<Livre> findAllStockNull();
    @Query("select l from Livre l where l.id=:id")
    List<Livre> findbyid(@Param("id") Long id);
    @Query("select l from  Livre l where l.stock<l.seuilAlert")
    List<Livre> findseuil();




}
