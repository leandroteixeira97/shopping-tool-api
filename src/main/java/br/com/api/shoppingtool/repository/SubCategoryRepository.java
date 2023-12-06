package br.com.api.shoppingtool.repository;

import br.com.api.shoppingtool.model.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, Integer> {
    public List<SubCategory> findAllByOrderByIdAsc();
}
