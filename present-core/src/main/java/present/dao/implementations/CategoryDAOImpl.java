package present.dao.implementations;

import org.springframework.stereotype.Repository;
import present.dao.interfaces.CategoryDAO;
import present.entity.Category;

@Repository
public class CategoryDAOImpl extends CustomHibernateDaoSupport implements CategoryDAO {
    @Override
    public void save(Category category) {
        getHibernateTemplate().save(category);
    }

    @Override
    public void delete(Category category) {
        getHibernateTemplate().delete(category);
    }

    @Override
    public void update(Category category) {
        getHibernateTemplate().update(category);
    }
}
