package bpm.system.domain;

import bpm.system.domain.*;
import bpm.system.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class MessageSent extends AbstractEvent {

    private Long chatroomId;
    private Long senderId;
    private String content;

    public MessageSent(Chatroom aggregate) {
        super(aggregate);
    }

    public MessageSent() {
        super();
    }
}
//>>> DDD / Domain Event
