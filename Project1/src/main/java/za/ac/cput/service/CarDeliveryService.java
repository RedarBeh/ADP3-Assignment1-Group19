package za.ac.cput.service;

import za.ac.cput.domain.CarDelivery;
import za.ac.cput.service.IService;
import java.util.List;
//import za.ac.cput.school_management.domain.city.Country;
import java.util.Set;

public interface CarDeliveryService extends IService<CarDelivery, String> {

    // List<Car> retrieveAllByCountry(String id);

    public List<CarDelivery> getAll();
    void deleteById(String id);

}