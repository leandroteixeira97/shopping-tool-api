package br.com.api.shoppingtool.model.entity;

import jakarta.persistence.*;

@Entity(name = "Product")
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(name = "sub_category_id")
    private Integer subCategoryId;

    public Product() {

    }

    public Product(String name, Integer subCategoryId) {
        this.name = name;
        this.subCategoryId = subCategoryId;
    }

    public Product(Integer id, String name, Integer subCategoryId) {
        this.id = id;
        this.name = name;
        this.subCategoryId = subCategoryId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(Integer subCategoryId) {
        this.subCategoryId = subCategoryId;
    }
}
