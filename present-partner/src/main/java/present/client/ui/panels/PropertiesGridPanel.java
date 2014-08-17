package present.client.ui.panels;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import present.client.ui.widgets.PropertiesGrid;

/**
 * Created by Kos on 17.08.2014.
 */
public class PropertiesGridPanel extends Composite {
    interface PropertiesGridPanelUiBinder extends UiBinder<Widget, PropertiesGridPanel> {
    }

    private static PropertiesGridPanelUiBinder ourUiBinder = GWT.create(PropertiesGridPanelUiBinder.class);

    @UiField
    PropertiesGrid propertiesGrid;

    public PropertiesGridPanel() {
        Widget rootElement = ourUiBinder.createAndBindUi(this);
        initWidget(rootElement);
    }
}