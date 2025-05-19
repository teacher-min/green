package edu.min.flutter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.min.flutter.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
