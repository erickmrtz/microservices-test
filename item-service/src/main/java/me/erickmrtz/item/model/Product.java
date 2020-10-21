package me.erickmrtz.item.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Product implements Serializable {

    private Long id;
    private String name;
    private Double price;
    private Date createdAt;
}
