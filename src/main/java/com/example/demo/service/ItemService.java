package com.example.demo.service;
import com.example.demo.model.Category;
import com.example.demo.model.Item;
import com.example.demo.model.exception.ItemNotFoundException;
import com.example.demo.model.requests.ItemRequest;
import com.example.demo.repository.ItemRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class ItemService {
    private final ItemRepository itemRepository;
    private final CategoryService categoryService;

    public ItemService(ItemRepository itemRepository, CategoryService categoryService){
        this.itemRepository = itemRepository;
        this.categoryService = categoryService;
    }

    public Item findById(Long id){
        return this.itemRepository.findById(id).orElseThrow(()-> new ItemNotFoundException("Item id doesn't exist in the database"));
    }

    public List<Item> findAll(){
        return this.itemRepository.findAll();
    }

    @Transactional
    public Item delete(Long id){
        Item item = this.findById(id);
        this.itemRepository.delete(item);
        return item;
    }

    @Transactional
    public Item save(ItemRequest itemRequest){
        Item item= new Item();
        Category category = this.categoryService.findById(itemRequest.getCategoryId());
        item.setName(itemRequest.getName());
        item.setOldPrice(itemRequest.getOldPrice());
        item.setSalePrice(itemRequest.getSalePrice());
        item.setCategory(category);
        return this.itemRepository.save(item);
    }

    @Transactional
    public Item edit(Long id, ItemRequest itemRequest){
        Item item = this.findById(id);
        Category category = this.categoryService.findById(itemRequest.getCategoryId());
        item.setName(itemRequest.getName());
        item.setSalePrice(itemRequest.getSalePrice());
        item.setOldPrice(itemRequest.getOldPrice());
        item.setCategory(category);
        return this.itemRepository.save(item);
    }

}
