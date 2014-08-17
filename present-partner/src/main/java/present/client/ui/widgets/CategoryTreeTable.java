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

    class CategoryItem extends TreeItem {
        public int categoryId;
    }

    public void fillTree(Category rootCategory) {
        clear();
        fillBranch(rootCategory, null);

    }

    private void fillBranch(Category currentCategory, CategoryItem parentItem) {
        CategoryItem currentItem;
        if (parentItem == null) {
            currentItem = (CategoryItem)addItem(new Label(currentCategory.getTitle()));
            currentItem.categoryId = currentCategory.getId();
            for (Category nextCurrentCategory : currentCategory.getChildren()) {
                fillBranch(nextCurrentCategory, currentItem);
            }
        }
        else {
            currentItem = (CategoryItem)parentItem.addItem(new Label(currentCategory.getTitle()));
            currentItem.categoryId = currentCategory.getId();
            for (Category nextRootCategory : currentCategory.getChildren()) {
                fillBranch(nextRootCategory, currentItem);
            }

        }
    }

}
