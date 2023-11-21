package es.upm.dit.apsv.traceserver.repository;

import es.upm.dit.apsv.traceserver.model.Trace;
import org.springframework.data.repository.CrudRepository;

public interface TraceRepository extends CrudRepository<Trace, String> {}
