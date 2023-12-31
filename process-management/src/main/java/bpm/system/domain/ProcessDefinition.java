package bpm.system.domain;

import bpm.system.ProcessManagementApplication;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ProcessDefinition_table")
@Data
//<<< DDD / Aggregate Root
public class ProcessDefinition {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long processId;

    private String processName;

    private String bpmnDefinition;

    @ElementCollection
    private List<Message> messages;

    @PrePersist
    public void onPrePersist() {}

    public static ProcessDefinitionRepository repository() {
        ProcessDefinitionRepository processDefinitionRepository = ProcessManagementApplication.applicationContext.getBean(
            ProcessDefinitionRepository.class
        );
        return processDefinitionRepository;
    }

    //<<< Clean Arch / Port Method
    public void createProcess(CreateProcessCommand createProcessCommand) {
        //implement business logic here:

        ProcessDefined processDefined = new ProcessDefined(this);
        processDefined.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void modifyProcess(ModifyProcessCommand modifyProcessCommand) {
        //implement business logic here:

        ProcessModified processModified = new ProcessModified(this);
        processModified.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void reviewProcess(ReviewProcessCommand reviewProcessCommand) {
        //implement business logic here:

        ProcessReviewed processReviewed = new ProcessReviewed(this);
        processReviewed.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
