package com.example.tp1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public class Foyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long idFoyer;
     String nomFoyer;
     Long capaciteFoyer;
     @JsonIgnore
     @OneToOne(mappedBy = "foyer")
     private Universite universite;

     @OneToMany(mappedBy = "foyer",cascade = CascadeType.ALL)
     private List<Bloc> blocs;

}
