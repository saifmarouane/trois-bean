package com.example.clientemprunt2beans.rest;

import com.example.clientemprunt2beans.bean.Client;
import com.example.clientemprunt2beans.service.ClientService;
import com.example.clientemprunt2beans.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/Api/v1/client")
@RestController
public class ClientRest {
    @Autowired
    private ClientService clientService;
    @PostMapping("/")
    public int save(@RequestBody Client client) {
        return clientService.save(client);
    }

    @DeleteMapping("/cin/{cin}")
    public int deleteByCin(@PathVariable String cin) {
        return clientService.deleteByCin(cin);
    }
    @GetMapping("/cin/{cin}")
    public Client findByCin(@PathVariable String cin) {
        return clientService.findByCin(cin);
    }
    @GetMapping("/")
    public List<Client> findAll() {
        return clientService.findAll();
    }
    @GetMapping("/find")
    public List<Client> findFiable() {
        return clientService.findFiable();
    }
}
