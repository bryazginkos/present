import org.junit.Before;
import org.junit.Test;
import present.entity.Category;
import present.server.util.DTOConverter;

import java.util.Arrays;

/**
 * Created by Kos on 17.08.2014.
 */
public class DTOConverterTest {
    Category parentCategory;
    Category childCategory1;
    Category childCategory2;
    Category grandSonCategory;
    
    
    @Before
    public void prepareCategories() {
        parentCategory = new Category();
        childCategory1 = new Category();
        childCategory2 = new Category();
        grandSonCategory = new Category();

        parentCategory.setTitle("Parent");
        parentCategory.setDescription("Parent description");
        parentCategory.setId(1);

        childCategory1.setTitle("Child1");
        childCategory1.setDescription("Child1 description");
        childCategory1.setId(2);

        childCategory2.setTitle("Title2");
        childCategory2.setDescription("Child2 description");
        childCategory2.setId(3);

        grandSonCategory.setTitle("GrandSon title");
        grandSonCategory.setDescription("GrandSon description");
        grandSonCategory.setId(4);

        parentCategory.setChildren(Arrays.asList(childCategory1, childCategory2));
        childCategory1.setParent(parentCategory);
        childCategory2.setParent(parentCategory);
        grandSonCategory.setParent(childCategory1);
        childCategory1.setChildren(Arrays.asList(grandSonCategory));       
    }

    @Test
    public void simpleCategoryTest() {
        present.client.dto.Category dtoCategory;     
        dtoCategory = DTOConverter.toCategoryDto(childCategory1);
        assertEqualsCategories(dtoCategory, childCategory1);
        assert dtoCategory.getParent() == null;
        assert dtoCategory.getChildren() == null;
    }


    @Test
    public void allTreeCategoryTest(){
        present.client.dto.Category parentDtoCategory = DTOConverter.toCategoryDTOWithChildren(parentCategory);
        assertEqualsCategories(parentDtoCategory, parentCategory);
        assert parentDtoCategory.getChildren().size() == 2;
        for (present.client.dto.Category childDtoCategory : parentDtoCategory.getChildren()) {
            Integer childId = childDtoCategory.getId();
            assert childId ==2 || childId == 3;
            if (childId == 2) {
                assertEqualsCategories(childDtoCategory, childCategory1);
                assert childDtoCategory.getParent() == parentDtoCategory;
                assert childDtoCategory.getChildren().size() == 1;
                present.client.dto.Category grandSonDtoCategory = childDtoCategory.getChildren().get(0);
                assertEqualsCategories(grandSonDtoCategory, grandSonCategory);
                assert grandSonDtoCategory.getChildren() == null;
                assert grandSonDtoCategory.getParent() == childDtoCategory;
            }
            if (childId == 3) {
                assertEqualsCategories(childDtoCategory, childCategory2);
                assert childDtoCategory.getParent() == parentDtoCategory;
                assert childDtoCategory.getChildren() == null;
            }
        }
    }

    private void assertEqualsCategories(present.client.dto.Category dtoCategory, Category category){
        assert category.getId().equals(dtoCategory.getId());
        assert category.getTitle().equals(dtoCategory.getTitle());
        assert category.getDescription().equals(dtoCategory.getDescription());
    }
}
