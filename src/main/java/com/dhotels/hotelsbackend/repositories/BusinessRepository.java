package com.dhotels.hotelsbackend.repositories;

import com.dhotels.hotelsbackend.modules.Business;
import com.dhotels.hotelsbackend.modules.BusinessType;
import com.dhotels.hotelsbackend.modules.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BusinessRepository extends JpaRepository<Business, Integer> {

    abstract public Optional<List<Business>> findAllByOwner(User owner);
    abstract public Optional<List<Business>> findAllByBusinessType(BusinessType businessType);

}
