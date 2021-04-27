package com.example.demo.controller;
import com.example.demo.model.Sale;
import com.example.demo.model.enumeration.Status;
import com.example.demo.model.requests.SaleRequest;
import com.example.demo.service.SaleService;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;


@RestController
@RequestMapping(value = "/api/sales")
public class SaleController {
    private final SaleService saleService;

    public SaleController(SaleService saleService){
        this.saleService = saleService;
    }

    @DeleteMapping("/{id}")
    public Sale deleteSale(@PathVariable(value = "id") Long id){
        return this.saleService.delete(id);
    }

    @GetMapping()
    public List<Sale> listSales(){
        return this.saleService.findAll();
    }

    @GetMapping("/{id}")
    public Sale showSale(@PathVariable(value = "id") Long id){
        return this.saleService.findById(id);
    }

    @PostMapping()
    public Sale createSale(SaleRequest saleRequest){
        return this.saleService.save(saleRequest);
    }

    @PostMapping(value = "/{id}")
    public Sale editSale(@PathVariable(value = "id") Long id, @RequestBody SaleRequest saleRequest){
        return this.saleService.edit(id, saleRequest);
    }
}
