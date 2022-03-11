package com.example.clientemprunt2beans.rest;

import com.example.clientemprunt2beans.bean.Emprunt;
import com.example.clientemprunt2beans.service.EmpruntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/Api/v1/emprunt")
@RestController
public class EmprentRest {
    @Autowired
    private EmpruntService empruntService;
    @GetMapping("/reference/{reference}")
    public Emprunt findByReference(@PathVariable String reference) {
        return empruntService.findByReference(reference);
    }
    @GetMapping("/")
    public List<Emprunt> findAll() {
        return empruntService.findAll();
    }

    @DeleteMapping("/reference/{reference}")
    public int deleteByReference(@PathVariable String reference) {
        return empruntService.deleteByReference(reference);
    }
    @PostMapping("/")
    public int save(@RequestBody Emprunt emprunt) {
        return empruntService.save(emprunt);
    }
}
