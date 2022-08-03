package cat.itacademy.barcelonactiva.garcia.sara.s05.t01.n01.controllers;


import cat.itacademy.barcelonactiva.garcia.sara.s05.t01.n01.DTO.SucursalDTO;
import cat.itacademy.barcelonactiva.garcia.sara.s05.t01.n01.model.Sucursal;
import cat.itacademy.barcelonactiva.garcia.sara.s05.t01.n01.services.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/sucursal")
public class SucursalController {

    @Autowired
    private SucursalService sucursalService;

    /*metode per afegir una sucursal a la base de dades. Recollim les dades a traves de la SucursalDTO i a traves del
    service fem el traspas a Sucursal per afegir-ho a la base de dades. En aquest cas utilitcem ResponseEntity perque en cas de que funcioni
    ens retorni les dades que hem creat*/
    @PostMapping("/add")
    public ResponseEntity<?> addSucursal(@RequestBody SucursalDTO sucursalDto){
    Sucursal sucursal = new Sucursal
            (sucursalDto.getNomSucursal(),sucursalDto.getPaisSucursal(),sucursalDto.comprovacioUE(sucursalDto.getPaisSucursal())) ;

    return ResponseEntity.status(HttpStatus.CREATED).body(sucursalService.addSucursal(sucursal));
    }

    //metode per actualitzar les sucursals
    @PutMapping ("/update/{id}")
    public String updateSucursal(@PathVariable Long id,@RequestBody SucursalDTO sucursalDto) throws Exception {
        String missatge ="";
        if(!sucursalService.existsById(id)){
            missatge = "No s'ha trobat cap sucursal amb l'id: "+id;
        }else {
            Sucursal sucursal1 = sucursalService.getSucursal(id);
            if (sucursalDto.getNomSucursal() != null) {
                sucursal1.setNomSucursal(sucursalDto.getNomSucursal());
            } else if (sucursalDto.getPaisSucursal() != null) {
                sucursal1.setPaisSucursal(sucursalDto.getPaisSucursal());
                sucursal1.setTipusSucursal(sucursalDto.comprovacioUE(sucursalDto.getPaisSucursal()));
            }
            sucursalService.updateSucursal(sucursal1);
            missatge="S'ha actualitzat amb exit";
        }
        return missatge;
    }

    //metode per eliminar sucursals
    @DeleteMapping("/delete/{id}")
    public String deleteSucursal (@PathVariable Long id){
    String missatge ="";
        if(!sucursalService.existsById(id)){
         missatge = "No s'ha trobat cap sucursal amb l'id: "+id;
       }else{
            sucursalService.deleteSucursal(id);
          missatge= "La sucursal amb id "+id+" ha estat eliminada amb éxit";
        }
    return missatge;
    }

    //metode que retorna una sucursal
    @GetMapping("/getOne/{id}")
    public Sucursal getSucursal (@PathVariable Long id) throws Exception {
        return sucursalService.getSucursal(id);
    }

    //metode que retorna totes les sucursals
    @GetMapping("/getAll")
    public List<Sucursal> getAllSucursal (){

        return sucursalService.getAllSucursal();
    }
}
