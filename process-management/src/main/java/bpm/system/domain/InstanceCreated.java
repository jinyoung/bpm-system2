package bpm.system.domain;

import bpm.system.domain.*;
import bpm.system.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class InstanceCreated extends AbstractEvent {

    private Long instanceId;
    private UUID processId;

    public InstanceCreated(Instance aggregate) {
        super(aggregate);
    }

    public InstanceCreated() {
        super();
    }
}
//>>> DDD / Domain Event
