package br.com.stoom.store.controller;

import br.com.stoom.store.business.CategoryBO;
import br.com.stoom.store.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private static final Logger LOGGER = Logger.getLogger(CategoryController.class.getName());

    @Autowired
    private CategoryBO categoryService;

    @GetMapping
    public ResponseEntity<Page<Category>> getAllCategories(@RequestParam(defaultValue = "true") boolean active,
                                                           @RequestParam(required = false) String name,
                                                           @PageableDefault(size = 10) Pageable pageable) {
        LOGGER.info("Get all categories called with active: " + active + ", name: " + name + ", page: " + pageable.getPageNumber() + ", size: " + pageable.getPageSize());
        Page<Category> categories = categoryService.getAllCategories(active, name, pageable);
        if (!categories.isEmpty())
            return new ResponseEntity<>(categories, HttpStatus.OK);
        else
            return new ResponseEntity<>(categories, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        LOGGER.info("Get category by ID called with id: " + id);
        Category category = categoryService.getCategoryById(id);
        if (category != null)
            return new ResponseEntity<>(category, HttpStatus.OK);
        else
            return new ResponseEntity<>(category, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        LOGGER.info("Create category called with category: " + category);
        Category createdCategory = categoryService.createCategory(category);
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category category) {
        LOGGER.info("Update category called with id: " + id + " and category: " + category);
        Category updatedCategory = categoryService.updateCategory(id, category);
        if (updatedCategory != null)
            return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        LOGGER.info("Delete category called with id: " + id);
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
