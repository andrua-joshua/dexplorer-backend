package com.dhotels.hotelsbackend.repositories;

import com.dhotels.hotelsbackend.modules.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CurrencyRepository extends JpaRepository<Currency, Integer> {

    abstract public Optional<Currency> findByCurrencySymbol(String symbol);
    abstract public Optional<Currency> findByCountry(String country);
}
