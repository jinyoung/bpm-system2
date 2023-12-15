package bpm.system.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class ReviewProcessCommand {

    private Long processId;
    private String reviewResult;
}
