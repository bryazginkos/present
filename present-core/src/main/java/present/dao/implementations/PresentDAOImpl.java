package present.dao.implementations;

import present.dao.interfaces.PresentDAO;
import present.entity.Present;

/**
 * Created by Kos on 30.07.2014.
 */
public class PresentDAOImpl extends CustomHibernateDaoSupport implements PresentDAO {
    @Override
    public void save(Present present) {
        getHibernateTemplate().save(present);
    }

    @Override
    public void delete(Present present) {
        getHibernateTemplate().delete(present);
    }

    @Override
    public void update(Present present) {
        getHibernateTemplate().update(present);
    }
}
