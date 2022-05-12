package io.springbatch.springbatch.batch.repository;

import io.springbatch.springbatch.batch.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
