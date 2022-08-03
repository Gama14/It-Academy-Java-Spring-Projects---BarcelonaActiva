package cat.itacademy.barcelonactiva.S05T02N01GarciaSara.controller;

import cat.itacademy.barcelonactiva.S05T02N01GarciaSara.model.Usuari;
import cat.itacademy.barcelonactiva.S05T02N01GarciaSara.model.UsuariMongo;
import cat.itacademy.barcelonactiva.S05T02N01GarciaSara.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/mongo")
public class UsuariMongoControler {
    @Autowired
    UsuarioMongoService usuariService;

    @Autowired
    PartidaMongoService partidaService;

    //crea un usuari comprovant que l'email i el nom no existeixin --
    @PostMapping("/players")
    public ResponseEntity addUsuari(@RequestBody UsuariMongo usuari) {

        if(!usuariService.usuariExisteix(usuari)&&!usuariService.nomExisteix(usuari)) {
            usuari.setDataRegistre(new Date());
            return ResponseEntity.status(HttpStatus.CREATED).body(usuariService.addUsuari(usuari));
        }else {
            return (ResponseEntity.status(HttpStatus.BAD_REQUEST))
                    .body("Aquest usuari ja existeix");
        }
    }

    //canvia el nom de l'usuari --
    @PutMapping("/players/{id}")
    public ResponseEntity updateUsuari(@RequestBody UsuariMongo usuari, @PathVariable("id") String id) throws Exception {

        if(usuari.getNomUsuari() != null && !usuariService.nomExisteix(usuari)){
          UsuariMongo usuariTrobat =usuariService.getById(id);
            usuariTrobat.setNomUsuari(usuari.getNomUsuari());
            return ResponseEntity.status(HttpStatus.OK).body( usuariService.updateUsuari(usuariTrobat));

        }else{
            return (ResponseEntity.status(HttpStatus.BAD_REQUEST))
                    .body("Aquest nom d'usuari ja existeix");
        }

    }

    //crea una partida --
    @PostMapping("/players/{id}/games")
    public ResponseEntity addPartida (@PathVariable("id") String id) throws Exception {
        UsuariMongo usuari= usuariService.getById(id);
        return ResponseEntity.status(HttpStatus.CREATED).body( partidaService.addPartida(usuari).toString());
    }

    //esborra el llistat de partides--
    @DeleteMapping("/players/{id}/games")
    public ResponseEntity deletePartides (@PathVariable("id") String id) throws Exception {
        UsuariMongo usuari= usuariService.getById(id);

        partidaService.deletePartides(usuari);

        return  ResponseEntity.status(HttpStatus.OK).body("Les partides han estat eliminades");
    }

    //Retorna el llistat de usuaris --
    @GetMapping ("/players")
    public  ResponseEntity getUsuaris(){

        partidaService.updatedRanking();
        return (ResponseEntity.status(HttpStatus.OK)).body(usuariService.dadesUsuaris(usuariService.getUsuaris()));
    }

    //retorna el llistat de partides d'un usuari --
    @GetMapping ("/players/{id}/games")
    public  ResponseEntity getPartidesUsuari(@PathVariable("id") String id) throws Exception {
        UsuariMongo usuari= usuariService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(partidaService.dadesPartidesUsuaris(partidaService.getPartidesUsuari(usuari)));
    }

    //retorna el percentatge mig d'exit de tots els usuaris--
    @GetMapping ("/players/ranking")
    public  ResponseEntity getRankingMig() {
        partidaService.updatedRanking();
        return  ResponseEntity.status(HttpStatus.OK).body
                ("El percentatge mig d'exits de tots els jugadors es del " +
                        usuariService.percentatgeMigUsuaris(partidaService.getRanking()) +" %");
    }

    //retorna les dades de l'usuari amb pitjor percentatge d'exit--
    @GetMapping ("/players/ranking/loser")
    public  ResponseEntity getLoser () {
        partidaService.updatedRanking();
        return  ResponseEntity.status(HttpStatus.OK).body(usuariService.getLoser());
    }

    //retorna les dades de l'usuari amb millor percentatge d'exit--
    @GetMapping ("/players/ranking/winner")
    public  ResponseEntity getWinner () {
        partidaService.updatedRanking();
        return  ResponseEntity.status(HttpStatus.OK).body(usuariService.getWinner());
    }
}
