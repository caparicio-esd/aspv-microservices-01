package es.upm.dit.apsv.transportationorderserver.restcontroller;

import es.upm.dit.apsv.transportationorderserver.model.TransportationOrder;
import es.upm.dit.apsv.transportationorderserver.repository.TransportationOrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TransportationOrderController {
    public static final Logger log = LoggerFactory.getLogger(TransportationOrderController.class);

    private final TransportationOrderRepository transportationOrderRepository;


    public TransportationOrderController(TransportationOrderRepository transportationOrderRepository) {
        this.transportationOrderRepository = transportationOrderRepository;
    }

    @GetMapping("/transportationorders")
    public List<TransportationOrder> all() {
        log.info("Retrieving all transportation orders");
        return (List<TransportationOrder>) transportationOrderRepository.findAll();
    }

    @PostMapping("/transportationorders")
    public TransportationOrder newOrder(@RequestBody TransportationOrder newOrder) {
        log.info("Creating new order");
        return transportationOrderRepository.save(newOrder);
    }

    @GetMapping("/transportationorders/{truckId}")
    public ResponseEntity<TransportationOrder> getByTruck(@PathVariable String truckId) {
        log.info("Attempting to get transportation by truck");
        Optional<TransportationOrder> truck = transportationOrderRepository.findById(truckId);
        if (truck.isPresent()) {
            log.info("Retrieving transportation by truck");
            return new ResponseEntity<>(truck.get(), HttpStatus.OK);
        } else {
            log.warn("Transportation not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping ("/transportationorders")
    public ResponseEntity<TransportationOrder> update(@RequestBody TransportationOrder updatingOrder) {
        log.info("Attempting to update transportation");
        TransportationOrder to = transportationOrderRepository.save(updatingOrder);
        if (to == null) {
            log.warn("Transportation not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            log.info("Retrieving updated transportation");
            return new ResponseEntity<>(to, HttpStatus.OK);
        }
    }

    @DeleteMapping("/transportationorders/{truckId}")
    public void deleteOrder(@PathVariable String truckId) {
        log.warn("Deleting transportation order");
        transportationOrderRepository.deleteById(truckId);
    }
}
