package za.ac.cput.repository;
/*
    IDeliveryBoyRepository.java
    IRepository for the DeliveryBoy
    Mogammad-Redar Behardien
    10 April 2022
 */

import za.ac.cput.domain.DeliveryBoy;

import java.util.List;

public interface IDeliveryBoyRepository extends IRepository<DeliveryBoy, String> {
    public List<DeliveryBoy> getAll();
}
