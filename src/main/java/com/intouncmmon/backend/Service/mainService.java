package com.intouncmmon.backend.Service;

import com.intouncmmon.backend.Entity.feedback;
import com.intouncmmon.backend.Entity.pendingProducts;

import java.util.List;

public interface mainService {

    String addProduct(pendingProducts pendingProducts);

    List<pendingProducts> getProducts();

    String confirmProduct(Long id , String url1  , String url2 , String header);

    String cancelProduct(Long id);

    String addFeedback(feedback feedback);

    List<feedback> getFeedbacks();

    String setFeedbackStatus(Long id , String status);

}
