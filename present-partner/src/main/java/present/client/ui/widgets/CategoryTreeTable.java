package present.client.ui.widgets;


import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import present.client.DataService;
import present.client.dto.Category;


import java.util.LinkedList;
import java.util.List;


/**
 * Created by Kos on 17.08.2014.
 */
public class CategoryTreeTable extends Tree {

    private ItemLabel selectedItemLabel;

    public CategoryTreeTable() {
        DataService.App.getInstance().getRootCategoryWithChildren(new AsyncCallback<Category>() {
            @Override
            public void onFailure(Throwable caught) {
                Window.alert("Ошибка");
            }

            @Override
            public void onSuccess(Category result) {
                fillTree(result);
            }
        });
    }

    public void fillTree(Category rootCategory) {
        clear();
        fillBranch(rootCategory, null);

    }

    private void fillBranch(Category currentCategory, TreeItem parentItem) {
        TreeItem currentItem;
        if (parentItem == null) {
            currentItem = addItem(new ItemLabel(currentCategory.getTitle(), currentCategory.getId()));
            if (currentCategory.getChildren() != null) {
                for (Category nextCurrentCategory : currentCategory.getChildren()) {
                    fillBranch(nextCurrentCategory, currentItem);
                }
            }
        }
        else {
            currentItem = parentItem.addItem(new ItemLabel(currentCategory.getTitle(), currentCategory.getId()));
            if (currentCategory.getChildren() != null) {
                for (Category nextRootCategory : currentCategory.getChildren()) {
                    fillBranch(nextRootCategory, currentItem);
                }
            }

        }
    }

    class ItemLabel extends Label {
        public static final String CATEGORY_LABEL_STYLE = "categoryLabel";
        public static final String CATEGORY_LABEL_STYLE_SELECTED = "categoryLabelSelected";
        public int categoryId;
        private ClickHandler selectClickHandler = new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (selectedItemLabel!= null) {
                    selectedItemLabel.deSelect();
                }
                selectedItemLabel = ItemLabel.this;
                selectedItemLabel.select();
            }
        };

        ItemLabel(String text, int categoryId) {
            super(text);
            this.categoryId = categoryId;
            deSelect();
            addClickHandler(selectClickHandler);
        }

        private void deSelect() {
            setStyleName(CATEGORY_LABEL_STYLE);
        }

        private void select() {
            setStyleName(CATEGORY_LABEL_STYLE_SELECTED);
        }
    }

}
