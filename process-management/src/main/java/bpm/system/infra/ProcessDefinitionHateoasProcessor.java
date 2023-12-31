package bpm.system.infra;

import bpm.system.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class ProcessDefinitionHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<ProcessDefinition>> {

    @Override
    public EntityModel<ProcessDefinition> process(
        EntityModel<ProcessDefinition> model
    ) {
        model.add(
            Link.of(model.getRequiredLink("self").getHref() + "/").withRel("")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/modifyprocess")
                .withRel("modifyprocess")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/reviewprocess")
                .withRel("reviewprocess")
        );

        return model;
    }
}
