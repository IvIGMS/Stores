package com.ivanfrias.Stores.repositories;

import com.ivanfrias.Stores.model.StoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<StoreEntity, Long> {

}
