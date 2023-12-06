package br.com.api.shoppingtool.controller;

import br.com.api.shoppingtool.model.entity.SubCategory;
import br.com.api.shoppingtool.model.record.SubCategoryDTO;
import br.com.api.shoppingtool.service.SubCategoryService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/subCategory")
public class SubCategoryController {

    @Autowired
    private SubCategoryService subCategoryService;

    @GetMapping
    @RequestMapping(path = "/{id}")
    public ResponseEntity<SubCategory> getSubCategoryById(@PathVariable(value = "id") Integer id) {
        SubCategory subCategory = subCategoryService.findById(id);

        return ResponseEntity.ok(subCategory);
    }

    @GetMapping
    public ResponseEntity<List<SubCategory>> getAllSubCategories() {
        List<SubCategory> categories = subCategoryService.findAll();

        return ResponseEntity.ok(categories);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<SubCategory> createSubCategory(@RequestBody @Valid SubCategoryDTO subCategoryDTO) {
        SubCategory subCategory = subCategoryService.createSubCategory(subCategoryDTO);

        return ResponseEntity.ok(subCategory);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<SubCategory> updateSubCategory(@RequestBody @Valid SubCategory subCategory) {
        SubCategory updatedSubCategory = subCategoryService.updateSubCategory(subCategory);

        return ResponseEntity.ok(updatedSubCategory);
    }

    @DeleteMapping
    @RequestMapping(path = "/delete/{id}")
    @Transactional
    public ResponseEntity<String> deleteSubCategory(@PathVariable(value = "id") Integer id) {
        subCategoryService.deleteCategory(id);

        return ResponseEntity.ok("Deleted subCategory of id: " + id);
    }

}
