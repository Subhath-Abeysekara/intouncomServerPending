package com.intouncmmon.backend.Repository.exception;

import com.intouncmmon.backend.Entity.pendingProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface pendingProductRepo extends JpaRepository<pendingProducts , Long> {
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM pendingProducts v WHERE v.id = :id")
    void deleteByPId(Long id);
}
