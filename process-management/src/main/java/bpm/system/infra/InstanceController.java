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
// @RequestMapping(value="/instances")
@Transactional
public class InstanceController {

    @Autowired
    InstanceRepository instanceRepository;

    @RequestMapping(
        value = "instances/{id}/completeinstance",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Instance completeInstance(
        @PathVariable(value = "id") Long id,
        @RequestBody CompleteInstanceCommand completeInstanceCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /instance/completeInstance  called #####");
        Optional<Instance> optionalInstance = instanceRepository.findById(id);

        optionalInstance.orElseThrow(() -> new Exception("No Entity Found"));
        Instance instance = optionalInstance.get();
        instance.completeInstance(completeInstanceCommand);

        instanceRepository.save(instance);
        return instance;
    }
}
//>>> Clean Arch / Inbound Adaptor
