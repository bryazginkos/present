package present.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;
import present.client.ui.panels.ItemsEditPanel;
import present.client.ui.panels.MainPanel;

/**
 * Created by Kos on 15.08.2014.
 */
public class DataModule implements EntryPoint {
    public void onModuleLoad() {
        MainPanel mainPanel = new MainPanel();
        RootPanel.get().add(mainPanel);
    }
}
