package cat.itacademy.barcelonactiva.S05T02N01GarciaSara.controller;

import cat.itacademy.barcelonactiva.S05T02N01GarciaSara.model.Usuari;
import cat.itacademy.barcelonactiva.S05T02N01GarciaSara.service.PartidaService;
import cat.itacademy.barcelonactiva.S05T02N01GarciaSara.service.UsuariService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/")
public class UsuariController {

    @Autowired
    UsuariService usuariService;

    @Autowired
    PartidaService partidaService;

    //crea un usuari comprovant que l'email i el nom no existeixin
   @PostMapping("/players")
   public ResponseEntity addUsuari(@RequestBody Usuari usuari) {

        if(!usuariService.usuariExisteix(usuari)&&!usuariService.nomExisteix(usuari)) {
            Usuari nouUsuari = new Usuari(usuari.getNomUsuari(),usuari.getEmail());
           return ResponseEntity.status(HttpStatus.CREATED).body(usuariService.addUsuari(nouUsuari));
       }else {
           return (ResponseEntity.status(HttpStatus.BAD_REQUEST))
                   .body("Aquest usuari ja existeix");
       }
   }

   @PutMapping("/players/{idUsuari}")
   public ResponseEntity updateUsuari(@RequestBody Usuari usuari, @PathVariable(value= "idUsuari") Long idUsuari) throws Exception {
       Usuari usuariTrobat = usuariService.getById(idUsuari);
       if(usuari.getNomUsuari() != null && !usuariService.nomExisteix(usuari)){
           usuariTrobat.setNomUsuari(usuari.getNomUsuari());
           return ResponseEntity.status(HttpStatus.OK).body( usuariService.updateUsuari(usuariTrobat));

       }else{
           return (ResponseEntity.status(HttpStatus.BAD_REQUEST))
                   .body("Aquest nom d'usuari ja existeix");
       }

   }

   @PostMapping("/players/{idUsuari}/games")
   public ResponseEntity addPartida (@PathVariable(value="idUsuari") Long idUsuari) throws Exception {
      Usuari usuari= usuariService.getById(idUsuari);
       partidaService.addPartida(usuari);
       return ResponseEntity.status(HttpStatus.CREATED).body( partidaService.addPartida(usuari).toString());
   }

   @DeleteMapping ("/players/{idUsuari}/games")
   public ResponseEntity deletePartides (@PathVariable("idUsuari") Long idUsuari) throws Exception {
       Usuari usuari= usuariService.getById(idUsuari);
       partidaService.deletePartides(usuari);

       return  ResponseEntity.status(HttpStatus.OK).body("Les partides han estat eliminades");
   }


    @GetMapping ("/players")
    public  ResponseEntity getUsuaris(){
       usuariService.updatePercentatge();
        return (ResponseEntity.status(HttpStatus.OK)).body(usuariService.dadesUsuaris(usuariService.getUsuaris()));
    }

    @GetMapping ("/players/{idUsuari}/games")
    public  ResponseEntity getPartidesUsuari(@PathVariable("idUsuari") Long idUsuari) throws Exception {
        Usuari usuari= usuariService.getById(idUsuari);
        return ResponseEntity.status(HttpStatus.OK).body(partidaService.dadesPartidesUsuaris(partidaService.getPartidesUsuari(usuari)));
    }

    @GetMapping ("/players/ranking")
    public  ResponseEntity getRankingMig() {
        usuariService.getRankingMig();
        return  ResponseEntity.status(HttpStatus.OK).body
                ("El percentatge mig d'exits de tots els jugadors es del " +  usuariService.getRankingMig() +" %");
    }

    @GetMapping ("/players/ranking/loser")
    public  ResponseEntity getLoser () {
        return  ResponseEntity.status(HttpStatus.OK).body(usuariService.getLoser(usuariService.getUsuaris()));
    }

    @GetMapping ("/players/ranking/winner")
    public  ResponseEntity getWinner () {
        return  ResponseEntity.status(HttpStatus.OK).body(usuariService.getWinner(usuariService.getUsuaris()));
    }
}
