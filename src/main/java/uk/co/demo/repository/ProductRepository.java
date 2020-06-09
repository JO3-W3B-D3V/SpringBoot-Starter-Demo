package uk.co.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uk.co.demo.entity.Product;

/**
 * This is a repository to retrieve information regarding
 * products.
 *
 * @date 09/06/2020
 * @since 1.0.0
 * @author jo3-w3b-d3v
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    // Do nothing... At least for now.
}