package me.erickmrtz.item.dto;

import lombok.Data;
import me.erickmrtz.item.model.Product;
import org.springframework.http.HttpStatus;

@Data
public class ProductDTO {

    private HttpStatus status;
    private Product message;
}
