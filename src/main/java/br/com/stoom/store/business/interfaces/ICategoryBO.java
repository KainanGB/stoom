package br.com.stoom.store.business.interfaces;

import br.com.stoom.store.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryBO {
    Page<Category> getAllCategories(boolean active, String name, Pageable pageable);
    Category getCategoryById(Long id);
    Category createCategory(Category category);
    Category updateCategory(Long id, Category category);
    void deleteCategory(Long id);
    void deactivateCategory(Long categoryId);
    void activateCategory(Long categoryId);
}