package cat.itacademy.barcelonactiva.S05T02N01GarciaSara.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table (name = "usuari")
@ToString
public class Usuari  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter@Setter
    @Column (name = "idUsuari")
    private Long idUsuari;

    @Getter@Setter
    @Column (name = "nomUsuari")
    private String nomUsuari;

    @Getter@Setter
    @Column (name = "email")
    private String email;

    @Getter@Setter
    @Column (name = "dataRegistre")
    private Date dataRegistre;

    @Getter@Setter
    @Column (name = "percentatgeExit")
    private Double percentatgeExit;

    @Getter@Setter
    @OneToMany(mappedBy = "usuari")
    private List<Partida> partides = new ArrayList<Partida>();

    public Usuari(){
    }

    public Usuari(String nomUsuari,String email){
        this.nomUsuari=nomUsuari;
        this.email=email;
        this.dataRegistre= new Date();

        this.partides=null;

    }


    public double percentatgeExit (List<Partida> partides){
        double partidesTotals= partides.size();
        double victories= 0;
        ;

        for(int i=0;i<partidesTotals;i++){
            if(partides.get(i).isWin()){
                victories += 1;
            }
        }

        double percentatge= victories/partidesTotals*100;

        return percentatge;
        }

    public String toString() {
        String dades = "Id: " + idUsuari + " Nom: " + nomUsuari  + " email: "+ email +
                " Data: " + dataRegistre + " Percentatge Exit: " + percentatgeExit + " %" ;
        return dades;

    }
}

