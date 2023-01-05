package com.intouncmmon.backend.Service;

import com.intouncmmon.backend.Entity.*;
import com.intouncmmon.backend.Repository.exception.feedbackRepo;
import com.intouncmmon.backend.Repository.exception.pendingProductImgRepo;
import com.intouncmmon.backend.Repository.exception.pendingProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.Time;
import java.util.*;

@Service
public class mainServiceIMPL implements mainService{

    @Autowired
    private pendingProductRepo pendingProductRepo;

    @Autowired
    private feedbackRepo feedbackRepo;

    @Autowired
    private pendingProductImgRepo pendingProductImgRepo;

    RestTemplate restTemplate = new RestTemplate();

    @Override
    public String addProduct(pendingProducts pendingProducts) {

        try {
            pendingProductRepo.save(pendingProducts);
            return "success";
        }
        catch (Exception e){
            return "Error Adding " +e;
        }

    }

    @Override
    public List<pendingProducts> getProducts() {
        return pendingProductRepo.findAll();
    }

    private productionDto setProduction(pendingProducts pendingProducts ){
        productionDto productionDto = new productionDto();
        productions productions = new productions();

        productions.setBrand(pendingProducts.getBrand());
        productions.setPrice(pendingProducts.getPrice());
        productions.setSize(pendingProducts.getSize());
        productions.setColor(pendingProducts.getColor());
        productions.setMaterial(pendingProducts.getMaterial());
        productions.setDelivery(pendingProducts.getDelivery());
        productions.setOptions(pendingProducts.getOptions());
        productions.setUses(pendingProducts.getUses());
        productions.setWarranty(pendingProducts.getWarranty());
        productions.setSpecialData(pendingProducts.getSpecialData());

        productionDto.setProductions(productions);
        productionDto.setProducerId(pendingProducts.getProducerId());
        productionDto.setCategoryId(pendingProducts.getCategoryId());

        return productionDto;
    }

    @Override
    public String confirmProduct(Long id, String url1 , String url2 , String header) {
        Optional<pendingProducts> pendingProduct = pendingProductRepo.findById(id);
        if (pendingProduct.isPresent()){
            //add product to uncommon main service
            productionDto productionDto = setProduction(pendingProduct.get());
            productUncomAddObject productUncomAddObject = new productUncomAddObject();
            productUncomAddObject.setProductionDto(productionDto);
            productUncomAddObject.setUrl1(url1);
            productUncomAddObject.setUrl2(url2);
            String url = "http://localhost:9001/intouncommon/product/confirm";
            HttpHeaders headers = new HttpHeaders();
            headers.set("header" , header);
            HttpEntity<com.intouncmmon.backend.Entity.productUncomAddObject> entity2 = new HttpEntity<>(productUncomAddObject , headers);
            ResponseEntity<String> res = restTemplate.exchange(url, HttpMethod.POST,entity2, String.class);
            List<productImagesPending> productImagesPending = pendingProduct.get().getProductImagesPending();
            for (productImagesPending productImagesPending1 : productImagesPending){
                pendingProductImgRepo.deleteByPId(productImagesPending1.getId());
            }
            pendingProductRepo.deleteByPId(pendingProduct.get().getId());
            return res.getBody();
        }
        return "error id";
    }

    @Override
    public String cancelProduct(Long id) {
        Optional<pendingProducts> pendingProduct = pendingProductRepo.findById(id);
        if(pendingProduct.isPresent()){
            List<productImagesPending> productImagesPending = pendingProduct.get().getProductImagesPending();
            for (productImagesPending productImagesPending1 : productImagesPending){
                pendingProductImgRepo.deleteByPId(productImagesPending1.getId());
            }
            pendingProductRepo.deleteByPId(pendingProduct.get().getId());
            return "success";
        }
        return "error id";
    }

    @Override
    public String addFeedback(feedback feedback) {

        try {
            Date date = new Date();
            feedback.setDate(date);
            feedbackRepo.save(feedback);
            return "success";
        }
        catch (Exception e){
            return  "error "+e;
        }

    }

    @Override
    public List<feedback> getFeedbacks() {
        return feedbackRepo.findAll();
    }

    @Override
    public String setFeedbackStatus(Long id) {
        Optional<feedback> feedback = feedbackRepo.findById(id);
        if (feedback.isPresent()){
            feedback.get().setAdminShownStatus(true);
            return "success";
        }
        return "error";
    }

    @Override
    public List<feedback> getCustomerFeedbacks() {
       try{
           List<feedback> feedbacks = feedbackRepo.findAll();
           List<feedback> filterFeedbacks = new ArrayList<>();
           for (feedback feedback : feedbacks){
               if (feedback.isCustomerShownStatus()){
                   filterFeedbacks.add(feedback);
               }
           }
            return filterFeedbacks;
       }
       catch (Exception e){
           return null;
       }
    }

    @Override
    public String setFeedbackStatusCustomerShown(Long id) {
        Optional<feedback> feedback = feedbackRepo.findById(id);
        if (feedback.isPresent()){
            feedback.get().setCustomerShownStatus(true);
            feedbackRepo.save(feedback.get());
            return "success";
        }
        return "error";
    }
}
