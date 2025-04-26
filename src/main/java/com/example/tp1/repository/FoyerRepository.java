package com.example.tp1.repository;

import com.example.tp1.entity.Foyer;
import com.example.tp1.entity.TypeChambre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoyerRepository extends JpaRepository<Foyer,Long> {
    Foyer findByBlocsNomBlocAndBlocsChambreTypeC(TypeChambre typec, String nom);

}
