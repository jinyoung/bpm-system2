package bpm.system.domain;

import bpm.system.domain.*;
import bpm.system.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class TaskCompleted extends AbstractEvent {

    private UUID taskId;

    public TaskCompleted(TaskList aggregate) {
        super(aggregate);
    }

    public TaskCompleted() {
        super();
    }
}
//>>> DDD / Domain Event
