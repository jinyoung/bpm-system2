package bpm.system.domain;

import bpm.system.domain.*;
import bpm.system.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class ProcessDefined extends AbstractEvent {

    private UUID processId;
    private String processName;
    private List<Task> taskList;
    private List<Permission> permissions;

    public ProcessDefined(Process aggregate) {
        super(aggregate);
    }

    public ProcessDefined() {
        super();
    }
}
//>>> DDD / Domain Event
