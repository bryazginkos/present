package present.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.google.gwt.core.client.GWT;
import present.client.dto.Category;

/**
 * Created by Kos on 15.08.2014.
 */
@RemoteServiceRelativePath("dataService")
public interface DataService extends RemoteService {

    Category getRootCategoryWithChildren();

    /**
     * Utility/Convenience class.
     * Use dataService.App.getInstance() to access static instance of dataServiceAsync
     */
    public static class App {
        private static final DataServiceAsync ourInstance = (DataServiceAsync) GWT.create(DataService.class);

        public static DataServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
