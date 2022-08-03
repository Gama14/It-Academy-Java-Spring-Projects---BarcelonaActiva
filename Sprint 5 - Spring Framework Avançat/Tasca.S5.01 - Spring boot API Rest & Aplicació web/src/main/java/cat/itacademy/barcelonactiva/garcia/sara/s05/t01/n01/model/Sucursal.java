package cat.itacademy.barcelonactiva.garcia.sara.s05.t01.n01.model;

import javax.persistence.*;

@Entity
@Table(name = "sucursal")
public class Sucursal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;

    @Column (name = "nom_sucursal")
    private String nomSucursal;

    @Column (name = "pais_sucursal")
    private String paisSucursal;
    @Column (name = "tipus_sucursal")
    private String tipusSucursal;

    public Sucursal (){

    }
    public Sucursal(String nom, String pais,String tipusSucursal ){
        this.nomSucursal=nom;
        this.paisSucursal=pais;
        this.tipusSucursal=tipusSucursal;
    }



    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNomSucursal() {
        return nomSucursal;
    }
    public void setNomSucursal(String nomSucursal) {
        this.nomSucursal = nomSucursal;
    }
    public String getPaisSucursal() {
        return paisSucursal;
    }
    public void setPaisSucursal(String paisSucursal) {
        this.paisSucursal = paisSucursal;
    }
    public String getTipusSucursal() {
        return tipusSucursal;
    }
    public void setTipusSucursal(String tipusSucursal) {
        this.tipusSucursal = tipusSucursal;
    }
}
