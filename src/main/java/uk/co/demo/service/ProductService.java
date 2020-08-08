package uk.co.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.var;
import lombok.extern.jbosslog.JBossLog;
import uk.co.demo.entity.Product;
import uk.co.demo.exception.InvalidParamProvided;
import uk.co.demo.exception.NoProductFoundException;
import uk.co.demo.repository.ProductRepository;

/**
 * This is where the business logic of the application takes place.
 *
 * @date 09/06/2020
 * @since 1.0.0
 * @author jo3-w3b-d3v
 */
@Service
@JBossLog
public class ProductService {

	@Autowired
	private ProductRepository products;

	/**
	 * This method will return a list of products.
	 *
	 * @since 1.0.0
	 * @return List<Product>
	 */
	public List<Product> findFirstTen() {
		log.info("Finding the first ten products");
		return findPage(0);
	}
	
	/**
	 * This method will return a list of products.
	 * 
	 * @since 1.0.0
	 * @param pageIndex
	 * @return List<Product>
	 */
	public List<Product> findPage(Integer pageIndex) {
		if (pageIndex == null) {
			throw new InvalidParamProvided("The page number must be provided");
		} else if (pageIndex < 0) {
			throw new InvalidParamProvided("The page number must be greater than 0");
		} 
		
		List<Product> results = products.findAll(PageRequest.of(pageIndex, 10, Sort.by(Sort.Direction.ASC, "id"))).getContent();
		Integer printableIndex = pageIndex + 1;
		
		if (results.isEmpty()) {
			throw new InvalidParamProvided("The page number provided is too large, there are no products on the page " + printableIndex);
		}
		
		log.info("Finding products on page " + printableIndex);
		return results;
	}

	/**
	 * This method will return a specific product.
	 *
	 * @since 1.0.0
	 * @param id
	 * @return Product
	 */
	public Product findById(Integer id) {
		var product = products.findById(id);

		if (product.isEmpty()) {
			throw new NoProductFoundException(id);
		} else {
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
		products.save(product);
	}
}
