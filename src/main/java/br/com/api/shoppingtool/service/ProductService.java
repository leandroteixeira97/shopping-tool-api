package br.com.api.shoppingtool.service;

import br.com.api.shoppingtool.model.entity.Product;
import br.com.api.shoppingtool.model.exception.ResourceNotFoundException;
import br.com.api.shoppingtool.model.record.ProductDTO;
import br.com.api.shoppingtool.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product findById(Integer id) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isPresent()) return optionalProduct.get();

        throw new ResourceNotFoundException("No product was found to the given id: " + id);
    }

    public List<Product> findAll() {
        return productRepository.findAllByOrderByIdAsc();
    }

    public Product createProduct(ProductDTO productDTO) {
        Product product = new Product(productDTO.name(), productDTO.subCategoryId());
        return productRepository.save(product);
    }

    public Product updateProduct(Product product) {
        Product productToBeUpdated = findById(product.getId());

        productToBeUpdated.setName(product.getName());

        return productToBeUpdated;
    }

    public void deleteProduct(Integer id) {
        Product productToBeDeleted = findById(id);

        productRepository.delete(productToBeDeleted);
    }
}
