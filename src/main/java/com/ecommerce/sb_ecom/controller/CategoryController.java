package com.ecommerce.sb_ecom.controller;


import com.ecommerce.sb_ecom.model.Category;
import com.ecommerce.sb_ecom.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/keelakollai")   //@requestMapping annotation is used to define base url
public class CategoryController {

    @Autowired                                  // field level dependency injection
    public CategoryService categoryService;

    // constructor level dependency injection
    /*public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }*/


    @GetMapping("/api/public/categories")
    public List<Category> getCategoryList() {
        return categoryService.getCategory();
    }


    @PostMapping("/api/public/createCategory")
    public String createCategory(@RequestBody Category category) {

        categoryService.createCategory(category);
        return " Category created Successfully ";

    }


    @DeleteMapping("/api/admin/deleteCategory/{categoryId}")
    public String createCategory(@PathVariable Long categoryId) {

        return categoryService.deleteCategory(categoryId);


    }

}
