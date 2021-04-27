package com.example.demo.service;

import com.example.demo.model.Tag;
import com.example.demo.model.exception.TagNotFoundException;
import com.example.demo.model.requests.TagRequest;
import com.example.demo.repository.TagRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TagService {
    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository){
        this.tagRepository = tagRepository;
    }

    @Transactional
    public Tag save(TagRequest tagRequest){
        Tag tag = new Tag();
        tag.setName(tagRequest.getName());
        return this.tagRepository.save(tag);
    }

    public Tag findById(Long id){
        return this.tagRepository.findById(id).orElseThrow(()-> new TagNotFoundException("This tag id doesn't exist in the database"));
    }

    public List<Tag> findAll(){
        return this.tagRepository.findAll();
    }

    @Transactional
    public Tag delete(Long id){
        Tag tag = this.findById(id);
        this.tagRepository.delete(tag);
        return tag;
    }

    @Transactional
    public Tag edit(Long id, TagRequest tagRequest){
        Tag tag = this.findById(id);
        tag.setName(tagRequest.getName());
        return this.tagRepository.save(tag);
    }
}
