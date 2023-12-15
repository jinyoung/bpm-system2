package bpm.system.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class SendMessageCommand {

    private Long chatroomId;
    private UUID senderId;
    private String content;
}
