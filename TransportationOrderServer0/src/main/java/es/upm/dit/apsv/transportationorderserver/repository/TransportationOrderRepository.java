package es.upm.dit.apsv.transportationorderserver.repository;

import es.upm.dit.apsv.transportationorderserver.model.TransportationOrder;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TransportationOrderRepository extends CrudRepository<TransportationOrder, String> {
    TransportationOrder findByTruckAndSt(String truck, int st);
    
    Optional<TransportationOrder> findByTruck(String truck);
}
