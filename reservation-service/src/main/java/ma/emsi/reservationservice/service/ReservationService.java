package ma.emsi.reservationservice.service;

import ma.emsi.reservationservice.bean.Reservation;
import ma.emsi.reservationservice.clients.ClientRestClient;
import ma.emsi.reservationservice.clients.SalleRestClient;
import ma.emsi.reservationservice.dao.ReservationDao;
import ma.emsi.reservationservice.model.Client;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    private ReservationDao reservationDao;
    private ClientRestClient clientRestClient;
    private SalleRestClient salleRestClient;

    public ReservationService(ReservationDao reservationDao,
                              ClientRestClient clientRestClient,
                              SalleRestClient salleRestClient) {
        this.reservationDao = reservationDao;
        this.clientRestClient = clientRestClient;
        this.salleRestClient = salleRestClient;
    }

    public List<Reservation> findAll() {
        List<Reservation> reservations = reservationDao.findAll();
        for (Reservation reservation:
             reservations) {
            reservation.setClient(clientRestClient.findClientById(reservation.getClient_id()));
            reservation.setSalle(salleRestClient.findSalleById(reservation.getSalle_id()));
        }
        return reservationDao.findAll();
    }

    public Reservation save(Reservation reservation) {
        return reservationDao.save(reservation);
    }

    public Optional<Reservation> findById(Long aLong) {
        return reservationDao.findById(aLong);
    }

    public void deleteById(Long aLong) {
        reservationDao.deleteById(aLong);
    }

//    private boolean checkConflictReservation(Reservation newReservation) {
//        List<Reservation> existingReservations = findAll();
//
//
//
//    }
}
