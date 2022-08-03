package cat.itacademy.barcelonactiva.S05T02N01GarciaSara.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table (name= "partides")
@ToString
public class Partida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    @Column (name ="idPartida")
    private Long idPartida;


    @Getter @Setter
    @Column (name ="tirada1")
    private int tirada1;

    @Getter @Setter
    @Column (name ="tirada2")
    private int tirada2;

    @Getter @Setter
    @Column (name ="win")
    private boolean win;


   //Relació bidirecional de partides i usuari.
    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "idUsuari", nullable = false)
    private Usuari usuari;

    public Partida (){

    }

    public Partida(Usuari usuari){
        this.usuari=usuari;
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
                " Win: " + win + " id: " + usuari.getIdUsuari() ;
        return dades;

    }

}
