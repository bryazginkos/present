package present.client.ui.panels;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import present.client.ui.widgets.ItemsGrid;

/**
 * Created by Kos on 15.08.2014.
 */
public class GridPanel extends Composite {
    interface GridPanelUiBinder extends UiBinder<Widget, GridPanel> {
    }

    private static GridPanelUiBinder ourUiBinder = GWT.create(GridPanelUiBinder.class);

    @UiField
    ItemsGrid itemsGrid;

    public GridPanel() {
        Widget rootElement = ourUiBinder.createAndBindUi(this);
        initWidget(itemsGrid);
    }
}