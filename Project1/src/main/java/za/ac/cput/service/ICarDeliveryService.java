package za.ac.cput.service;

import java.util.*;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.CarDelivery;

//import za.ac.cput.school_management.repository.city.CountryRepository;
import za.ac.cput.repository.CarDeliveryRepository;

//import za.ac.cput.school_management.repository.city.impl.CountryRepositoryIMPL;
import za.ac.cput.repository.ICarDeliveryRepository;

import za.ac.cput.service.CarDeliveryService;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service

public class ICarDeliveryService implements CarDeliveryService {

    private static CarDeliveryService carDeliveryService = null;
    private ICarDeliveryRepository icarDeliveryRepository;

    private ICarDeliveryService() {
        this.icarDeliveryRepository = (ICarDeliveryRepository) CarDeliveryRepository.getRepository();
    }

    public static CarDeliveryService getCarDeliveryService() {
        if (carDeliveryService == null)
            carDeliveryService = new ICarDeliveryService();
        return carDeliveryService;
    }

    @Override // change on both sides to lists
    public List<CarDelivery> getAll() {
        return this.icarDeliveryRepository.getAll();
    }

    @Override
    public CarDelivery save(CarDelivery carDelivery) {
        return this.icarDeliveryRepository.save(carDelivery);// (create or save?)
    }

    @Override
    public Optional<CarDelivery> read(String a) {
        return this.icarDeliveryRepository.read(a);
    }
/*
    @Override
    public CarDelivery update(CarDelivery carDelivery) {
        return this.icarDeliveryRepository.update(carDelivery);
    }*/

    @Override
    public void delete(CarDelivery a) {
        this.icarDeliveryRepository.delete(a);
    }
    
    @Override
    public void deleteById(String id){
        Optional<CarDelivery> cd = read(id);
        if(cd.isPresent()) delete(cd.get());
    }

}
