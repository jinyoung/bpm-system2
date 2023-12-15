package bpm.system.infra;

import bpm.system.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class ProcessHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Process>> {

    @Override
    public EntityModel<Process> process(EntityModel<Process> model) {
        model.add(
            Link.of(model.getRequiredLink("self").getHref() + "/").withRel("")
        );
        model.add(
            Link.of(model.getRequiredLink("self").getHref() + "/").withRel("")
        );

        return model;
    }
}
