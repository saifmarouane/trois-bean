package com.example.clientemprunt2beans.service;
import com.example.clientemprunt2beans.bean.Client;
import com.example.clientemprunt2beans.bean.Livre;
import com.example.clientemprunt2beans.dao.ClientDao;
import com.example.clientemprunt2beans.dao.LivreDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LivreService {
    @Autowired
    private LivreDao livreDao;

    public Livre findByIsbn(String isbn) {
        return livreDao.findByIsbn(isbn);
    }
    @Transactional
    public int deleteByIsbn(String isbn) {
        return livreDao.deleteByIsbn(isbn);
    }

    public List<Livre> findAll() {
        return livreDao.findAll();
    }
    //////update
    public void update(Livre livre){
        livreDao.save(livre);
    }

    //////////////save

    public  int save(Livre livre){
        if(livre.getIsbn()==null){
            return -2;
        }
        else if(findByIsbn(livre.getIsbn())!=null){
            return -1;
        }

        else {
            livreDao.save(livre);
            return 1;
        }

    }
    //////////////////////////


    public List<Livre> findAllStockNull() {
        return livreDao.findAllStockNull();
    }

    public List<Livre> findbyid(Long id) {
        return livreDao.findbyid(id);
    }

    public List<Livre> findseuil() {
        return livreDao.findseuil();
    }


}
