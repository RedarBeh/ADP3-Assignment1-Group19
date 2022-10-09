package za.ac.cput.repository;
/*
    ICarDeliveryRepository.java
    IRepository for the CarDelivery
    Mogammad-Redar Behardien
    10 April 2022
 */

import za.ac.cput.domain.CarDelivery;

import java.util.List;

public interface ICarDeliveryRepository extends IRepository<CarDelivery, String> {
    public List<CarDelivery> getAll();
}
