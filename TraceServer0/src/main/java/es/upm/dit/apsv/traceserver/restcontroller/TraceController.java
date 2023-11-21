package es.upm.dit.apsv.traceserver.restcontroller;

import es.upm.dit.apsv.traceserver.model.Trace;
import es.upm.dit.apsv.traceserver.repository.TraceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TraceController {
    public static final Logger log = LoggerFactory.getLogger(TraceController.class);
    
    private final TraceRepository traceRepository;
    
    public TraceController(TraceRepository traceRepository) {
        this.traceRepository = traceRepository;
    }
    
    @GetMapping("/traces")
    public List<Trace> all() {
        log.info("Retrieving all traces");
        return (List<Trace>) traceRepository.findAll();
    }
    
    @PostMapping("/traces")
    public Trace createTrace(@RequestBody Trace newTrace) {
        log.info("Creating new trace");
        return traceRepository.save(newTrace);
    }
    
    @GetMapping("/traces/{traceId}")
    public Trace one(@PathVariable String traceId) {
        log.info("Attempting to find a trace by id");
        return traceRepository.findById(traceId).orElseThrow();
    }
    
    @PutMapping("/traces/{id}")
    public Trace replaceTrace(@RequestBody Trace replacingTrace, @PathVariable String id) {
        log.info("Attempting to replace a trace by id");
        
        return traceRepository.findById(id).map(Trace -> {
            log.info("Found trace by id, updating...");
            Trace.setTraceId(replacingTrace.getTraceId());
            Trace.setTruck(replacingTrace.getTruck());
            Trace.setLastSeen(replacingTrace.getLastSeen());
            Trace.setLat(replacingTrace.getLat());
            Trace.setLng(replacingTrace.getLng());
            return traceRepository.save(Trace);
        }).orElseGet(() -> {
            log.warn("Not found, but creating one from scratch...");
            replacingTrace.setTraceId(id);
            return traceRepository.save(replacingTrace);
        });
    }
    
    @DeleteMapping("/traces/{traceId}")
    public void deleteByTrace(@PathVariable String traceId) {
        log.warn("Deleting trace by id");
        traceRepository.deleteById(traceId);
    }
    
}
