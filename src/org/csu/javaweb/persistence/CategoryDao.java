package org.csu.javaweb.persistence;

        import java.util.List;

        import org.csu.javaweb.domain.Category;

public interface CategoryDao {

    List<Category> getCategoryList();

    Category getCategory(String categoryId);

}
