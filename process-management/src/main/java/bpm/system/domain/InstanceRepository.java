package bpm.system.domain;

import bpm.system.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "instances", path = "instances")
public interface InstanceRepository
    extends PagingAndSortingRepository<Instance, Long> {}
