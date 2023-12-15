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

    private Long processId;
    private String newProcessName;

    public ProcessModified(ProcessDefinition aggregate) {
        super(aggregate);
    }

    public ProcessModified() {
        super();
    }
}
//>>> DDD / Domain Event
