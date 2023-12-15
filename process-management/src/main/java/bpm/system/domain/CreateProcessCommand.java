package bpm.system.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class CreateProcessCommand {

    private String processName;
    private List<Task> taskList;
    private List<Permission> permissions;
}
