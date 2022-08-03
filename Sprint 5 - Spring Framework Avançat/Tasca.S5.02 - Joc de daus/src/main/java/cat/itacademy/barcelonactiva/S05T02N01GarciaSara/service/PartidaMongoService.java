package cat.itacademy.barcelonactiva.S05T02N01GarciaSara.service;


import cat.itacademy.barcelonactiva.S05T02N01GarciaSara.model.PartidaMongo;
import cat.itacademy.barcelonactiva.S05T02N01GarciaSara.model.UsuariMongo;
import cat.itacademy.barcelonactiva.S05T02N01GarciaSara.repository.PartidaMongoRepository;
import cat.itacademy.barcelonactiva.S05T02N01GarciaSara.repository.UsuariMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PartidaMongoService {

    @Autowired
    PartidaMongoRepository partidaRepository;

    @Autowired
    UsuariMongoRepository usuariMongoRepository;

    @Autowired
    MongoOperations mongoOperations;

    //afegeix una partida
    public PartidaMongo addPartida(UsuariMongo usuari) {
        PartidaMongo partida= new PartidaMongo(usuari);
        partidaRepository.save(partida);

        return partida;
    }
    //borra totes les partide d'un usuari
    public void deletePartides(UsuariMongo usuari) {

        partidaRepository.deleteByUsuari(usuari);

    }
    //recull les dades de les partides en un llistat de toString
    public List<String> dadesPartidesUsuaris(List<PartidaMongo> partides){
        List<String> dadesPartidesUsuaris = new ArrayList<String>();
        for (PartidaMongo p:partides ) {
            dadesPartidesUsuaris.add(p.toString());
        }
        return dadesPartidesUsuaris;
    }
    //retorna totes les partides d'un usuari
    public List<PartidaMongo> getPartidesUsuari(UsuariMongo usuari) {
        return partidaRepository.findAllByUsuari(usuari);
    }
    //retorna el llistat d'usuaris ordenats per percentatge d'exit de forma desc
    public List<UsuariMongo> getRanking() {
        updatedRanking();
        Query query = new Query();
        query.with(Sort.by(Sort.Direction.DESC, "percentatgeExit"));
        return mongoOperations.find(query, UsuariMongo.class);
    }
    //fa un update dels percentatges d'exit dels usuaris
    public void updatedRanking() {
        List<UsuariMongo> usuariMongo = usuariMongoRepository.findAll();
        for (int i = 0; i < usuariMongo.size(); i++) {
            UsuariMongo ususari = usuariMongo.get(i);
            double games = partidaRepository.countByUsuari(ususari);
            double wins = partidaRepository.countByWinAndUsuari(true, ususari);
            double avg = (wins / games) * 100;
            ususari.setPercentatgeExit(avg);
            usuariMongoRepository.save(ususari);
        }
    }

}
