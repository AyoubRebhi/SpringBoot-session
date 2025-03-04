package com.example.spring.repository;

import com.example.spring.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IReservationRepository extends CrudRepository<Reservation,Long> {
    @Query("SELECT r FROM Reservation r " +
            "JOIN r.chambre c JOIN c.bloc b JOIN b.foyer f JOIN f.universite u " +
            "WHERE u.nomUniversite = :nomUniversite " +
            "AND FUNCTION('YEAR', r.anneeUniversitaire) = FUNCTION('YEAR', :anneeUniversitaire)")
    List<Reservation> findReservationsByAnneeUniversitaireAndNomUniversite(Date anneeUniversitaire, String nomUniversite);

}
