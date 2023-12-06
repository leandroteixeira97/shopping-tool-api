package br.com.api.shoppingtool.service;

import br.com.api.shoppingtool.model.entity.Category;
import br.com.api.shoppingtool.model.exception.ResourceNotFoundException;
import br.com.api.shoppingtool.model.record.CategoryDTO;
import br.com.api.shoppingtool.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category findById(Integer id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);

        if (optionalCategory.isPresent()) return optionalCategory.get();

        throw new ResourceNotFoundException("No category was found to the given id: " + id);
    }

    public List<Category> findAll() {
        return categoryRepository.findAllByOrderByIdAsc();
    }

    public Category createCategory(CategoryDTO categoryDTO) {
        Category category = new Category(categoryDTO.name());
        return categoryRepository.save(category);
    }

    public Category updateCategory(Category category) {
        Category categoryToBeUpdated = findById(category.getId());

        categoryToBeUpdated.setName(category.getName());

        return categoryToBeUpdated;
    }

    public void deleteCategory(Integer id) {
        Category categoryToBeDeleted = findById(id);

        categoryRepository.delete(categoryToBeDeleted);
    }
}
