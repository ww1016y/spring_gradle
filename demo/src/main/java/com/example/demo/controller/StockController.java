package com.example.demo.controller;

import com.example.demo.entity.StockEntity;
import com.example.demo.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")

public class StockController {

    private final StockService stockService;

    @GetMapping("list")
    public ResponseEntity<List<StockEntity>> getStocks() {

        List<StockEntity> stocks = stockService.getStocks();
        return new ResponseEntity<>(stocks, HttpStatus.OK);
    }

    @GetMapping("artist")
    public ResponseEntity<List<StockEntity>> getartist() {
        System.out.println("test");
        List<StockEntity> stocks = stockService.getartist("aespa");
        return new ResponseEntity<>(stocks, HttpStatus.OK);
    }

    @GetMapping("test")
    public ResponseEntity<List<StockEntity>> updateartist() {

        List<StockEntity> stocks = stockService.getartist("BBB");
        for (StockEntity stock : stocks){
            stock.updateArtist("AAA");
        }


        return new ResponseEntity<>(stocks, HttpStatus.OK);
    }

    @GetMapping("show")
    @Transactional
    public ResponseEntity<List<StockEntity>> getrank() {

        List<StockEntity> stocks = stockService.getdata(1);

        return new ResponseEntity<>(stocks, HttpStatus.OK);
    }

    @GetMapping("rank1")
    public ResponseEntity<List<StockEntity>> getrank1() {
        System.out.println("test");
        List<StockEntity> stocks = stockService.getdata(1);
        for (StockEntity stock : stocks){

            stock.updateArtist("EEE");
        }
        return new ResponseEntity<>(stocks, HttpStatus.OK);
    }

    @GetMapping("rank2")
    @Transactional
    public ResponseEntity<List<StockEntity>> getrank2() {

        List<StockEntity> stocks = stockService.getdata(1);


        StockEntity test = stocks.get(0);
        System.out.println(stocks.get(0));
        System.out.println(stocks.get(2));
        System.out.println(stocks.get(2));
        test.updateArtist("OOO");
//        for (StockEntity stock : stocks){
//
//            stock.updateArtist("OOO");
//        }
        return new ResponseEntity<>(stocks, HttpStatus.OK);
    }


//    private String getColumnValue(StockEntity entity, String columnName) {
//        try {
//            // 엔터티 객체의 getter 메소드 이름 구성
//            String getterMethodName = "get" + columnName.substring(0, 1).toUpperCase() + columnName.substring(1);
//
//            // getter 메소드 호출하여 해당 속성 값 반환
//            Method getterMethod = entity.getClass().getMethod(getterMethodName);
//            return (String) getterMethod.invoke(entity);
//        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
//            e.printStackTrace();
//            return null;
//        } catch (InvocationTargetException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
