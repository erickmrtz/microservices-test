package me.erickmrtz.products.service.impl;

import me.erickmrtz.products.model.Product;
import me.erickmrtz.products.repository.ProductRepository;
import me.erickmrtz.products.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findOne(Long id) {
        return productRepository.getOne(id);
    }
}
