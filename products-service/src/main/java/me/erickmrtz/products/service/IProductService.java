package me.erickmrtz.products.service;

import me.erickmrtz.products.model.Product;

import java.util.List;

public interface IProductService {

    List<Product> findAll();
    Product findOne(Long id);
}
