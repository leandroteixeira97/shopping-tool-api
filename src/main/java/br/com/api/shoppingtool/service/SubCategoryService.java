package br.com.api.shoppingtool.service;

import br.com.api.shoppingtool.repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubCategoryService {

    @Autowired
    private SubCategoryRepository subCategoryRepository;
}
