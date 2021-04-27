package com.example.demo.controller;

import com.example.demo.model.Item;
import com.example.demo.model.requests.ItemRequest;
import com.example.demo.service.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/items/")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService){
        this.itemService = itemService;
    }

    @GetMapping(value = "/{id}")
    public Item showItem(@PathVariable(value = "id") Long id){
        return this.itemService.findById(id);
    }

    @GetMapping(value = "")
    public List<Item> listItems(){
        return this.itemService.findAll();
    }

    @DeleteMapping(value = "/{id}")
    public Item deleteItem(@PathVariable(value = "id") Long id){
        return this.itemService.delete(id);
    }

    @PostMapping(value = "")
    public Item createItem(@RequestBody ItemRequest itemRequest){
        return this.itemService.save(itemRequest);
    }

    @PutMapping(value = "/{id}")
    public Item editItem(@PathVariable(value = "id") Long id, @RequestBody ItemRequest itemRequest ){
        return this.itemService.edit(id, itemRequest);
    }

}
