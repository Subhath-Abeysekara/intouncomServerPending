package com.intouncmmon.backend.Repository.exception;

import com.intouncmmon.backend.Entity.feedback;
import com.intouncmmon.backend.Entity.pendingProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface feedbackRepo extends JpaRepository<feedback, Long> {
}
