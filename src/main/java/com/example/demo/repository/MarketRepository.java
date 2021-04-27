package com.example.demo.repository;
import com.example.demo.model.Market;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface MarketRepository extends JpaRepository<Market, Long> {
}
