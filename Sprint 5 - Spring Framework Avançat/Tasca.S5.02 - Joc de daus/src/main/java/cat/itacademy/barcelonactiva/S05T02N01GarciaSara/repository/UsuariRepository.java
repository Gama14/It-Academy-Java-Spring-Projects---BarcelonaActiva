package cat.itacademy.barcelonactiva.S05T02N01GarciaSara.repository;

import cat.itacademy.barcelonactiva.S05T02N01GarciaSara.model.Usuari;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuariRepository extends JpaRepository <Usuari,Long> {


}
