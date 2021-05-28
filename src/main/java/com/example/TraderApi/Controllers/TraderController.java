package com.example.TraderApi.Controllers;


import com.example.TraderApi.Entities.Trader;
import com.example.TraderApi.Services.TraderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trade/register")
public class TraderController {
    private  final TraderService traderService;

    @Autowired
    public TraderController(TraderService traderService) {
        this.traderService = traderService;
    }

    @GetMapping
    public List<Trader> getTraders()
    {
        return traderService.getTraders();
    }

    @PostMapping
    public void registerNewTrader(@RequestBody Trader trader){
        traderService.addNewTrader(trader);
    }

    @DeleteMapping(path = "{id}")
    public void deleteTrader(@PathVariable("id") Long id){
        traderService.deleteTrader(id);
    }


    @PutMapping("{id}")
    public void updateTrader(@PathVariable("id") Long id,
                             @RequestParam(required = false) String name,
                                     @RequestParam(required = false) String city){
        traderService.updateTrader(id,name,city);

    }
}
