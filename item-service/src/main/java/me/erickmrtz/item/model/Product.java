package me.erickmrtz.item.model;

import lombok.Data;

import java.util.Date;

@Data
public class Product {

    private Long id;
    private String name;
    private Double price;
    private Date createdAt;
}
