package me.erickmrtz.item.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.erickmrtz.item.model.Product;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductListDTO{

    private HttpStatus status;
    private List<Product> message;
}
