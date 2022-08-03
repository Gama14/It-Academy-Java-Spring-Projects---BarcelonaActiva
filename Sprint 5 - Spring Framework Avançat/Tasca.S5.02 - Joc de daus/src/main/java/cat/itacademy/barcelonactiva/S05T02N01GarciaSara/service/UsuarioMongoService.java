package cat.itacademy.barcelonactiva.S05T02N01GarciaSara.service;

import cat.itacademy.barcelonactiva.S05T02N01GarciaSara.model.UsuariMongo;
import cat.itacademy.barcelonactiva.S05T02N01GarciaSara.repository.UsuariMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsuarioMongoService {

    @Autowired
   private UsuariMongoRepository mongoRepository;

    //Retorna llistat usuaris
    public List<UsuariMongo> getUsuaris() {

        return mongoRepository.findAll();
    }
    //Retorna llistat del toString del usuaris
    public List<String> dadesUsuaris(List<UsuariMongo> usuaris){
        List<String> dadesUsuaris= new ArrayList<String>();
        for (UsuariMongo u:usuaris) {
            dadesUsuaris.add(u.toString());

        }

        return dadesUsuaris;
    }
    //comprovació de si l'email existeix i assigna anonim a usuari en cas de que el nom sigui null
    public boolean usuariExisteix(UsuariMongo usuari) {
        boolean usuariExisteix= false;
        List<UsuariMongo> allUsuaris = getUsuaris();
        int totalUsuaris = allUsuaris.size();

        for(int i=0;i<totalUsuaris;i++){
            if(usuari.getEmail().equals(allUsuaris.get(i).getEmail())){
                usuariExisteix =true;
            }
        }

        return usuariExisteix;

    }
    //comprovació de que el nom no existeix
    public boolean nomExisteix(UsuariMongo usuari){
        Boolean nomExisteix= false;
        List<UsuariMongo> allUsuaris = getUsuaris();
        int totalUsuaris = allUsuaris.size();

        if(usuari.getNomUsuari()!=null){
            for(int i=0;i<totalUsuaris;i++){
                if(usuari.getNomUsuari().equals(allUsuaris.get(i).getEmail())){
                    nomExisteix =true;
                }
            }
        }else{
            usuari.setNomUsuari("Anónim");
        }
        return nomExisteix;

    }
    //crea un usuari
    public UsuariMongo addUsuari(UsuariMongo usuari) {
        mongoRepository.save(usuari);
        return usuari;
    }
    //comprova que l'usuari existeixi a traves de l'id i si ho fa el retorna
    public UsuariMongo getById(String id) throws Exception {
        Optional<UsuariMongo> optionalUsuari = mongoRepository.findById(id);

        return optionalUsuari.orElseThrow(() -> new Exception("No hi ha cap usuari amb l'id: " + id));
    }
    //fa un update de les dades que venen per parametre
    public UsuariMongo updateUsuari(UsuariMongo usuariTrobat) {
        mongoRepository.save(usuariTrobat);
        return usuariTrobat;
    }
    //calcula el percentatge mig de tots els usuaris i en retorna el valor
    public Double percentatgeMigUsuaris(List<UsuariMongo> usuaris) {
        double sumaDePercentatges = 0;
        double totalUsuaris = usuaris.size();
        for (UsuariMongo u : usuaris) {
            sumaDePercentatges += u.getPercentatgeExit();
        }
        double percentatgeMig = sumaDePercentatges / totalUsuaris;
        return percentatgeMig;
    }
    //retorna l'usuari amb millor percentatge d'exit
    public UsuariMongo getWinner(){
        return mongoRepository.findTopByOrderByPercentatgeExitDesc();
    }
    //retorna l'usuari amb pitjor percentatge d'exit
    public UsuariMongo getLoser(){
        return mongoRepository.findTopByOrderByPercentatgeExitAsc();
    }


}
