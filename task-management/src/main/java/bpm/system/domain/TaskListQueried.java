package bpm.system.domain;

import bpm.system.domain.*;
import bpm.system.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class TaskListQueried extends AbstractEvent {

    private UUID taskId;
    private String taskName;
    private String status;

    public TaskListQueried(TaskList aggregate) {
        super(aggregate);
    }

    public TaskListQueried() {
        super();
    }
}
//>>> DDD / Domain Event
