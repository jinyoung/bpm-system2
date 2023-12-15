package bpm.system.domain;

import bpm.system.TaskManagementApplication;
import bpm.system.domain.TaskListQueried;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "TaskList_table")
@Data
//<<< DDD / Aggregate Root
public class TaskList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long taskId;

    private Long userId;

    private String taskName;

    private String status;

    @PostPersist
    public void onPostPersist() {
        TaskListQueried taskListQueried = new TaskListQueried(this);
        taskListQueried.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static TaskListRepository repository() {
        TaskListRepository taskListRepository = TaskManagementApplication.applicationContext.getBean(
            TaskListRepository.class
        );
        return taskListRepository;
    }

    //<<< Clean Arch / Port Method
    public void completeTask(CompleteTaskCommand completeTaskCommand) {
        //implement business logic here:

        TaskCompleted taskCompleted = new TaskCompleted(this);
        taskCompleted.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
