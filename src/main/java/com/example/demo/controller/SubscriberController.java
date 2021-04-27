package com.example.demo.controller;

import com.example.demo.model.Subscriber;
import com.example.demo.model.requests.SubscriberRequest;
import com.example.demo.service.SubscriberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/subscribers")
public class SubscriberController {
    private final SubscriberService subscriberService;

    public SubscriberController(SubscriberService subscriberService){
        this.subscriberService = subscriberService;
    }

    @GetMapping(value = "")
    public List<Subscriber> listSubscribers(){
        return this.subscriberService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Subscriber showSubscriber(@PathVariable(value = "id") Long id){
        return this.subscriberService.findById(id);
    }

    @PostMapping(value = "")
    public Subscriber createSubscriber(@RequestBody SubscriberRequest subscriberRequest){
        return this.subscriberService.save(subscriberRequest);
    }

    @PutMapping(value = "/{id}")
    public Subscriber editSubscriber(@PathVariable(value = "id") Long id,@RequestBody SubscriberRequest subscriberRequest) {
        return this.subscriberService.edit(id, subscriberRequest);
    }

    @DeleteMapping(value = "/{id}")
    public Subscriber deleteSubscriber(@PathVariable(value = "id") Long id){
        return this.subscriberService.delete(id);
    }
}
