package present.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import present.client.DataService;
import present.client.dto.Category;
import present.server.util.DTOConverter;
import present.service.ServiceFactory;
import present.service.implementations.StaticServiceImpl;
import present.service.interfaces.StaticService;

/**
 * Created by Kos on 15.08.2014.
 */
public class dataServiceImpl extends RemoteServiceServlet implements DataService {

    @Override
    public Category getRootCategoryWithChildren() {
        present.entity.Category rootCategory = ServiceFactory.getStaticServiceInstance().getRootCategory();
        return DTOConverter.toCategoryDTOWithChildren(rootCategory);
    }
}