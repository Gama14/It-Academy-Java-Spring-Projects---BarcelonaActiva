package cat.itacademy.barcelonactiva.S05T02N01GarciaSara.repository;

import cat.itacademy.barcelonactiva.S05T02N01GarciaSara.model.Partida;
import cat.itacademy.barcelonactiva.S05T02N01GarciaSara.model.Usuari;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PartidaRepository extends JpaRepository <Partida,Long> {
    List<Partida> findAllByUsuari(Usuari usuari);
}
