package br.com.api.shoppingtool.repository;

import br.com.api.shoppingtool.model.entity.Category;
import br.com.api.shoppingtool.model.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    public List<Category> findAllByOrderByIdAsc();
}
