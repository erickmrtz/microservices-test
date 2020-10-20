package me.erickmrtz.item.service;

import me.erickmrtz.item.model.Item;

import java.util.List;

public interface ItemService {

    List<Item> findAll();
    Item findOne(Long id, Integer quantity);
}
