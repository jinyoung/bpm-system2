package bpm.system.domain;

import bpm.system.domain.*;
import bpm.system.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class ChatroomEntered extends AbstractEvent {

    private UUID chatroomId;

    public ChatroomEntered(Chatroom aggregate) {
        super(aggregate);
    }

    public ChatroomEntered() {
        super();
    }
}
//>>> DDD / Domain Event
