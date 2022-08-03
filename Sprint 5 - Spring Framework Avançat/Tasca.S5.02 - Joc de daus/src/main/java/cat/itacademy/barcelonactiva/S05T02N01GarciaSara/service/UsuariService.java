package cat.itacademy.barcelonactiva.S05T02N01GarciaSara.service;

import cat.itacademy.barcelonactiva.S05T02N01GarciaSara.model.Usuari;
import cat.itacademy.barcelonactiva.S05T02N01GarciaSara.repository.UsuariRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsuariService {

    @Autowired
    UsuariRepository usuariRepository;

    public List<Usuari> getUsuaris() {
        return (List<Usuari>) usuariRepository.findAll();
    }
    public List<String> dadesUsuaris(List<Usuari> usuaris){
        List<String> dadesUsuaris= new ArrayList<String>();
        for (Usuari u:usuaris) {
            dadesUsuaris.add(u.toString());
        }

        return dadesUsuaris;
    }

    // comprovació de si l'email existeix i assigna anonim a usuari en cas de que el nom sigui null
    public boolean usuariExisteix(Usuari usuari) {
        boolean usuariExisteix= false;
        List<Usuari> allUsuaris = getUsuaris();
        int totalUsuaris = allUsuaris.size();

        for(int i=0;i<totalUsuaris;i++){
            if(usuari.getEmail().equals(allUsuaris.get(i).getEmail())){
                usuariExisteix =true;
            }
        }

    return usuariExisteix;

    }
    //comprovació de que el nom no existeix
    public boolean nomExisteix(Usuari usuari){
        Boolean nomExisteix= false;
        List<Usuari> allUsuaris = getUsuaris();
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

    public Usuari addUsuari(Usuari usuari) {
        usuariRepository.save(usuari);
        return usuari;
    }

    public Usuari getById(Long id) throws Exception {
        Optional<Usuari> optionalUsuari =usuariRepository.findById(id);

        return optionalUsuari.orElseThrow(() -> new Exception("No hi ha cap usuari amb l'id: " + id));
    }

    public Usuari updateUsuari(Usuari usuariTrobat) {
        usuariRepository.save(usuariTrobat);
        return usuariTrobat;
    }

    public void updatePercentatge(){
        for (Usuari u:getUsuaris()) {
            u.setPercentatgeExit(u.percentatgeExit(u.getPartides()));

        }
    }

    public Double getRankingMig() {
        List<Usuari>usuaris= usuariRepository.findAll();
        return percentatgeMigUsuaris(usuaris);
    }

    public Double percentatgeMigUsuaris(List<Usuari> usuaris){
        double sumaDePercentatges=0;
        double totalUsuaris= usuaris.size();
        for (Usuari u: usuaris) {
            sumaDePercentatges+=u.getPercentatgeExit();
        }
        double percentatgeMig=sumaDePercentatges/totalUsuaris;
        return percentatgeMig;
    }

    public String getLoser(List<Usuari> usuaris) {
        updatePercentatge();
        usuaris.sort(Comparator.comparing(Usuari::getPercentatgeExit));

        return usuaris.get(0).toString();
    }

    public String getWinner(List<Usuari> usuaris) {
        updatePercentatge();
        usuaris.sort(Comparator.comparing(Usuari::getPercentatgeExit).reversed());

        return usuaris.get(0).toString();
    }
}
