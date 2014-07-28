package present.dao.implementations;

import org.hibernate.FlushMode;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

/**
 * Created by Kos on 28.07.2014.
 */
public class CustomHibernateDaoSupport extends HibernateDaoSupport {
    @Autowired
    public void anyMethodName(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }
}
