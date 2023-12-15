package bpm.system.domain;

import bpm.system.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "taskLists", path = "taskLists")
public interface TaskListRepository
    extends PagingAndSortingRepository<TaskList, Long> {}
