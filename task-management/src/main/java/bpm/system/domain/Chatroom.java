package bpm.system.domain;

import bpm.system.TaskManagementApplication;
import bpm.system.domain.ChatroomCreated;
import bpm.system.domain.MessageSent;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Chatroom_table")
@Data
//<<< DDD / Aggregate Root
public class Chatroom {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long chatroomId;

    @ElementCollection
    private List<Message> messages;

    @ElementCollection
    private List<Member> members;

    @PostPersist
    public void onPostPersist() {
        ChatroomCreated chatroomCreated = new ChatroomCreated(this);
        chatroomCreated.publishAfterCommit();

        MessageSent messageSent = new MessageSent(this);
        messageSent.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static ChatroomRepository repository() {
        ChatroomRepository chatroomRepository = TaskManagementApplication.applicationContext.getBean(
            ChatroomRepository.class
        );
        return chatroomRepository;
    }

    //<<< Clean Arch / Port Method
    public void enterChatroom(EnterChatroomCommand enterChatroomCommand) {
        //implement business logic here:

        ChatroomEntered chatroomEntered = new ChatroomEntered(this);
        chatroomEntered.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
