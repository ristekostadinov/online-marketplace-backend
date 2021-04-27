package com.example.demo.service;

import com.example.demo.model.Subscriber;
import com.example.demo.model.exception.SubscriberNotFoundException;
import com.example.demo.model.requests.SubscriberRequest;
import com.example.demo.repository.SubscriberRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SubscriberService {
    private final SubscriberRepository subscriberRepository;

    public SubscriberService(SubscriberRepository subscriberRepository){
        this.subscriberRepository = subscriberRepository;
    }

    public List<Subscriber> findAll(){
        return this.subscriberRepository.findAll();
    }

    public Subscriber findById(Long id){
        return this.subscriberRepository.findById(id).orElseThrow(()-> new SubscriberNotFoundException("The subscriber id doesn't exist in database"));
    }

    @Transactional
    public Subscriber save(SubscriberRequest subscriberRequest){
        Subscriber subscriber = new Subscriber();
        subscriber.setFirstName(subscriberRequest.getFistName());
        subscriber.setLastName(subscriberRequest.getLastName());
        subscriber.setEmail(subscriberRequest.getEmail());
        subscriber.setPhone(subscriberRequest.getPhone());
        return this.subscriberRepository.save(subscriber);
    }

    @Transactional
    public Subscriber edit(Long id, SubscriberRequest subscriberRequest){
        Subscriber subscriber = this.findById(id);
        subscriber.setFirstName(subscriberRequest.getFistName());
        subscriber.setLastName(subscriberRequest.getLastName());
        subscriber.setEmail(subscriberRequest.getEmail());
        subscriber.setPhone(subscriberRequest.getPhone());
        return this.subscriberRepository.save(subscriber);
    }

    @Transactional
    public Subscriber delete(Long id){
        Subscriber subscriber = this.findById(id);
        this.subscriberRepository.delete(subscriber);
        return subscriber;
    }
}
