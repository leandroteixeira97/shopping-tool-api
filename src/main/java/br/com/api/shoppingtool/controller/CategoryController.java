package br.com.api.shoppingtool.controller;

import br.com.api.shoppingtool.model.entity.Category;
import br.com.api.shoppingtool.model.record.CategoryDTO;
import br.com.api.shoppingtool.service.CategoryService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    @RequestMapping(path = "/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable(value = "id") Integer id) {
        Category category = categoryService.findById(id);

        return ResponseEntity.ok(category);
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryService.findAll();

        return ResponseEntity.ok(categories);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Category> createCategory(@RequestBody @Valid CategoryDTO categoryDTO) {
        Category category = categoryService.createCategory(categoryDTO);

        return ResponseEntity.ok(category);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Category> updateCategory(@RequestBody @Valid Category category) {
        Category updatedCategory = categoryService.updateCategory(category);

        return ResponseEntity.ok(updatedCategory);
    }

    @DeleteMapping
    @RequestMapping(path = "/delete/{id}")
    @Transactional
    public ResponseEntity<String> deleteCategory(@PathVariable(value = "id") Integer id) {
        categoryService.deleteCategory(id);

        return ResponseEntity.ok("Deleted category of id: " + id);
    }
}
