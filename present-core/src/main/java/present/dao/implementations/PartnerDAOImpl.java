package present.dao.implementations;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import present.dao.interfaces.PartnerDAO;
import present.entity.Partner;

@Repository
public class PartnerDAOImpl extends CustomHibernateDaoSupport implements PartnerDAO{
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
