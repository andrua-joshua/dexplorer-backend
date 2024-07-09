package com.dhotels.hotelsbackend.repositories;

import com.dhotels.hotelsbackend.modules.PackagingType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackageTypeRepository extends JpaRepository<PackagingType, Integer> {
}
