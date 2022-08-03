package cat.itacademy.barcelonactiva.S05T02N01GarciaSara.repository;

import cat.itacademy.barcelonactiva.S05T02N01GarciaSara.model.UsuariMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UsuariMongoRepository extends MongoRepository<UsuariMongo,String> {
    Optional<UsuariMongo> findById(String id);
    UsuariMongo findTopByOrderByPercentatgeExitDesc();
    UsuariMongo findTopByOrderByPercentatgeExitAsc();

}
