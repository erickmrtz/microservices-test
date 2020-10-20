package me.erickmrtz.item.dto;

import lombok.Data;
import me.erickmrtz.item.model.Product;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
public class ProductListDTO {

    private HttpStatus status;
    private List<Product> message;
}
