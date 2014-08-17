package present.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import present.dao.interfaces.CategoryDAO;
import present.entity.Category;
import present.service.interfaces.StaticService;

/**
 * Created by Kos on 17.08.2014.
 */
@Service
public class StaticServiceImpl implements StaticService {

    @Autowired
    private CategoryDAO categoryDAO;

    @Transactional
    public Category getRootCategory() {
        return categoryDAO.getRootCategory();
    }
}
