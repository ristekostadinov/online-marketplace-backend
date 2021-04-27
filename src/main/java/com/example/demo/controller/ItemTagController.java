package com.example.demo.controller;
import com.example.demo.model.ItemTag;
import com.example.demo.model.requests.ItemRequest;
import com.example.demo.model.requests.ItemTagRequest;
import com.example.demo.service.ItemTagService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/item-tags")
public class ItemTagController {
    private final ItemTagService itemTagService;

    public ItemTagController(ItemTagService itemTagService){
        this.itemTagService = itemTagService;
    }

    @GetMapping()
    public List<ItemTag> listItemTags(){
        return this.itemTagService.findAll();
    }

    @GetMapping(value = "/{id}")
    public ItemTag showItemTag(@PathVariable(value = "id") Long id){
        return this.itemTagService.findById(id);
    }

    @PostMapping()
    public ItemTag createItemTag(ItemTagRequest itemTagRequest){
        return this.itemTagService.save(itemTagRequest);
    }

    @PutMapping(value = "/{id}")
    public ItemTag editItemTag(@PathVariable(value = "id") Long id, @RequestBody ItemTagRequest itemTagRequest){
        return this.itemTagService.edit(id, itemTagRequest);
    }

    @DeleteMapping(value = "/{id}")
    public ItemTag deleteItemTag(@PathVariable(value = "id") Long id){
        return this.itemTagService.delete(id);
    }
}
