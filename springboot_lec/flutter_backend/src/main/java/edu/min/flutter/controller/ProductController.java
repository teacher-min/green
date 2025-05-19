package edu.min.flutter.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.min.flutter.domain.Product;
import edu.min.flutter.service.ProductService;

@RequestMapping("/api/products")
@RestController
public class ProductController {

  private final ProductService productService;
  
  public ProductController(ProductService productService) {
    super();
    this.productService = productService;
  }

  @PostMapping(produces = "application/json; charset=utf-8")
  public Product registProduct(@RequestBody Product product) {
    return productService.registProduct(product);
  }
  
  @GetMapping(produces = "application/json; charset=utf-8")
  public List<Product> getProductList() {
    return productService.getProductList();
  }
  
  @GetMapping(value = "/{id}", produces = "application/json; charset=utf-8")
  public Product getProductById(@PathVariable Integer id) {
    return productService.getProductById(id);
  }
  
  @PutMapping(value = "/{id}", produces = "application/json; charset=utf-8")
  public Product modifyProduct(@PathVariable Integer id, @RequestBody Product product) {
    return productService.modifyProduct(id, product);
  }
  
  @DeleteMapping(value = "/{id}")
  public void deleteProduct(@PathVariable Integer id) {
    productService.deleteProduct(id);
  }
  
}
