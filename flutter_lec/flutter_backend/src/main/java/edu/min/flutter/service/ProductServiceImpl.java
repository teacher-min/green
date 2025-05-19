package edu.min.flutter.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.min.flutter.domain.Product;
import edu.min.flutter.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;

  public ProductServiceImpl(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }
  
  @Override
  public Product registProduct(Product product) {
    return productRepository.save(product);
  }

  @Override
  public List<Product> getProductList() {
    return productRepository.findAll();
  }

  @Override
  public Product getProductById(Integer id) {
    return productRepository.findById(id).orElseThrow();
  }

  @Override
  public Product modifyProduct(Integer id, Product product) {
    Product foundProduct = productRepository.findById(id).orElseThrow();
    foundProduct.setName(product.getName());
    foundProduct.setPrice(product.getPrice());
    foundProduct.setDescription(product.getDescription());
    return foundProduct;
  }

  @Override
  public void deleteProduct(Integer id) {
    productRepository.deleteById(id);
  }

}
