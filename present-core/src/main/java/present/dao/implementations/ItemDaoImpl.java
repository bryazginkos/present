package present.dao.implementations;


import org.springframework.stereotype.Service;
import present.dao.interfaces.ItemDAO;
import present.entity.Item;

import javax.transaction.Transactional;


/**
 * Created by Kos on 28.07.2014.
 */
@Service("ItemDao")
public class ItemDaoImpl extends CustomHibernateDaoSupport implements ItemDAO {
    @Override
    @Transactional
    public void save(Item item) {
        getHibernateTemplate().save(item);
    }
}
