package bpm.system.domain;

import bpm.system.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "chatrooms", path = "chatrooms")
public interface ChatroomRepository
    extends PagingAndSortingRepository<Chatroom, Long> {}
