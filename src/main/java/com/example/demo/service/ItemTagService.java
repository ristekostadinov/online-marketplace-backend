package com.example.demo.service;

import com.example.demo.model.Item;
import com.example.demo.model.ItemTag;
import com.example.demo.model.Tag;
import com.example.demo.model.exception.ItemTagNotFoundException;
import com.example.demo.model.requests.ItemTagRequest;
import com.example.demo.repository.ItemTagRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ItemTagService {
    private final ItemTagRepository itemTagRepository;
    private final ItemService itemService;
    private final TagService tagService;


    public ItemTagService(ItemTagRepository itemTagRepository, ItemService itemService, TagService tagService){
        this.itemTagRepository = itemTagRepository;
        this.itemService = itemService;
        this.tagService = tagService;
    }

    public List<ItemTag> findAll(){
        return this.itemTagRepository.findAll();
    }

    public ItemTag findById(Long id){
        return this.itemTagRepository.findById(id).orElseThrow(()-> new ItemTagNotFoundException("Item tag id doesn't exist in the database"));
    }

    @Transactional
    public ItemTag save(ItemTagRequest itemTagRequest){
        ItemTag itemTag = new ItemTag();
        Item item = this.itemService.findById(itemTagRequest.getItemId());
        Tag tag = this.tagService.findById(itemTagRequest.getTagId());

        itemTag.setItem(item);
        itemTag.setTag(tag);

        return this.itemTagRepository.save(itemTag);
    }

    @Transactional
    public ItemTag edit(Long id, ItemTagRequest itemTagRequest){
        ItemTag itemTag = this.findById(id);
        Item item = this.itemService.findById(itemTagRequest.getItemId());
        Tag tag = this.tagService.findById(itemTagRequest.getTagId());

        itemTag.setItem(item);
        itemTag.setTag(tag);

        return this.itemTagRepository.save(itemTag);
    }

    @Transactional
    public ItemTag delete(Long id){
        ItemTag itemTag = this.findById(id);
        this.itemTagRepository.delete(itemTag);
        return itemTag;
    }
}
