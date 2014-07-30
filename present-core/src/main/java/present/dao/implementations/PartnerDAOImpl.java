package present.dao.implementations;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import present.dao.interfaces.PartnerDAO;
import present.entity.Partner;

/**
 * Created by Kos on 29.07.2014.
 */
public class PartnerDAOImpl extends HibernateDaoSupport implements PartnerDAO{
    @Override
    public void save(Partner partner) {
        getHibernateTemplate().save(partner);
    }

    @Override
    public void delete(Partner partner) {
        getHibernateTemplate().delete(partner);
    }

    @Override
    public void update(Partner partner) {
        getHibernateTemplate().update(partner);
    }
}
