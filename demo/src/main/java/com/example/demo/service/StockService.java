package com.example.demo.service;

import com.example.demo.entity.StockEntity;
import com.example.demo.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public List<StockEntity> getStocks(){
        return stockRepository.findAll();
    }

    public List<StockEntity> getartist(String artist){
        return stockRepository.findByartist(artist);
    }

    public List<StockEntity> getdata(int id){
        return stockRepository.findByrrank(id);
    }
//    public StockEntity getStock(Integer rrank){
//        return stockRepository.getById(rrank);
//    }

}
