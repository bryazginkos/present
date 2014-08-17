package present.client.ui.widgets;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import present.client.dto.Property;

/**
 * Created by Kos on 17.08.2014.
 */
public class PropertiesGrid extends CellTable <Property> {
    public PropertiesGrid() {
        addColumns();
    }

    private void addColumns(){
        TextColumn<Property> code = new TextColumn<Property>() {
            @Override
            public String getValue(Property object) {
                return object.getCode();
            }
        };
        addColumn(code, "Код");

        TextColumn<Property> value = new TextColumn<Property>() {
            @Override
            public String getValue(Property object) {
                return object.getValue();
            }
        };
        addColumn(value, "Значение");
    }
}
