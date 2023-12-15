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
// @RequestMapping(value="/chatrooms")
@Transactional
public class ChatroomController {

    @Autowired
    ChatroomRepository chatroomRepository;

    @RequestMapping(
        value = "chatrooms/{id}/",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Chatroom enterChatroom(
        @PathVariable(value = "id") Long id,
        @RequestBody EnterChatroomCommand enterChatroomCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /chatroom/enterChatroom  called #####");
        Optional<Chatroom> optionalChatroom = chatroomRepository.findById(id);

        optionalChatroom.orElseThrow(() -> new Exception("No Entity Found"));
        Chatroom chatroom = optionalChatroom.get();
        chatroom.enterChatroom(enterChatroomCommand);

        chatroomRepository.save(chatroom);
        return chatroom;
    }
}
//>>> Clean Arch / Inbound Adaptor
