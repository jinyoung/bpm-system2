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
// @RequestMapping(value="/processDefinitions")
@Transactional
public class ProcessDefinitionController {

    @Autowired
    ProcessDefinitionRepository processDefinitionRepository;

    @RequestMapping(
        value = "processDefinitions/",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public ProcessDefinition createProcess(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody ProcessDefinition processDefinition
    ) throws Exception {
        System.out.println(
            "##### /processDefinition/createProcess  called #####"
        );
        processDefinition.createProcess(createProcesscommand);
        processDefinitionRepository.save(processDefinition);
        return processDefinition;
    }

    @RequestMapping(
        value = "processDefinitions/{id}/modifyprocess",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public ProcessDefinition modifyProcess(
        @PathVariable(value = "id") Long id,
        @RequestBody ModifyProcessCommand modifyProcessCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println(
            "##### /processDefinition/modifyProcess  called #####"
        );
        Optional<ProcessDefinition> optionalProcessDefinition = processDefinitionRepository.findById(
            id
        );

        optionalProcessDefinition.orElseThrow(() ->
            new Exception("No Entity Found")
        );
        ProcessDefinition processDefinition = optionalProcessDefinition.get();
        processDefinition.modifyProcess(modifyProcessCommand);

        processDefinitionRepository.save(processDefinition);
        return processDefinition;
    }

    @RequestMapping(
        value = "processDefinitions/{id}/reviewprocess",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public ProcessDefinition reviewProcess(
        @PathVariable(value = "id") Long id,
        @RequestBody ReviewProcessCommand reviewProcessCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println(
            "##### /processDefinition/reviewProcess  called #####"
        );
        Optional<ProcessDefinition> optionalProcessDefinition = processDefinitionRepository.findById(
            id
        );

        optionalProcessDefinition.orElseThrow(() ->
            new Exception("No Entity Found")
        );
        ProcessDefinition processDefinition = optionalProcessDefinition.get();
        processDefinition.reviewProcess(reviewProcessCommand);

        processDefinitionRepository.save(processDefinition);
        return processDefinition;
    }
}
//>>> Clean Arch / Inbound Adaptor
