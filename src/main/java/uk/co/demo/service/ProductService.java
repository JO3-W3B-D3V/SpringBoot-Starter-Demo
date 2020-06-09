package uk.co.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.var;
import lombok.extern.jbosslog.JBossLog;
import uk.co.demo.entity.Product;
import uk.co.demo.exception.NoProductFoundException;
import uk.co.demo.repository.ProductRepository;

/**
 * This is where the business logic of the application takes place.
 *
 * @date 09/06/2020
 * @since 1.0.0
 * @author jo3-w3b-d3v
 */
@JBossLog
@Service
public class ProductService {

	@Autowired
	private ProductRepository products;

	/**
	 * This method will return a list of products.
	 *
	 * @since 1.0.0
	 * @return List<Product>
	 */
	public List<Product> findAll() {
		log.info("Getting all of the products from the database.");
		return products.findAll();
	}

	/**
	 * This method will return a specific product.
	 *
	 * @since 1.0.0
	 * @return Product
	 */
	public Product findById(Integer id) {
		log.info("Searching for a product with the id: " + id);
		var product = products.findById(id);

		if (product.isEmpty()) {
			log.info("No such product id was found, throwing exception.");
			throw new NoProductFoundException(id);
		} else {
			log.info("Product found.");
			return product.get();
		}
	}
	
	/**
	 * This method is used to insert a product into the database. 
	 * 
	 * @since 1.0.0
	 * @param product
	 */
	public void insert(Product product) {
		log.info("Product Info: " + product.getName() + " " + product.getDescription() + " " + product.getCost());
		products.save(product);
	}
}
