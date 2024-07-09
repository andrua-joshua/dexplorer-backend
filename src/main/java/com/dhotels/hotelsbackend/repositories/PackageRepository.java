package com.dhotels.hotelsbackend.repositories;

import com.dhotels.hotelsbackend.modules.Package;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackageRepository extends JpaRepository<Package, Integer> {
}
