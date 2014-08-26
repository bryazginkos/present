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
public class ItemPanel extends Composite {
    interface ItemPanelUiBinder extends UiBinder<Widget, ItemPanel> {
    }

    private static ItemPanelUiBinder ourUiBinder = GWT.create(ItemPanelUiBinder.class);

    @UiField
    PropertiesGrid propertiesGrid;

    public ItemPanel() {
        Widget rootElement = ourUiBinder.createAndBindUi(this);
        initWidget(rootElement);
    }
}