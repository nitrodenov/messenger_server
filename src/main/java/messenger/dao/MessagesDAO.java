package messenger.dao;

import messenger.model.Message;

import java.util.List;

public interface MessagesDAO {

    List<Message> getMessages(String id, Integer lastItemIndex);

    void save(Message message);
}
