package present.client.ui.panels;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

/**
 * Created by Kos on 15.08.2014.
 */
public class ItemsEditPanel extends Composite {
    interface ItemsEditPanelUiBinder extends UiBinder<Widget, ItemsEditPanel> {
    }

    private static ItemsEditPanelUiBinder ourUiBinder = GWT.create(ItemsEditPanelUiBinder.class);

    @UiField Button createBtn;
    @UiField Button changeBtn;
    @UiField Button deleteBtn;

    public ItemsEditPanel() {
        Widget rootElement = ourUiBinder.createAndBindUi(this);
        initWidget(rootElement);
    }
}