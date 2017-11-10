package com.spring.stock.serviceinterface;

public interface IStockService {
    public Boolean updateByCode(String code);
    public Boolean insertByRange(String type,int begin,int end);
}
