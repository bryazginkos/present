package present.client.ui.widgets;

import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;

/**
 * Created by Kos on 15.08.2014.
 */
public class ItemsGrid extends Grid {
    public ItemsGrid() {
        super(1,4);
        setText(0,0,"ID");
        setText(0,1, "Наименование");
        setText(0,2, "Цена");
        setText(0,3, "Резервирован");
    }
}
