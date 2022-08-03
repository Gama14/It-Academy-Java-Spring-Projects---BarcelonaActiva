package cat.itacademy.barcelonactiva.S05T02N01GarciaSara.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Document(collection = "usuaris")
public class UsuariMongo {

    @Getter@Setter
    @MongoId(targetType = FieldType.OBJECT_ID)
    private String id;

    @Getter@Setter
    private String nomUsuari;

    @Getter@Setter
    private String email;

    @Getter@Setter
    private Date dataRegistre;

    @Getter@Setter
    private Double percentatgeExit;

    @Getter@Setter
    @DBRef
    private List<PartidaMongo> partides ;

    public UsuariMongo(){
    }

    public UsuariMongo( String nomUsuari,String email){
        this.nomUsuari=nomUsuari;
        this.email=email;
        this.dataRegistre= new Date();
        this.partides=new ArrayList<PartidaMongo>();

    }

    public UsuariMongo(UsuariMongo usuari) {
        this.id= String.valueOf(usuari.getId());
        this.nomUsuari=usuari.getNomUsuari();
        this.email=usuari.getEmail();
        this.dataRegistre= usuari.getDataRegistre();
        this.partides=new ArrayList<PartidaMongo>();
    }
 /*
    public double percentatgeExit (List<PartidaMongo> partides){
        double partidesTotals=0;
        double victories= 0;
        double percentatge=0;
        if(partides!=null){
            partidesTotals= partides.size();
            for(int i=0;i<partidesTotals;i++){
                if(partides.get(i).isWin()){
                    victories += 1;
                }
                percentatge=victories/partidesTotals*100;
            }
        }
        return percentatge;
    }*/

    public String toString() {
        String dades = "Id: " + id + " Nom: " + nomUsuari  + " email: "+ email +
                " Data: " + dataRegistre + " Percentatge Exit: " + percentatgeExit + " %" ;
        return dades;
    }




}
