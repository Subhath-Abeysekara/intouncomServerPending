package com.intouncmmon.backend.Repository.exception;

import com.intouncmmon.backend.Entity.docCategories;
import com.intouncmmon.backend.Entity.docImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface docImageRepo extends JpaRepository<docImage, Long> {
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM docImage v WHERE v.id = :id")
    void deleteByImageId(Long id);
}
