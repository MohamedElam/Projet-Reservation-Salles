package ma.emsi.clientservice.controllers;


import ma.emsi.clientservice.bean.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ma.emsi.clientservice.service.ClientService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/client")
public class ClientController {
    @Autowired
    ClientService cs;

    @GetMapping()
    public List<Client> findAll() {
        return cs.findAll();
    }
    @GetMapping("id/{id}")
    public Optional<Client> findById(@PathVariable Long id) {
        return cs.findById(id);
    }

    @PostMapping("")
    public int save(@RequestBody Client client) {
        return cs.save(client);
    }

    @DeleteMapping()
    public void deleteAll() {
        cs.deleteAll();
    }
    @DeleteMapping("id/{id}")
    public void deleteById(@PathVariable Long id) {
        cs.deleteById(id);
    }



}
