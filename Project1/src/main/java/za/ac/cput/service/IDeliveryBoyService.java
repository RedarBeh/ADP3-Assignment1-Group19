package za.ac.cput.service;

import java.util.*;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.DeliveryBoy;

//import za.ac.cput.school_management.repository.city.CountryRepository;
import za.ac.cput.repository.DeliveryBoyRepository;

//import za.ac.cput.school_management.repository.city.impl.CountryRepositoryIMPL;
import za.ac.cput.repository.IDeliveryBoyRepository;

import za.ac.cput.service.DeliveryBoyService;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service

public class IDeliveryBoyService implements DeliveryBoyService {

    private static DeliveryBoyService deliveryBoyService = null;
    private IDeliveryBoyRepository iDeliveryBoyRepository;

    private IDeliveryBoyService() {
        this.iDeliveryBoyRepository = (IDeliveryBoyRepository) DeliveryBoyRepository.getRepository();
    }

    public static DeliveryBoyService getDeliveryBoyService() {
        if (deliveryBoyService == null)
            deliveryBoyService = new IDeliveryBoyService();
        return deliveryBoyService;
    }

    @Override // change on both sides to lists
    public List<DeliveryBoy> getAll() {
        return this.iDeliveryBoyRepository.getAll();
    }

    @Override
    public DeliveryBoy save(DeliveryBoy deliveryBoy) {
        return this.iDeliveryBoyRepository.save(deliveryBoy);// (create or save?)
    }

    @Override
    public Optional<DeliveryBoy> read(String a) {
        return this.iDeliveryBoyRepository.read(a);
    }
/*
    @Override
    public DeliveryBoy update(DeliveryBoy deliveryBoy) {
        return this.iDeliveryBoyRepository.update(deliveryBoy);
    }
*/
    @Override
    public void delete(DeliveryBoy a) {
        this.iDeliveryBoyRepository.delete(a);
    }
    @Override
    public void deleteById(String id){
        Optional<DeliveryBoy> cd = read(id);
        if(cd.isPresent()) delete(cd.get());
    }

}
