package com.example.Thawaq.Controller;

import com.example.Thawaq.Api.ApiResponse;
import com.example.Thawaq.Model.Category;
import com.example.Thawaq.Service.CategoryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/category")
@AllArgsConstructor
public class CategoryController {
    private CategoryService categoryService;

    @GetMapping("/get")
    public ResponseEntity getAllCategory() {
        return ResponseEntity.status(200).body(categoryService.getAllCategories());
    }

    @PostMapping("/add")
    public ResponseEntity addCategory(@RequestBody Category category) {
        categoryService.addCategory(category);
        return ResponseEntity.status(200).body("category added successfully");
    }

    @PutMapping("/update/{cId}")
    public ResponseEntity updateCategory(@PathVariable Integer cId,@Valid @RequestBody Category category) {
        categoryService.updateCategory(category,cId);
        return ResponseEntity.status(200).body("category updated successfully");
    }

    @DeleteMapping("/delete/{cId}")
    public ResponseEntity deleteCategory(@PathVariable Integer cId) {
        categoryService.deleteCategory(cId);
        return ResponseEntity.status(200).body("category deleted successfully");
    }

    //Discount by category name (Jana) v2
    @PutMapping("/apply-discount/{categoryName}/{discountPercentage}")
    public ResponseEntity applyDiscountToCategoryByName(@PathVariable String categoryName,@PathVariable double discountPercentage){
        categoryService.applyDiscountToCategoryByName(categoryName,discountPercentage);
        return ResponseEntity.status(200).body(new ApiResponse("Successfully applied discount to "+categoryName));}
}