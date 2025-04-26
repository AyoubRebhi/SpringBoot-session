package com.example.tp1.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long idEtudiant;
     String nomEt;
     String prenomEt;
     Long cin;
     String ecole;
     Date dateNaissance;
     @ManyToMany(mappedBy = "etudiants")
     private List<Reservation> reservations;
}
