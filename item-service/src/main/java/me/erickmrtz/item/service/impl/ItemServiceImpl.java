package me.erickmrtz.item.service.impl;

import me.erickmrtz.item.model.Item;
import me.erickmrtz.item.model.Product;
import me.erickmrtz.item.service.ItemService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    private final RestTemplate restTemplate;

    public ItemServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Item> findAll() {
        List<Product> productList = Arrays.asList(restTemplate.getForObject("http://product-service/products/", Product[].class));

        return productList.stream().map(product -> new Item(product, 1)).collect(Collectors.toList());
    }

    @Override
    public Item findOne(Long id, Integer quantity) {
        Map<String, String> pathVariables = new HashMap<>();
        pathVariables.put("id", id.toString());

        Product product = restTemplate.getForObject("http://product-service/products/", Product.class);
        return null;
    }
}
