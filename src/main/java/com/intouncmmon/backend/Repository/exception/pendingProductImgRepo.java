package com.intouncmmon.backend.Repository.exception;

import com.intouncmmon.backend.Entity.productImagesPending;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface pendingProductImgRepo extends JpaRepository<productImagesPending, Long> {

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM productImagesPending v WHERE v.id = :id")
    void deleteByPId(Long id);
}
