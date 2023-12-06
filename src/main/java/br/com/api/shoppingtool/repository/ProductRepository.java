package br.com.api.shoppingtool.repository;

import br.com.api.shoppingtool.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    public List<Product> findAllByOrderByIdAsc();
}
