package com.example.spring.repository;

import com.example.spring.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface IReservationRepository extends CrudRepository<Reservation,Long> {
    @Query("SELECT r FROM Reservation r WHERE r.anneeUniversitaire = :anneeUniversite " +
            "AND r.chambre.bloc IN (SELECT b FROM Bloc b WHERE b.foyer IN " +
            "(SELECT f FROM Foyer f WHERE f.universite.nomUniversite = :nomUniversite))")
    List<Reservation> findByAnneeUniversitaireEtNomUniversite(@Param("anneeUniversite") Date anneeUniversite,
                                                              @Param("nomUniversite") String nomUniversite);



    Reservation findByEtudiant_CinAndEstValide(long cin, boolean estValide);

}
