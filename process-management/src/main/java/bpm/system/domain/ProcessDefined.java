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

    private Long processId;
    private String processName;

    public ProcessDefined(Process aggregate) {
        super(aggregate);
    }

    public ProcessDefined() {
        super();
    }
}
//>>> DDD / Domain Event
