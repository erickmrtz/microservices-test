package me.erickmrtz.item.client;

import me.erickmrtz.item.dto.ProductListDTO;
import me.erickmrtz.item.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service")
public interface ProductClient {

    @GetMapping("/products/")
    ProductListDTO listAllProducts();

    @GetMapping("products/{id}/")
    ProductDTO listOneProduct(@PathVariable Long id);
}
