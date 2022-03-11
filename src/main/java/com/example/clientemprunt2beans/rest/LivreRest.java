package com.example.clientemprunt2beans.rest;


import com.example.clientemprunt2beans.bean.Livre;
import com.example.clientemprunt2beans.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/Api/v1/livre")
@RestController
public class LivreRest {
    @Autowired
    private LivreService livreService;
    @GetMapping("/isbn/{isbn}")
    public Livre findByIsbn(@PathVariable String isbn) {
        return livreService.findByIsbn(isbn);
    }
    @DeleteMapping("/isbn/{isbn}")
    public int deleteByIsbn(@PathVariable String isbn) {
        return livreService.deleteByIsbn(isbn);
    }
    @GetMapping("/")
    public List<Livre> findAll() {
        return livreService.findAll();
    }
    @PostMapping("/")
    public int save(@RequestBody Livre livre) {


        return livreService.save(livre);
    }
    @GetMapping("/stockNull")
    public List<Livre> findAllStockNull() {
        return livreService.findAllStockNull();
    }
    @GetMapping("/id/{id}")
    public List<Livre> findbyid(@PathVariable Long id) {
        return livreService.findbyid(id);
    }
    @GetMapping("/seuil")
    public List<Livre> findseuil() {
        return livreService.findseuil();
    }
}
