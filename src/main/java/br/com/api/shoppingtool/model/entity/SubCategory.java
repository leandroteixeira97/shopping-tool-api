package br.com.api.shoppingtool.model.entity;

import jakarta.persistence.*;

@Entity(name = "SubCategory")
@Table(name = "sub_category")
public class SubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(name = "category_id")
    private Integer categoryId;

    public SubCategory() {

    }

    public SubCategory(String name) {
        this.name = name;
    }

    public SubCategory(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public SubCategory(String name, Integer categoryId) {
        this.name = name;
        this.categoryId = categoryId;
    }

    public SubCategory(Integer id, String name, Integer categoryId) {
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;
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

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}
