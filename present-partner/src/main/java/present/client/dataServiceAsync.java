package present.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import present.client.dto.Category;

/**
 * Created by Kos on 15.08.2014.
 */
public interface DataServiceAsync {
    public void getRootCategoryWithChildren(AsyncCallback<Category> callback);
}
