package bpm.system.domain;

import bpm.system.ProcessManagementApplication;
import bpm.system.domain.InstanceCreated;
import bpm.system.domain.InstanceViewed;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Instance_table")
@Data
//<<< DDD / Aggregate Root
public class Instance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long instanceId;

    private Long processId;

    private String status;

    @ElementCollection
    private List<Message> messages;

    @PostPersist
    public void onPostPersist() {
        InstanceCreated instanceCreated = new InstanceCreated(this);
        instanceCreated.publishAfterCommit();

        InstanceViewed instanceViewed = new InstanceViewed(this);
        instanceViewed.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static InstanceRepository repository() {
        InstanceRepository instanceRepository = ProcessManagementApplication.applicationContext.getBean(
            InstanceRepository.class
        );
        return instanceRepository;
    }

    //<<< Clean Arch / Port Method
    public void completeInstance(
        CompleteInstanceCommand completeInstanceCommand
    ) {
        //implement business logic here:

        InstanceCompleted instanceCompleted = new InstanceCompleted(this);
        instanceCompleted.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
