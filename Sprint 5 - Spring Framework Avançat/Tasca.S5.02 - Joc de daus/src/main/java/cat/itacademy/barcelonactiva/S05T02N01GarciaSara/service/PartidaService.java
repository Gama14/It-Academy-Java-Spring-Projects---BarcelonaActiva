package cat.itacademy.barcelonactiva.S05T02N01GarciaSara.service;

import cat.itacademy.barcelonactiva.S05T02N01GarciaSara.model.Partida;
import cat.itacademy.barcelonactiva.S05T02N01GarciaSara.model.Usuari;
import cat.itacademy.barcelonactiva.S05T02N01GarciaSara.repository.PartidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PartidaService {

    @Autowired
    PartidaRepository partidaRepository;


    public Partida addPartida(Usuari usuari) {
        Partida partida= new Partida(usuari);
        partidaRepository.save(partida);

        return partida;
    }

    public void deletePartides(Usuari usuari) {

        partidaRepository.deleteAll(usuari.getPartides());
        //partidaRepository.deleteAll();

    }
    public List<String> dadesPartidesUsuaris(List<Partida> partides){
        List<String> dadesPartidesUsuaris = new ArrayList<String>();
        for (Partida p:partides ) {
            dadesPartidesUsuaris.add(p.toString());

        }

        return dadesPartidesUsuaris;
    }

    public List<Partida> getPartidesUsuari(Usuari usuari) {
        return partidaRepository.findAllByUsuari(usuari);
    }


}
