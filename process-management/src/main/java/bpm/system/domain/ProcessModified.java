package bpm.system.domain;

import bpm.system.domain.*;
import bpm.system.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class ProcessModified extends AbstractEvent {

    private UUID processId;
    private String newProcessName;
    private List<Task> newTaskList;
    private List<Permission> newPermissions;

    public ProcessModified(Process aggregate) {
        super(aggregate);
    }

    public ProcessModified() {
        super();
    }
}
//>>> DDD / Domain Event
