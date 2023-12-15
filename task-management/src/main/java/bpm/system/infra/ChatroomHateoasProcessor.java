package bpm.system.infra;

import bpm.system.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class ChatroomHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Chatroom>> {

    @Override
    public EntityModel<Chatroom> process(EntityModel<Chatroom> model) {
        model.add(
            Link.of(model.getRequiredLink("self").getHref() + "/").withRel("")
        );

        return model;
    }
}
