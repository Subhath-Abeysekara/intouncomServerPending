package com.intouncmmon.backend.Repository.exception;

import com.intouncmmon.backend.Entity.docCategories;
import com.intouncmmon.backend.Entity.pendingProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface docCategoryRepo extends JpaRepository<docCategories, Long> {
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM docCategories v WHERE v.id = :id")
    void deleteByDocId(Long id);
}
