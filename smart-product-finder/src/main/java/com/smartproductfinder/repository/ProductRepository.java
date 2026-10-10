
package com.smartproductfinder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartproductfinder.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByNameContainingIgnoreCase(String name);

    List<Product> findByNameContainingIgnoreCaseOrBrandContainingIgnoreCase(
            String name, String brand);

    List<Product> findByCategoryIgnoreCase(String category);

    // Price range filter
    List<Product> findByPriceBetween(Double minPrice, Double maxPrice);

    // Sort prices
    List<Product> findAllByOrderByPriceAsc();

    List<Product> findAllByOrderByPriceDesc();
}
