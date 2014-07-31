package present.dao.implementations;

import org.springframework.stereotype.Repository;
import present.dao.interfaces.PresentDAO;
import present.entity.Present;

@Repository
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
