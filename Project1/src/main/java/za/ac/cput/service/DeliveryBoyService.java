package za.ac.cput.service;

import za.ac.cput.domain.DeliveryBoy;
import za.ac.cput.service.IService;
import java.util.List;
//import za.ac.cput.school_management.domain.city.Country;
import java.util.Set;

public interface DeliveryBoyService extends IService<DeliveryBoy, String> {

    public List<DeliveryBoy> getAll();
    void deleteById(String id);


}