package bpm.system.domain;

import bpm.system.domain.*;
import bpm.system.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class ChatroomCreated extends AbstractEvent {

    private UUID chatroomId;
    private List<User> members;

    public ChatroomCreated(Chatroom aggregate) {
        super(aggregate);
    }

    public ChatroomCreated() {
        super();
    }
}
//>>> DDD / Domain Event
