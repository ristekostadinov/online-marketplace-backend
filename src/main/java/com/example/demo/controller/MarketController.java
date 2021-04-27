package com.example.demo.controller;
import com.example.demo.model.Market;
import com.example.demo.model.requests.MarketRequest;
import com.example.demo.service.MarketService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/api/markets")
public class MarketController {
    private final MarketService marketService;

    public MarketController(MarketService marketService){
        this.marketService = marketService;
    }

    @GetMapping(value = "/{id}")
    public Market showMarket(@PathVariable(value = "id") Long id){
        return this.marketService.findById(id);
    }

    @GetMapping(value = "")
    public List<Market> listMarkets(){
        return this.marketService.findAll();
    }

    @PostMapping(value = "")
    public Market createMarket(@RequestBody MarketRequest marketRequest){
        return this.marketService.save(marketRequest);
    }

    @PutMapping(value = "/{id}")
    public void editMarket(@PathVariable("id") Long id, @RequestBody MarketRequest marketRequest){
        this.marketService.editMarket(id, marketRequest);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteMarket(@PathVariable("id") Long id){
        this.marketService.delete(id);
    }

}
