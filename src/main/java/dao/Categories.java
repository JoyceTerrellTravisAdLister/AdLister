package dao;

import models.Category;

import java.util.List;

public interface Categories {
    List<Category> getAll();
    List<Category> getCategoriesByAdId(long id);
    Category getCategoryById(long id);
    long insert(Category categoryToInsert);
    void assignCategoryToAd(long category_id, long ad_id);
}
