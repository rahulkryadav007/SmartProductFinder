
package com.smartproductfinder.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smartproductfinder.entity.Product;
import com.smartproductfinder.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Get all products
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // Search products by category
    @GetMapping("/search")
    public List<Product> searchByCategory(
            @RequestParam("category") String category) {
        return productService.searchByCategory(category);
    }

    // Get cheapest product
    @GetMapping("/cheapest")
    public Product getCheapestProduct() {
        return productService.getCheapestProduct();
    }

    // Search products by name or brand
    @GetMapping("/name")
    public List<Product> searchByName(
            @RequestParam("name") String name) {
        return productService.searchByName(name);
    }

    // Filter products by price range
    @GetMapping("/price")
    public List<Product> filterByPrice(
            @RequestParam("min") Double min,
            @RequestParam("max") Double max) {
        return productService.filterByPrice(min, max);
    }

    // Sort prices: Low to High
    @GetMapping("/sort/low-to-high")
    public List<Product> sortLowToHigh() {
        return productService.sortByPriceLowToHigh();
    }

    // Sort prices: High to Low
    @GetMapping("/sort/high-to-low")
    public List<Product> sortHighToLow() {
        return productService.sortByPriceHighToLow();
    }
}
