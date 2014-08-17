package present.server.util;

import present.client.dto.Category;

import java.util.ArrayList;

/**
 * Created by Kos on 17.08.2014.
 */
public class DTOConverter {

    /**
     * Converts to DTO Object without parent and children (null)
     * @param category
     * @return
     */
    public static Category toCategoryDto(present.entity.Category category) {
        Category dtoCategory = new Category();
        dtoCategory.setTitle(category.getTitle());
        dtoCategory.setDescription(category.getDescription());
        dtoCategory.setId(category.getId());
        return dtoCategory;

    }

    /**
     * Converts to DTO object this category and all children
     * @param category
     * @return
     */
    public static Category toCategoryDTOWithChildren(present.entity.Category category) {
        return toCategoryDto(category, null);
    }


    private static Category toCategoryDto(present.entity.Category category, Category parent) {
        Category dtoCategory = toCategoryDto(category);
        dtoCategory.setParent(parent);
        int numberChildren = category.getChildren() == null ? 0 :category.getChildren().size();
        if (numberChildren != 0) {
            dtoCategory.setChildren(new ArrayList<Category>());
            dtoCategory.setChildren(new ArrayList<Category>(numberChildren));
            for (present.entity.Category child : category.getChildren()) {
                dtoCategory.getChildren().add(toCategoryDto(child, dtoCategory));
            }
        }
        return dtoCategory;
    }
}
