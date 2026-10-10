
package com.smartproductfinder.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.smartproductfinder.entity.Product;
import com.smartproductfinder.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Get all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Search products by category
    public List<Product> searchByCategory(String category) {
        return productRepository.findAll()
                .stream()
                .filter(p -> p.getCategory() != null
                        && p.getCategory().equalsIgnoreCase(category))
                .toList();
    }

    // Get cheapest product
    public Product getCheapestProduct() {
        return productRepository.findAll()
                .stream()
                .filter(p -> p.getPrice() != null)
                .min(Comparator.comparing(Product::getPrice))
                .orElse(null);
    }

    // Search by product name or brand
    public List<Product> searchByName(String keyword) {
        return productRepository
                .findByNameContainingIgnoreCaseOrBrandContainingIgnoreCase(
                        keyword, keyword);
    }

    // Filter by price range
    public List<Product> filterByPrice(Double minPrice, Double maxPrice) {
        if (minPrice == null || maxPrice == null || minPrice > maxPrice) {
            throw new IllegalArgumentException(
                    "Minimum price must be less than or equal to maximum price.");
        }

        return productRepository.findByPriceBetween(minPrice, maxPrice);
    }

    // Sort: Low to High
    public List<Product> sortByPriceLowToHigh() {
        return productRepository.findAllByOrderByPriceAsc();
    }

    // Sort: High to Low
    public List<Product> sortByPriceHighToLow() {
        return productRepository.findAllByOrderByPriceDesc();
    }
}
