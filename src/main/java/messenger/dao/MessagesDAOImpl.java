package messenger.dao;

import messenger.model.Message;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MessagesDAOImpl implements MessagesDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Message> getMessages(String id, Integer lastItemIndex) {
        Session session = this.sessionFactory.openSession();
        //todo грешновато. переписать.
        SQLQuery query = session
                .createSQLQuery("select * from message where id in (select unnest(messagesid) from messages where id = '" + id + "' limit 10 offset " + lastItemIndex + ");");
        List<Object[]> rows = query.list();
        List<Message> messages = new ArrayList<>();
        for (Object[] entity : rows) {
            Message message = new Message();
            message.setId(entity[0].toString());
            message.setText(entity[1].toString());
            message.setTime(entity[2].toString());
            message.setLogo(entity[3].toString());
            if (entity[4] != null) {
                message.setImageInMessage(entity[4].toString());
            }
            message.setIncomeMessage(Boolean.parseBoolean(entity[5].toString()));
            messages.add(message);
        }
        session.close();
        return messages;
    }

    @Override
    public void save(Message message) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(message);
        tx.commit();
        session.close();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}
