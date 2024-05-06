package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IPOinfo {
    private String company;
    private String date;
    private String finalPrice;
    private String hopePrice;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(String finalPrice) {
        this.finalPrice = finalPrice;
    }

    public String getHopePrice() {
        return hopePrice;
    }

    public void setHopePrice(String hopePrice) {
        this.hopePrice = hopePrice;
    }

    public String getStockCompanys() {
        return stockCompanys;
    }

    public void setStockCompanys(String stockCompanys) {
        this.stockCompanys = stockCompanys;
    }

    private String stockCompanys;
}