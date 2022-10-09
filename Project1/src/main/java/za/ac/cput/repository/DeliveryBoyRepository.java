package za.ac.cput.repository;
/*
    DeliveryBoyRepository.java
    Repository for the Car Delivery
    Mogammad-Redar Behardien 216234107
    10 April 2022
 */

import za.ac.cput.domain.DeliveryBoy;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public class DeliveryBoyRepository implements IDeliveryBoyRepository{
    private static DeliveryBoyRepository repository = null;
    private List<DeliveryBoy> deliveries = null;

    public DeliveryBoyRepository() { deliveries = new ArrayList<DeliveryBoy>();}
    ///////////////////// Perform Singleton
    public static DeliveryBoyRepository getRepository() {
        if (repository == null) {
            repository = new DeliveryBoyRepository();
        }
        return repository;
    }


    ///////////////////////////Override Methods


    @Override
    public  DeliveryBoy save(DeliveryBoy deliveryBoy) {
        boolean deliver = deliveries.add(deliveryBoy);
        if (!deliver) {
            return null;
        }
        return deliveryBoy;
    }

    @Override
    public Optional<DeliveryBoy> read(String delivBId) {
        return deliveries.stream()
                .filter(d -> d.getDelivBId().equalsIgnoreCase(delivBId))
                .findFirst();
    }
/*
    @Override
    public DeliveryBoy update(DeliveryBoy deliveryBoy) {
        DeliveryBoy oldDeliveryBoy = read(deliveryBoy.getDelivBId());
        if(oldDeliveryBoy != null){
            deliveries.remove(oldDeliveryBoy);
            deliveries.add(deliveryBoy);
            return deliveryBoy;
        }
        return null;
    }*/

    @Override
    public void delete(DeliveryBoy cd) {
        deliveries.remove(cd);
    }

    @Override
    public List<DeliveryBoy> getAll() {return deliveries;}
}