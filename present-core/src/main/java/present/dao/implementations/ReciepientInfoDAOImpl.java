package present.dao.implementations;

import org.springframework.stereotype.Repository;
import present.dao.interfaces.RecipientInfoDAO;
import present.entity.RecipientInfo;

@Repository
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
