package com.example.demo.controller;
import com.example.demo.model.Tag;
import com.example.demo.model.requests.TagRequest;
import com.example.demo.service.TagService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/api/tags")
public class TagController {
    private final TagService tagService;

    public TagController(TagService tagService){
        this.tagService = tagService;
    }

    @GetMapping(value = "")
    public List<Tag> listTags(){
        return this.tagService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Tag showTag(@PathVariable(value = "id") Long id){
        return this.tagService.findById(id);
    }

    @PostMapping(value = "")
    public Tag createTag(@RequestBody TagRequest tagRequest){
        return this.tagService.save(tagRequest);
    }

    @PutMapping(value = "/{id}")
    public Tag editTag(@PathVariable(value = "id") Long id, @RequestBody TagRequest tagRequest){
        return this.tagService.edit(id, tagRequest);
    }

    @DeleteMapping(value = "/{id}")
    public Tag deleteTag(@PathVariable(value = "id") Long id){
        return this.tagService.delete(id);
    }
}
