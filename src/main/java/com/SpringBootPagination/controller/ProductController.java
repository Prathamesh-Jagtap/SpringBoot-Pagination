package com.SpringBootPagination.controller;
import com.SpringBootPagination.entity.Product;
import com.SpringBootPagination.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Product> save(Product product){
        return ResponseEntity.ok(productService.save(product));
    }

    @GetMapping
    public ResponseEntity<Page<Product>> getPaginatedProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(productService.getAllProducts(page, size));
    }
}
