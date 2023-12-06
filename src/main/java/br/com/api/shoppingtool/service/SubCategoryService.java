package br.com.api.shoppingtool.service;

import br.com.api.shoppingtool.model.entity.SubCategory;
import br.com.api.shoppingtool.model.exception.ResourceNotFoundException;
import br.com.api.shoppingtool.model.record.SubCategoryDTO;
import br.com.api.shoppingtool.repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubCategoryService {

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    public SubCategory findById(Integer id) {
        Optional<SubCategory> optionalSubCategory = subCategoryRepository.findById(id);

        if (optionalSubCategory.isPresent()) return optionalSubCategory.get();

        throw new ResourceNotFoundException("No Sub Category was found to the given id: " + id);
    }

    public List<SubCategory> findAll() {
        return subCategoryRepository.findAllByOrderByIdAsc();
    }

    public SubCategory createSubCategory(SubCategoryDTO subCategoryDTO) {
        SubCategory subCategory = new SubCategory(subCategoryDTO.name(), subCategoryDTO.categoryId());
        return subCategoryRepository.save(subCategory);
    }

    public SubCategory updateSubCategory(SubCategory subCategory) {
        SubCategory subCategoryToBeUpdated = findById(subCategory.getId());

        subCategoryToBeUpdated.setName(subCategory.getName());

        return subCategoryToBeUpdated;
    }

    public void deleteCategory(Integer id) {
        SubCategory categoryToBeDeleted = findById(id);

        subCategoryRepository.delete(categoryToBeDeleted);
    }
}
