package com.example.stockbroker.controller;
import com.example.stockbroker.dao.userStockRepository;
import com.example.stockbroker.dao.stocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class stockController {

    @Autowired
    private userStockRepository userStocksRepo;

    @RequestMapping(value="getUserStocks",method = RequestMethod.POST,produces = {"application/json"})
    public List<stocks> getStocks(@RequestBody stocks stockData) {
        List<stocks> userStockData = userStocksRepo.findStockByEmail(stockData.getEmail());
        return userStockData;

    }

    @RequestMapping(value="updateUserStocks",method = RequestMethod.POST,produces = {"application/json"})
    public String updateStocks(@RequestBody stocks stockData) {
        try {
            if (stockData.getQuantity() == 0) {
                userStocksRepo.delete(stockData);

            } else {
                userStocksRepo.save(stockData);
            }
            return "sucessful";
        }
        catch (Exception e)
        {
            return e.toString();
        }
    }
}
