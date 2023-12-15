package bpm.system.domain;

import bpm.system.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "processes", path = "processes")
public interface ProcessRepository
    extends PagingAndSortingRepository<Process, Long> {}
