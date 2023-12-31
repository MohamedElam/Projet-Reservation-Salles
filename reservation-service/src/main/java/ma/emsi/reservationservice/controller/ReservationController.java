package ma.emsi.reservationservice.controller;

import ma.emsi.reservationservice.bean.Reservation;
import ma.emsi.reservationservice.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    private ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public List<Reservation> findAll() {
        return reservationService.findAll();
    }

    @PostMapping
    public Reservation save(@RequestBody Reservation entity) {
        return reservationService.save(entity);
    }

    @GetMapping("id/{id}")
    public Reservation findById(@PathVariable Long id) {
        return reservationService.findById(id).orElse(null);
    }

    @DeleteMapping("id/{id}")
    public void deleteById(@PathVariable Long id) {
        reservationService.deleteById(id);
    }
}
