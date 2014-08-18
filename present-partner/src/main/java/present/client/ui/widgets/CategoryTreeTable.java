package present.client.ui.widgets;


import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import present.client.DataService;
import present.client.dto.Category;

/**
 * Created by Kos on 17.08.2014.
 */
public class CategoryTreeTable extends Tree {

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
            for (Category nextCurrentCategory : currentCategory.getChildren()) {
                fillBranch(nextCurrentCategory, currentItem);
            }
        }
        else {
            currentItem = parentItem.addItem(new ItemLabel(currentCategory.getTitle(), currentCategory.getId()));
            for (Category nextRootCategory : currentCategory.getChildren()) {
                fillBranch(nextRootCategory, currentItem);
            }

        }
    }

    class ItemLabel extends Label {
        public int categoryId;

        ItemLabel(String text, int categoryId) {
            super(text);
            this.categoryId = categoryId;
        }
    }

}
