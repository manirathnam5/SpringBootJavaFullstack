package com.ecommerce.sb_ecom.controller;



import com.ecommerce.sb_ecom.model.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    private List<Category>  categoryList = new ArrayList<>();

    @GetMapping("/public/categories")
    public List<Category> getCategoryList() {
        return categoryList;
    }

}
