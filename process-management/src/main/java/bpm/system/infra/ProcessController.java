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
// @RequestMapping(value="/processes")
@Transactional
public class ProcessController {

    @Autowired
    ProcessRepository processRepository;

    @RequestMapping(
        value = "processes/{id}/",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Process modifyProcess(
        @PathVariable(value = "id") Long id,
        @RequestBody ModifyProcessCommand modifyProcessCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /process/modifyProcess  called #####");
        Optional<Process> optionalProcess = processRepository.findById(id);

        optionalProcess.orElseThrow(() -> new Exception("No Entity Found"));
        Process process = optionalProcess.get();
        process.modifyProcess(modifyProcessCommand);

        processRepository.save(process);
        return process;
    }

    @RequestMapping(
        value = "processes/{id}/",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Process reviewProcess(
        @PathVariable(value = "id") Long id,
        @RequestBody ReviewProcessCommand reviewProcessCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /process/reviewProcess  called #####");
        Optional<Process> optionalProcess = processRepository.findById(id);

        optionalProcess.orElseThrow(() -> new Exception("No Entity Found"));
        Process process = optionalProcess.get();
        process.reviewProcess(reviewProcessCommand);

        processRepository.save(process);
        return process;
    }
}
//>>> Clean Arch / Inbound Adaptor
