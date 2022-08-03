package cat.itacademy.barcelonactiva.S05T02N01GarciaSara.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.*;
import org.springframework.stereotype.Component;

@Data
@Document(collection = "tirades")
public class PartidaMongo {

     @Getter
     @MongoId(targetType = FieldType.OBJECT_ID)
     private String idPartida;

     @Getter @Setter
     private int tirada1;

     @Getter @Setter
     private int tirada2;

     @Getter @Setter
     private boolean win;

     //Relació bidirecional de partides i usuari.
     @Getter @Setter
     @DBRef
     private UsuariMongo usuari;

     public PartidaMongo(){

     }
     public PartidaMongo(UsuariMongo usuari){
         this.usuari= usuari;
         this.tirada1=tirada();
         this.tirada2=tirada();
         this.win=win(tirada1,tirada2);

     }

     public int tirada (){
            int tirada = (int) (Math.random()*6+1);
            return tirada;
     }

     public boolean win (int tirada1, int tirada2){
         boolean win= false;
         int resultat= tirada1+tirada2;
         if(resultat==7){
                win=true;
         }
         return win;
     }
     public String toString() {
         String dades = "IdPartida: " + idPartida + " Tirada 1: " + tirada1  + " Tirada 2: "+ tirada2 +
                 " Win: " + win ;
         return dades;

     }


}
