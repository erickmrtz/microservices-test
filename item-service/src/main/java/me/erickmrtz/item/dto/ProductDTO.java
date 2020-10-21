package me.erickmrtz.item.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.erickmrtz.item.model.Product;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private HttpStatus status;
    private Product message;
}
