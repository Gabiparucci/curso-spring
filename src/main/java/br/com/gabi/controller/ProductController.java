package br.com.gabi.controller;

import br.com.gabi.model.entity.Product;
import br.com.gabi.model.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    @PostMapping
    public Product newProduct(@Valid Product product) {
        productRepository.save(product);
        return product;
    }

    @GetMapping
    public Iterable<Product> getProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/page/{page}/{count}")
    public Iterable<Product> getProductsPage(@PathVariable int page, @PathVariable int count) {
        PageRequest pageable = PageRequest.of(page, count);
        return productRepository.findAll(pageable);
    }

    @GetMapping(path = "/{id}")
    public Optional<Product> getProductById(@PathVariable int id) {
        return productRepository.findById(id);
    }

    @GetMapping(path = "/name/{name}")
    public Iterable<Product> getProductByName(@PathVariable String name) {
        return productRepository.findByNameContainingIgnoreCase(name);
    }

    @GetMapping(path = "/nameNative/{name}")
    public Iterable<Product> getProductByNameNative(@PathVariable String name) {
        return productRepository.searchNameLike(name);
    }

//    @PutMapping
//    public Product updateProduct(Product product) {
//        productRepository.save(product);
//        return product;
//    }

    @DeleteMapping(path = "/{id}")
    public void deleteProduct(@PathVariable int id) {
        productRepository.deleteById(id);
    }
}
