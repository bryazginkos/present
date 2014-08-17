package present.client.ui.widgets;


import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import present.client.dto.Item;

/**
 * Created by Kos on 15.08.2014.
 */
public class ItemsGrid extends CellTable<Item> {
    public ItemsGrid() {
        addColumns();
    }

    private void addColumns(){
        TextColumn<Item> id = new TextColumn<Item>() {
            @Override
            public String getValue(Item object) {
                return String.valueOf(object.getId());
            }
        };
        addColumn(id, "Id");

        TextColumn<Item> title = new TextColumn<Item>() {
            @Override
            public String getValue(Item object) {
                return object.getTitle();
            }
        };
        addColumn(title, "Наименование");

        TextColumn<Item> category = new TextColumn<Item>() {
            @Override
            public String getValue(Item object) {
                return object.getCategory().getTitle();
            }
        };
        addColumn(category, "Категория");


        TextColumn<Item> price = new TextColumn<Item>() {
            @Override
            public String getValue(Item object) {
                return String.valueOf(object.getPrice());
            }
        };
        addColumn(price, "Цена");


    }
}
