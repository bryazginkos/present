package present.dao.implementations;

import org.springframework.stereotype.Repository;
import present.dao.interfaces.PropertyDAO;
import present.entity.Property;

@Repository
public class PropertyDAOImpl extends CustomHibernateDaoSupport implements PropertyDAO {
    @Override
    public void save(Property property) {
        getHibernateTemplate().save(property);
    }

    @Override
    public void delete(Property property) {
        getHibernateTemplate().delete(property);
    }

    @Override
    public void update(Property property) {
        getHibernateTemplate().update(property);
    }
}
