package za.ac.cput.repository;
/*
    CarDeliveryRepository.java
    Repository for the Car Delivery
    Mogammad-Redar Behardien 216234107
    10 April 2022
 */

import za.ac.cput.domain.CarDelivery;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository
public class CarDeliveryRepository implements ICarDeliveryRepository {
    private static CarDeliveryRepository repository = null;
    private List<CarDelivery> deliveries = null;

    public CarDeliveryRepository() { deliveries = new ArrayList<CarDelivery>();}
    ///////////////////// Perform Singleton
    public static CarDeliveryRepository getRepository() {
        if (repository == null) {
            repository = new CarDeliveryRepository();
        }
        return repository;
    }


    ///////////////////////////Override Methods


    @Override
    public  CarDelivery save(CarDelivery carDelivery) {
        boolean deliver = deliveries.add(carDelivery);
        if (!deliver) {
            return null;
        }
        return carDelivery;
    }

    @Override
    public Optional<CarDelivery> read(String carDelivId) {
        return deliveries.stream()
                .filter(d -> d.getCarDelivId().equalsIgnoreCase(carDelivId))
                .findFirst();
        
    }
/*
    @Override
    public CarDelivery update(CarDelivery carDelivery) {
        CarDelivery oldCarDelivery = read(carDelivery.getCarDelivId());
        if(oldCarDelivery != null){
            deliveries.remove(oldCarDelivery);
            deliveries.add(carDelivery);
            return carDelivery;
        }
        return null;
    }
*/
    @Override
    public void delete(CarDelivery id) {
        this.deliveries.remove(id);
    }

    @Override
    public List<CarDelivery> getAll() {return deliveries;}
}