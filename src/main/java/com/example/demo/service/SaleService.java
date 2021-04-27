package com.example.demo.service;

import com.example.demo.model.Item;
import com.example.demo.model.Market;
import com.example.demo.model.Sale;
import com.example.demo.model.enumeration.Status;
import com.example.demo.model.exception.SaleNotFoundException;
import com.example.demo.model.requests.SaleRequest;
import com.example.demo.repository.SaleRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class SaleService {
    private final SaleRepository saleRepository;
    private final MarketService marketService;
    private final ItemService itemService;

    public SaleService(SaleRepository saleRepository, MarketService marketService, ItemService itemService){
        this.saleRepository = saleRepository;
        this.itemService = itemService;
        this.marketService = marketService;
    }

    public List<Sale> findAll(){
        return this.saleRepository.findAll();
    }

    public Sale findById(Long id){
        return this.saleRepository.findById(id).orElseThrow(()-> new SaleNotFoundException("Sale id doesn't exist in the database"));
    }

    @Transactional
    public Sale delete(Long id){
        Sale sale = this.findById(id);
        this.saleRepository.delete(sale);
        return sale;
    }

    @Transactional
    public Sale save(SaleRequest saleRequest){
        Sale sale = new Sale();
        Status status = Status.ACTIVE;
        Market market = this.marketService.findById(saleRequest.getMarketId());
        Item item = this.itemService.findById(saleRequest.getItemId());

        sale.setStatus(status);
        sale.setStartDate(saleRequest.getStartDate());
        sale.setEndDate(saleRequest.getEndDate());
        sale.setMarket(market);


        sale.setItem(item);

        return this.saleRepository.save(sale);
    }

    @Transactional
    public Sale edit(Long id, SaleRequest saleRequest){
        Sale sale = this.findById(id);
        Market market = this.marketService.findById(saleRequest.getMarketId());
        Item item = this.itemService.findById(saleRequest.getItemId());
        sale.setStatus(saleRequest.getStatus());
        sale.setStartDate(saleRequest.getStartDate());
        sale.setEndDate(saleRequest.getEndDate());
        sale.setMarket(market);
        sale.setItem(item);

        return this.saleRepository.save(sale);
    }
}
