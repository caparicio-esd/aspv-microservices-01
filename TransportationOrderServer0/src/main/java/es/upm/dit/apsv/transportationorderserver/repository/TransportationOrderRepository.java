package es.upm.dit.apsv.transportationorderserver.repository;

import es.upm.dit.apsv.transportationorderserver.model.TransportationOrder;
import org.springframework.data.repository.CrudRepository;

public interface TransportationOrderRepository extends CrudRepository<TransportationOrder, String> {
    TransportationOrder findByTruckAndSt(String truck, int st);
}
