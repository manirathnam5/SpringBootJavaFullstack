package com.ecommerce.sb_ecom.service;

import com.ecommerce.sb_ecom.model.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CategoryServiceImpl implements CategoryService {

    List<Category> categoryList = new ArrayList<>();

    private Long nextId = 1L;

    @Override
    public List<Category> getCategory() {
        return categoryList;
    }

    @Override
    public void createCategory(Category category) {


        category.setCategoryId(nextId++);
        categoryList.add(category);
    }


    @Override
    public String deleteCategory(Long categoryId) {

        Category category = categoryList.stream()
                .filter(c -> c.getCategoryId().equals(categoryId)).findFirst()
                .orElse(null);

        if (category == null) {
            return "Category not found ";
        }

        categoryList.remove(category);

        return "Category with categoryID  : " + categoryId + " deleted successfully ";


    }

}

