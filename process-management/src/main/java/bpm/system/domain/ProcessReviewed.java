package bpm.system.domain;

import bpm.system.domain.*;
import bpm.system.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class ProcessReviewed extends AbstractEvent {

    private Long processId;
    private String reviewResult;

    public ProcessReviewed(ProcessDefinition aggregate) {
        super(aggregate);
    }

    public ProcessReviewed() {
        super();
    }
}
//>>> DDD / Domain Event
