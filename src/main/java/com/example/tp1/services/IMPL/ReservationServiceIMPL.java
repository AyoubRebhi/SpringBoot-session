package com.example.tp1.services.IMPL;

import com.example.tp1.entity.*;
import com.example.tp1.repository.ChambreRepository;
import com.example.tp1.repository.EtudiantRepository;
import com.example.tp1.repository.FoyerRepository;
import com.example.tp1.repository.ReservationRepository;
import com.example.tp1.services.interfaces.IreservationService;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReservationServiceIMPL implements IreservationService {
    ReservationRepository reservationRepository;
    ChambreRepository chambreRepository;
    FoyerRepository foyerRepository;
    EtudiantRepository etudiantRepository;

    @Override
    public List<Reservation> retrieveAllReservation() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation updateReservation(Reservation res) {
        return reservationRepository.save(res);
    }

    @Override
    public Reservation retrieveReservation(String idReservation) {
        return reservationRepository.findById(idReservation).orElse(null);
    }

    @Override
    public Reservation ajouterReservation(long idChambre, long cinEtudiant) {
        Chambre chambre = chambreRepository.findById(idChambre).orElse(null);
        Etudiant etudiant = etudiantRepository.findByCin(cinEtudiant);
        String nomBloc = chambre.getBloc().getNomBloc();
        String anneeUniversitaire = String.valueOf(LocalDate.now());
        String idReservation = chambre.getNumeroChambre() + "-" + nomBloc + "-" + anneeUniversitaire;

        Reservation reservation = Reservation.builder()
                .idReservation(idReservation)
                .anneeUniversitaire(LocalDate.now())
                .estValide(true)
                .etudiants(new ArrayList<>())
                .build();
        reservation.getEtudiants().add(etudiant);
        chambre.getReservations().add(reservation);
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation annulerReservation(long cinEtudiant) {
        // 1. Récupérer l'étudiant
        Etudiant etudiant = etudiantRepository.findByCin(cinEtudiant);
        if (etudiant == null) {
            throw new RuntimeException("Étudiant avec le CIN " + cinEtudiant + " introuvable.");
        }

        // 2. Trouver la réservation valide liée à l'étudiant
        List<Reservation> reservations = reservationRepository.findAll();
        for (Reservation reservation : reservations) {
            if (reservation.isEstValide() && reservation.getEtudiants().contains(etudiant)) {
                //  Mettre à jour la réservation et tnahy etudiant
                reservation.setEstValide(false);
                reservation.getEtudiants().remove(etudiant);
                return reservationRepository.save(reservation);
            }
        }

        throw new RuntimeException("Aucune réservation valide trouvée pour l'étudiant avec le CIN " + cinEtudiant);
    }

    @Override
    public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(LocalDate anneeUniversite, String nomUniversite) {
        return reservationRepository.findByAnneeUniversitaireAndNomUniversite(anneeUniversite, nomUniversite);

    }

    @Override
        public List<Chambre> findNonReservedChambres(LocalDate anneUniversitaire) {
            return reservationRepository.findNonReservedChambres(anneUniversitaire);
        }

@Scheduled(cron="*/10 * * * * *")
    public void afficher(){
        LocalDate d =LocalDate.now();
            List <Chambre> ch=findNonReservedChambres(d);
            ch.forEach(c->System.out.println("chambre dispo "+c.getIdChambre()));
}
}
