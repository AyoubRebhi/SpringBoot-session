package com.example.spring.controller;

import com.example.spring.entity.Reservation;
import com.example.spring.services.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
    @Autowired
    IReservationService reservationService;

    @GetMapping("/getreservations")
    public List<Reservation> getReservations (){
        return reservationService.retrieveAllReservation();
    }

    @PutMapping("/updatereservation")
    public Reservation updateReservation (@RequestBody Reservation reservation){
        return reservationService.updateReservation(reservation);
    }

    @GetMapping("/getreservation/{id}")
    public Reservation getReservation (@PathVariable String id){
        return reservationService.retrieveReservation(id);
    }

    @GetMapping ("/getRbyAnneeAndUniversite")
    public List<Reservation> getReservationsByAnneeUniversitaireAndUniversite(@RequestParam Date anneeUniversite, @RequestParam String nomUniversite){
        return reservationService.getReservationsByAnneeUniversitaireAndUniversite(anneeUniversite, nomUniversite);
    }

    @PostMapping("/ajouter/{idBloc}/{cinEtudiant}")
    public Reservation ajouterReservation( @PathVariable long idBloc, @PathVariable long cinEtudiant) {
        return reservationService.ajouterReservation(idBloc, cinEtudiant);
    }


    @DeleteMapping("/annuler/{cinEtudiant}")
    public Reservation annulerReservation(@PathVariable long cinEtudiant) {
        return reservationService.annulerReservation(cinEtudiant);
    }
}
