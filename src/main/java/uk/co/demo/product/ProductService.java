package uk.co.demo.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.var;
import lombok.extern.jbosslog.JBossLog;

/**
 * This is where the business logic of the application takes place.
 *
 * @date 09/06/2020
 * @since 1.0.0
 * @author jo3-w3b-d3v
 */
@Service
public class ProductService {

	@Autowired
	private ProductRepository products;
	
	@Autowired 
	private ProductValidation pageValidator;

	/**
	 * This method will return a list of products.
	 *
	 * @since 1.0.0
	 * @return List<Product>
	 */
	public List<Product> findFirstTen() {
		var page = PageRequest.of(0, 10, Sort.by(Sort.Direction.ASC, "id"));
		var results = products.findAll(page).getContent();
		return results;
	}
	
	/**
	 * This method will return a list of products.
	 * 
	 * @since 1.0.0
	 * @param pageIndex
	 * @return List<Product>
	 */
	public List<Product> findPage(Integer pageIndex) {
		// Index 0 is fine, but we don't want to have a "page 0" for the consuming web application.
		var computablePageIndex = pageIndex - 1;
		pageValidator.validate(computablePageIndex);
		var page = PageRequest.of(computablePageIndex, 10, Sort.by(Sort.Direction.ASC, "id"));
		var results = products.findAll(page).getContent();
		pageValidator.validateIsNotEmpty(results, pageIndex);
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
		pageValidator.validateIsNotEmpty(product, id);
		return product.get();
	}
	
	/**
	 * This method is used to insert a product into the database. 
	 * 
	 * @since 1.0.0
	 * @param product
	 */
	public void insert(Product product) {
		// Todo... Add some validation...
		products.save(product);
	}
}
