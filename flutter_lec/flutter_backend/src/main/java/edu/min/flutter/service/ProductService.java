package edu.min.flutter.service;

import java.util.List;

import edu.min.flutter.domain.Product;

public interface ProductService {
  Product registProduct(Product product);
  List<Product> getProductList();
  Product getProductById(Integer id);
  Product modifyProduct(Integer id, Product product);
  void deleteProduct(Integer id);
}
