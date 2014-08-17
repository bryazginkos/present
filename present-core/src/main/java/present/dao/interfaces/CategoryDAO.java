package present.dao.interfaces;

import present.entity.Category;

/**
 * Created by Kos on 30.07.2014.
 */
public interface CategoryDAO extends CommonDAO<Category> {

    Category getRootCategory();
}
