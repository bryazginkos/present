package present.dao.implementations;

import present.dao.interfaces.ItemDAO;
import present.entity.Item;

public class ItemDaoImpl extends CustomHibernateDaoSupport implements ItemDAO {
    @Override
    public void save(Item item) {
        getHibernateTemplate().save(item);
    }

    @Override
    public void delete(Item item) {
        getHibernateTemplate().delete(item);
    }

    @Override
    public void update(Item item) {
        getHibernateTemplate().update(item);
    }
}
