package bpm.system.domain;

import bpm.system.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "processDefinitions",
    path = "processDefinitions"
)
public interface ProcessDefinitionRepository
    extends PagingAndSortingRepository<ProcessDefinition, Long> {}
