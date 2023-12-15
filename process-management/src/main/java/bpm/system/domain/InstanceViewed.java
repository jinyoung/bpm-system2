package bpm.system.domain;

import bpm.system.domain.*;
import bpm.system.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class InstanceViewed extends AbstractEvent {

    private UUID instanceId;
    private String status;

    public InstanceViewed(Instance aggregate) {
        super(aggregate);
    }

    public InstanceViewed() {
        super();
    }
}
//>>> DDD / Domain Event
