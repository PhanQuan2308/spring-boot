package org.example.springframework.rescontroller_controller.practive;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private List<Product> products = new ArrayList<>(
            Arrays.asList(
                    new Product(1,"may tinh", 12),
                    new Product(2,"xe may", 10),
                    new Product(3,"xe dap", 20)
            )
    );

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable int id) {
        return products.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ProductNotFoundException("Product not found with ID: " + id));
    }

    @PostMapping
    public String createProduct(@RequestBody Product product) {
        products.add(product);
        return "product created: " + product.getName();
    }

    @PutMapping("/{id}")
    public String updateProduct(@PathVariable int id, @Valid @RequestBody Product product) {
        for (Product p : products) {
            if (p.getId() == id) {
                p.setName(product.getName());
                p.setPrice(product.getPrice());
                return "Product updated: " + product.getName();
            }
        }
        throw new ProductNotFoundException("Product not found with ID: " + id);
    }


    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable int id) {
        boolean removed = products.removeIf(p -> p.getId() == id);
        if (!removed) {
            throw new ProductNotFoundException("Product not found with ID: " + id);
        }
        return "Product deleted: " + id;
    }



}
