package bpm.system.domain;

import bpm.system.domain.*;
import bpm.system.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class InstanceCompleted extends AbstractEvent {

    private UUID instanceId;

    public InstanceCompleted(Instance aggregate) {
        super(aggregate);
    }

    public InstanceCompleted() {
        super();
    }
}
//>>> DDD / Domain Event
