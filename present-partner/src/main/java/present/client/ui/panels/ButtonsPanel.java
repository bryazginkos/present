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
public class ButtonsPanel extends Composite {
    interface ButtonsPanelUiBinder extends UiBinder<Widget, ButtonsPanel> {
    }

    private static ButtonsPanelUiBinder ourUiBinder = GWT.create(ButtonsPanelUiBinder.class);

    @UiField Button createBtn;

    public ButtonsPanel() {
        Widget rootElement = ourUiBinder.createAndBindUi(this);
        initWidget(rootElement);
    }
}