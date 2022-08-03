package cat.itacademy.barcelonactiva.S05T02N01GarciaSara.repository;

import cat.itacademy.barcelonactiva.S05T02N01GarciaSara.model.PartidaMongo;
import cat.itacademy.barcelonactiva.S05T02N01GarciaSara.model.UsuariMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PartidaMongoRepository extends MongoRepository<PartidaMongo,String> {
    void deleteByUsuari (UsuariMongo usuari);
    List<PartidaMongo> findAllByUsuari(UsuariMongo usuari);
    double countByUsuari(UsuariMongo ususari);
    double countByWinAndUsuari(boolean win, UsuariMongo usuari);
}
