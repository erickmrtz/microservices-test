package me.erickmrtz.item.service.impl;

import me.erickmrtz.item.client.ProductClient;
import me.erickmrtz.item.model.Item;
import me.erickmrtz.item.service.ItemService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceFeign implements ItemService {

    private final ProductClient productClient;

    public ItemServiceFeign(ProductClient productClient) {
        this.productClient = productClient;
    }

    @Override
    public List<Item> findAll() {
        return productClient
                .listAllProducts()
                .getMessage()
                .stream()
                .map(product -> new Item(product, 1))
                .collect(Collectors.toList());
    }

    @Override
    public Item findOne(Long id, Integer quantity) {
        return new Item(productClient.listOneProduct(id).getMessage(), quantity);
    }
}
