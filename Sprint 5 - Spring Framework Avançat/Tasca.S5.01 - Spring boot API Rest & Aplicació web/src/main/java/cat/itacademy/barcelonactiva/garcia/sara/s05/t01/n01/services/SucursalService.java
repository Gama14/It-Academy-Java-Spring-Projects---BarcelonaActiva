package cat.itacademy.barcelonactiva.garcia.sara.s05.t01.n01.services;

import cat.itacademy.barcelonactiva.garcia.sara.s05.t01.n01.model.Sucursal;
import cat.itacademy.barcelonactiva.garcia.sara.s05.t01.n01.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class SucursalService {

    @Autowired
    private SucursalRepository sucursalRepository;

    //retornem el JSON que rebem per mostrar el que sha afegit
    public Sucursal addSucursal(Sucursal sucursal){
        sucursalRepository.save(sucursal);
        return sucursal;
    }

    public void updateSucursal(Sucursal sucursal){
        sucursalRepository.save(sucursal);
    }

    public void deleteSucursal (Long id){
        sucursalRepository.deleteById(id);

    }

    //en cas de introduir un id que no existeix saltara l'exception amb el missatge que em indicat
    public Sucursal getSucursal (Long id) throws Exception {
        Optional<Sucursal> optionalSucursal =sucursalRepository.findById(id);
        return optionalSucursal.orElseThrow(() -> new Exception("No hi ha cap sucursal amb l'id: " + id));
    }

    public List<Sucursal> getAllSucursal (){

        return (List<Sucursal>) sucursalRepository.findAll();
    }

    public boolean existsById(Long id){
        return sucursalRepository.existsById(id);
    }


}
