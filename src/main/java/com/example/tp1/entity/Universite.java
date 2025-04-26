package com.example.tp1.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public class Universite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long idUniversite;
    @Column(unique = true)
     String nomUniversite;
     String adresse;
    @OneToOne()
    private Foyer foyer;

}
