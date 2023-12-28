package ma.emsi.salleservice.controller;

import ma.emsi.salleservice.bean.Salle;
import ma.emsi.salleservice.service.SalleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/salles")
public class SalleController {

    private SalleService salleService;

    public SalleController(SalleService salleService) {
        this.salleService = salleService;
    }

    @GetMapping
    public List<Salle> findAll() {
        return salleService.findAll();
    }

    @GetMapping("id/{id}")
    public Salle findById(@PathVariable Long id) {
        return salleService.findById(id).orElse(null);
    }

    @PostMapping
    public Salle save(@RequestBody Salle entity) {
        return salleService.save(entity);
    }

    @DeleteMapping("id/{id}")
    public void deleteById(@PathVariable Long id) {
        salleService.deleteById(id);
    }
}
