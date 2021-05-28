package com.example.TraderApi.Services;

import com.example.TraderApi.Entities.Trader;
import com.example.TraderApi.Repositories.TraderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TraderService {

    private final TraderRepository traderRepository;

    @Autowired
    public TraderService(TraderRepository traderRepository) {
        this.traderRepository = traderRepository;
    }

    public List<Trader> getTraders() {
        return traderRepository.findAll();
    }

    public void addNewTrader(Trader trader) {
        Optional<Trader> traderByCity = traderRepository.findTraderByCity(trader.getCity());
        if(!traderByCity.isPresent()){
            traderRepository.save(trader);
        }
    }

    public void deleteTrader(Long id) {
        boolean b = traderRepository.existsById(id);
        if(b){
            traderRepository.deleteById(id);
        }
    }

    @Transactional
    public void updateTrader(Long id, String name, String city) {
        Trader trader = traderRepository.findTraderById(id);

        if(name != null && name.length()>0 && !Objects.equals(trader.getName(),name)){
            trader.setName(name);
        }

    }
}
