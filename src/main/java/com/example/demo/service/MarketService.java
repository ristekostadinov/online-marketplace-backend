package com.example.demo.service;

import com.example.demo.model.Market;
import com.example.demo.model.Place;
import com.example.demo.model.exception.MarketNotFoundException;
import com.example.demo.model.requests.MarketRequest;
import com.example.demo.repository.MarketRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class MarketService {
    private final MarketRepository marketRepository;
    private final PlaceService placeService;

    public MarketService(MarketRepository marketRepository, PlaceService placeService){
        this.marketRepository = marketRepository;
        this.placeService = placeService;
    }

    @Transactional
    public Market save(MarketRequest marketRequest){
        Market market = new Market();
        Place place = this.placeService.findById(marketRequest.getPlaceId());
        market.setName(marketRequest.getName());
        market.setPlace(place);
        return this.marketRepository.save(market);
    }

    public Market findById(Long id){
        return this.marketRepository.findById(id).orElseThrow(() -> new MarketNotFoundException("The market id doesnt exist in the database"));
    }

    public List<Market> findAll(){
        return this.marketRepository.findAll();
    }

    @Transactional
    public void delete(Long id){
        Market market = this.findById(id);
        this.marketRepository.delete(market);
    }

    @Transactional
    public Market editMarket(Long id, MarketRequest marketRequest){
        Market market = this.findById(id);
        Place place = this.placeService.findById(marketRequest.getPlaceId());
        market.setName(marketRequest.getName());
        market.setPlace(place);
        return this.marketRepository.save(market);
    }
}
