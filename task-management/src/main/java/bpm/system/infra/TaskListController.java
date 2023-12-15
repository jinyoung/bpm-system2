package bpm.system.infra;

import bpm.system.domain.*;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/taskLists")
@Transactional
public class TaskListController {

    @Autowired
    TaskListRepository taskListRepository;

    @RequestMapping(
        value = "taskLists/{id}/completetask",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public TaskList completeTask(
        @PathVariable(value = "id") Long id,
        @RequestBody CompleteTaskCommand completeTaskCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /taskList/completeTask  called #####");
        Optional<TaskList> optionalTaskList = taskListRepository.findById(id);

        optionalTaskList.orElseThrow(() -> new Exception("No Entity Found"));
        TaskList taskList = optionalTaskList.get();
        taskList.completeTask(completeTaskCommand);

        taskListRepository.save(taskList);
        return taskList;
    }
}
//>>> Clean Arch / Inbound Adaptor
