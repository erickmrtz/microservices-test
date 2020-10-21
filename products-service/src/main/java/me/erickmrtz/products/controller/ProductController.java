package me.erickmrtz.products.controller;

import com.sun.jersey.core.header.MediaTypes;
import lombok.extern.slf4j.Slf4j;
import me.erickmrtz.products.model.Product;
import me.erickmrtz.products.service.IProductService;
import me.erickmrtz.products.service.impl.ProductServiceImpl;
import me.erickmrtz.products.util.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final IProductService productService;

    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> listAllProducts() {
        List<Product> productList = productService.findAll();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ApiResponse<>(HttpStatus.OK, productList));
    }

    @GetMapping(value = "/{id}/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> listOneProduct(@PathVariable Long id) {
        Product product = productService.findOne(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ApiResponse<>(HttpStatus.OK, product));
    }
}
