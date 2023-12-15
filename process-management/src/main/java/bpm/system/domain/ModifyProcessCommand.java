package bpm.system.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class ModifyProcessCommand {

    private UUID processId;
    private String newProcessName;
    private List<Task> newTaskList;
    private List<Permission> newPermissions;
}
