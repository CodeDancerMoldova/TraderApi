package com.example.TraderApi.Repositories;

import com.example.TraderApi.Entities.Trader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TraderRepository extends JpaRepository<Trader,Long> {

    Optional<Trader> findTraderByCity(String city);
    Trader findTraderById(Long id);
}
