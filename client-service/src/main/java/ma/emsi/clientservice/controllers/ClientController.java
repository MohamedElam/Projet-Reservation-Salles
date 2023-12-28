package ma.emsi.clientservice.controllers;


import ma.emsi.clientservice.bean.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ma.emsi.clientservice.service.ClientService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/clients")
public class ClientController {

    private final ClientService cs;

    public ClientController(ClientService clientService) {
        this.cs = clientService;
    }

    @GetMapping()
    public List<Client> findAll() {
        return cs.findAll();
    }
    @GetMapping("id/{id}")
    public ResponseEntity<Client> findById(@PathVariable Long id) {
        Client client = cs.findById(id);
        if (client != null) {
            return ResponseEntity.ok(client);
        } else {
            return ResponseEntity.notFound().build();
        }
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
