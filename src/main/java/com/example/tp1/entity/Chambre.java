package com.example.tp1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long idChambre;
     Long numeroChambre;
    @Enumerated(EnumType.STRING)
     TypeChambre typeC;
    @ManyToOne
    Bloc bloc;
    @JsonIgnore
    @OneToMany
    private List<Reservation> reservations=new ArrayList<>();

}
