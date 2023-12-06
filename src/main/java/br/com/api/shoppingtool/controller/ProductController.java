package br.com.api.shoppingtool.controller;

import br.com.api.shoppingtool.model.entity.Product;
import br.com.api.shoppingtool.model.record.ProductDTO;
import br.com.api.shoppingtool.service.ProductService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    @RequestMapping(path = "/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable(value = "id") Integer id) {
        Product product = productService.findById(id);

        return ResponseEntity.ok(product);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.findAll();

        return ResponseEntity.ok(products);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Product> createProduct(@RequestBody @Valid ProductDTO productDTO) {
        Product product = productService.createProduct(productDTO);

        return ResponseEntity.ok(product);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Product> updateProduct(@RequestBody @Valid Product product) {
        Product updatedProduct = productService.updateProduct(product);

        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping
    @RequestMapping(path = "/delete/{id}")
    @Transactional
    public ResponseEntity<String> deleteProduct(@PathVariable(value = "id") Integer id) {
        productService.deleteProduct(id);

        return ResponseEntity.ok("Deleted product of id: " + id);
    }
}
