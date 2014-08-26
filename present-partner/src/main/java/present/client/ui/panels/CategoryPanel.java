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
public class CategoryPanel extends Composite {
    interface CategoryPanelUiBinder extends UiBinder<Widget, CategoryPanel> {
    }

    private static CategoryPanelUiBinder ourUiBinder = GWT.create(CategoryPanelUiBinder.class);

    @UiField
    CategoryTreeTable categoryTreeTable;

    public CategoryPanel() {
        Widget rootElement = ourUiBinder.createAndBindUi(this);
        initWidget(rootElement);
    }
}