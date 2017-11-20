package messenger.dao;

import messenger.model.ShortChannelData;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ShortChannelDAOImpl implements ShortChannelDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<ShortChannelData> getChannels() {
        Session session = this.sessionFactory.openSession();
        List<ShortChannelData> personList = session.createQuery("from ShortChannelData").list();
        session.close();
        return personList;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}
