package org.tkdgus.springbatch5demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tkdgus.springbatch5demo.entity.Product;

public interface ProductRepository extends JpaRepository<Product, String> {
}
