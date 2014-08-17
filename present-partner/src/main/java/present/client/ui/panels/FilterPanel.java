package present.client.ui.panels;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import present.client.ui.widgets.CategoryTreeTable;

/**
 * Created by Kos on 17.08.2014.
 */
public class FilterPanel extends Composite {
    interface FilterPanelUiBinder extends UiBinder<Widget, FilterPanel> {
    }

    private static FilterPanelUiBinder ourUiBinder = GWT.create(FilterPanelUiBinder.class);

    @UiField
    CategoryTreeTable categoryTreeTable;

    public FilterPanel() {
        Widget rootElement = ourUiBinder.createAndBindUi(this);
        initWidget(rootElement);
    }
}