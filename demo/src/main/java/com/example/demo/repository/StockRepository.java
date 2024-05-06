package com.example.demo.repository;

import com.example.demo.entity.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockRepository extends JpaRepository<StockEntity, Integer> {

    List<StockEntity> findByartist(String artist);

    List<StockEntity> findByrrank(int rrank);
//    public List<StockDTO> findByNAME(String Name);
//
//    public List<StockDTO> findByartist(String artist);
//
//    public List<StockDTO> findByrrank(int rrank);
//
//    public List<StockDTO> findByartistLike(String keyword);

}
