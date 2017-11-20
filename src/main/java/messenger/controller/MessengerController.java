package messenger.controller;

import messenger.dao.MessagesDAO;
import messenger.dao.ShortChannelDAOImpl;
import messenger.model.Message;
import messenger.model.ShortChannelData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessengerController {

    @Autowired
    ShortChannelDAOImpl shortChannelDAO;
    @Autowired
    MessagesDAO messagesDAO;

    @RequestMapping("/channels")
    public List<ShortChannelData> getChannels() {
        return shortChannelDAO.getChannels();
    }

    @RequestMapping("/messages")
    public List<Message> getMessages(@RequestParam(value = "id", defaultValue = "") String id,
                                     @RequestParam(value = "index", defaultValue = "0") Integer index) {
        return messagesDAO.getMessages(id, index);
    }
}
