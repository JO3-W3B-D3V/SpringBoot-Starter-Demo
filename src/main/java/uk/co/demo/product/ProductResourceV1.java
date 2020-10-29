package uk.co.demo.product;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is essentially where all of the application will expose some very small
 * & concise API related to the products.
 *
 * @date 09/06/2020
 * @since 1.0.0
 * @author jo3-w3b-d3v
 */
@RestController
@RequestMapping("/v1/products")
public class ProductResourceV1 {
	
	@Autowired
	private ProductService service;

    /**
     * This will return a list of products.
     *
     * @since 1.0.0
     * @return ResponseEntity<List<Product>>
     */
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> products(@RequestParam(value = "page", required = false) Integer page) {
		return Optional.ofNullable(page)
			.map(x -> ResponseEntity.ok(service.findPage(page)))
			.orElseGet(() -> ResponseEntity.ok(service.findFirstTen()));
    }
    
    /**
     * This will return a specific product.
     *
     * @since 1.0.0
     * @return ResponseEntity<Product>
     */
    @GetMapping("/{id}")
    public ResponseEntity<Product> productsDetail(@PathVariable Integer id) {
    	return ResponseEntity.ok(service.findById(id));
    }
    
    /**
     * This will create & add a product to the database. 
     * 
     *  @since 1.0.0
     *  @return ResponseEntity<String>
     */
    @PostMapping(produces = TEXT_PLAIN_VALUE, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createProduct(@RequestBody Product product) {
    	service.insert(product);
    	return new ResponseEntity<String>("Created successfully", CREATED);
    }
    
    /**
     * This will update a product. 
     * 
     * @since 1.0.0
     * @return ResponseEntity<String>
     */
    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable Integer id, @RequestBody Product product) {
    	// TODO ... 
    	return null;
    }
    
    /**
     * This will delete a product.
     * 
     * @since 1.0.0 
     * @return ResponseEntity<String>
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Integer id) {
    	// TODO ... 
    	return null;
    }
}
