package uk.co.demo.resource;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uk.co.demo.entity.Product;
import uk.co.demo.service.ProductService;

/**
 * This is essentially where all of the application will expose some very small
 * & concise API related to the products.
 *
 * @date 09/06/2020
 * @since 1.0.0
 * @author jo3-w3b-d3v
 */
@RestController
@RequestMapping("/products")
public class ProductResource {
	
	@Autowired
	private ProductService service;

    /**
     * This will return a list of products.
     *
     * @since 1.0.0
     * @return ResponseEntity<List<Product>>
     */
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> products() {
        return ResponseEntity.ok(service.findAll());
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
    public ResponseEntity<String> createProducts(@RequestBody Product product) {
    	service.insert(product);
    	return new ResponseEntity<String>("Created successfully", CREATED);
    }
}
