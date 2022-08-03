package cat.itacademy.barcelonactiva.garcia.sara.s05.t01.n01.DTO;

import javax.persistence.*;
import java.util.*;
import java.util.List;


public class SucursalDTO {

   
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomSucursal;
    private String paisSucursal;
    private String tipusSucursal;
    String a[]
            = new String[] { "alemanya", "austria", "belgica", "bulgaria","xipre", "croacia","dinamarca","eslovenia",
            "espanya", "estonia","finlandia", "frança", "grecia", "hungria","irlanda","italia", "letonia", "lituania",
            "luxebmurg", "malta","paisos baixos","polonia","portugal", "republica txeca", "republica eslovaca", "rumania", "suecia" };
    List<String> UE = Arrays.asList(a);

    public SucursalDTO (){

    }
    public SucursalDTO(String nom, String pais){
        nomSucursal=nom;
        paisSucursal=pais;
        tipusSucursal=comprovacioUE(pais);
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
        this.tipusSucursal = tipusSucursal;}

    //metode que retorna un string indicant si els paisos estan dins o fora la UE
    public String comprovacioUE (String pais){
        tipusSucursal = "foraUE";
        int size = UE.size();
        for (int i =0; i<size;i++){
            if(pais.equalsIgnoreCase(UE.get(i))){
                tipusSucursal="dinsUE";
            }
        }
    return tipusSucursal;
    }


}
