package present.dao.implementations;

import present.dao.interfaces.RecipientInfoDAO;
import present.entity.RecipientInfo;

/**
 * Created by Kos on 30.07.2014.
 */
public class ReciepientInfoDAOImpl extends CustomHibernateDaoSupport implements RecipientInfoDAO {
    @Override
    public void save(RecipientInfo recipientInfo) {
        getHibernateTemplate().save(recipientInfo);
    }

    @Override
    public void delete(RecipientInfo recipientInfo) {
        getHibernateTemplate().delete(recipientInfo);
    }

    @Override
    public void update(RecipientInfo recipientInfo) {
        getHibernateTemplate().update(recipientInfo);
    }
}
