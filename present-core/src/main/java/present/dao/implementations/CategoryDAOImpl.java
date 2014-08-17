package present.dao.implementations;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;
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

    @Override
    public Category getRootCategory() {
        Criteria criteria = getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(Category.class);
        criteria.add(Restrictions.isNull("parent"));
        criteria.setFetchMode("parent", FetchMode.JOIN);
        return (Category)criteria.list().get(0);
    }
}
