package com.ecommerce.sb_ecom.controller;


import com.ecommerce.sb_ecom.model.Category;
import com.ecommerce.sb_ecom.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


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
    public ResponseEntity<List<Category>> getCategoryList() {

        List<Category> categories = categoryService.getCategory();

       return new ResponseEntity<>(categories,HttpStatus.OK);
    }

    @PostMapping("/api/public/createCategory")
    public ResponseEntity<String> createCategory(@RequestBody Category category) {

        categoryService.createCategory(category);
        return new ResponseEntity<>(" Category created Successfully ",HttpStatus.CREATED);

    }


    @DeleteMapping("/api/admin/deleteCategory/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId) {
        try {
            String statusCode = categoryService.deleteCategory(categoryId);
             return new ResponseEntity<>(statusCode, HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }

    }

    @PutMapping("api/public/categories/{categoryId}")
    public ResponseEntity<String> updateCategory(@RequestBody Category category,
                                                 @PathVariable Long categoryId) {
        try {
            Category savedCategory = categoryService.updateCategory(category, categoryId);
            return new ResponseEntity<>("Category with category id: " + categoryId, HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }

    }
}
