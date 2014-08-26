package present.client.ui.panels;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

/**
 * Created by Kos on 15.08.2014.
 */
public class MainPanel extends Composite {
    interface MainPanelUiBinder extends UiBinder<Widget, MainPanel> {
    }

    private static MainPanelUiBinder ourUiBinder = GWT.create(MainPanelUiBinder.class);

    @UiField
    CategoryPanel categoryPanel;

    @UiField
    ItemsGridPanel itemsGridPanel;

    @UiField
    ItemPanel itemPanel;

    @UiField
    ButtonsPanel buttonsPanel;

    public MainPanel() {
        Widget rootElement = ourUiBinder.createAndBindUi(this);
        initWidget(rootElement);
    }
}