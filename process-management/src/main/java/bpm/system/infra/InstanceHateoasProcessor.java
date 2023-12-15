package bpm.system.infra;

import bpm.system.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class InstanceHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Instance>> {

    @Override
    public EntityModel<Instance> process(EntityModel<Instance> model) {
        model.add(
            Link.of(model.getRequiredLink("self").getHref() + "/").withRel("")
        );

        return model;
    }
}
