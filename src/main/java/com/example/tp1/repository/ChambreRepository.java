package com.example.tp1.repository;

import com.example.tp1.entity.Chambre;
import com.example.tp1.entity.TypeChambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChambreRepository extends JpaRepository<Chambre, Long> {
    List<Chambre> findByBlocFoyerUniversiteAdresse(String ads);
    Chambre findByReservationsEtudiantsCinAndBlocNomBloc(Long cin, String nomBloc);
    List<Chambre> findByNumeroChambreIn(List<Long> numero);
    List<Chambre> findByBlocIdBlocAndTypeC(Long idBloc, TypeChambre typeC);
    //Bloc ism lrelation mapped by maa b bloc f chambre wIdBloc howa ism attribut
    @Query("SELECT c FROM Chambre c  where c.typeC =:typeC and c.bloc.idBloc=:idBloc")
    public List<Chambre> findByBlocIdBlocAndTypeC(@Param("idBloc") long idBloc, @Param("typeC")TypeChambre typeC) ;

    @Query("SELECT c FROM Chambre c WHERE c.bloc.foyer.universite.nomUniversite = :nomUniversite")
    public List<Chambre> getChambresParNomUniversite(@Param("nomUniversite") String nomUniversite);
    public List<Chambre> findChambreByBlocFoyerUniversiteNomUniversite(@Param("nomUniversite") String nomUniversite);


}
