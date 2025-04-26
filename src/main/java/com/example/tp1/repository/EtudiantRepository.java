package com.example.tp1.repository;

import com.example.tp1.entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
    Etudiant findByCin( long cinEtudiant);

}
