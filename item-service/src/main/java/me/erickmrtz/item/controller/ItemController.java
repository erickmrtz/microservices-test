package me.erickmrtz.item.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import me.erickmrtz.item.model.Item;
import me.erickmrtz.item.model.Product;
import me.erickmrtz.item.service.ItemService;
import me.erickmrtz.item.service.impl.ItemServiceFeign;
import me.erickmrtz.item.util.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemServiceFeign itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllItems() {
        List<Item> itemList = itemService.findAll();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ApiResponse<>(HttpStatus.OK, itemList));
    }

    @HystrixCommand(fallbackMethod = "alternativeMethod")
    @GetMapping("/{id}/quantities/{quantity}")
    public ResponseEntity<?> getOneItem(@PathVariable Long id, @PathVariable Integer quantity) {
        Item item = itemService.findOne(id, quantity);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ApiResponse<>(HttpStatus.OK, item));
    }

    public ResponseEntity<?> alternativeMethod(Long id, Integer quantity) {
        Item item = new Item();
        Product product = new Product();

        item.setQuantity(quantity);
        product.setId(id);
        product.setName("Camara Sony");
        product.setPrice(500.00);
        item.setProduct(product);

        return ResponseEntity
                .status(HttpStatus.GATEWAY_TIMEOUT)
                .body(new ApiResponse<>(HttpStatus.GATEWAY_TIMEOUT, item));
    }
}
