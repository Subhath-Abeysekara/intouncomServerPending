package com.intouncmmon.backend.Controller;

import com.intouncmmon.backend.Entity.feedback;
import com.intouncmmon.backend.Entity.pendingProducts;
import com.intouncmmon.backend.Entity.productConfirmObject;
import com.intouncmmon.backend.Service.mainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/intouncommon")
@CrossOrigin
public class mainController {

    @Autowired
    private mainService mainService;

    @PostMapping("/addPendingProduct")
    public String addProduct(@RequestBody pendingProducts pendingProducts){
        return mainService.addProduct(pendingProducts);
    }

    @GetMapping("/getPendingProduct")
    public List<pendingProducts> getProducts(){
        return mainService.getProducts();
    }

    @PostMapping("/confirmProduct")
    public String confirm(@RequestBody productConfirmObject productConfirmObject , @RequestHeader String header){
        return mainService.confirmProduct (productConfirmObject.getId() , productConfirmObject.getUrl1() , productConfirmObject.getUrl2() , header);
    }

    @GetMapping("/cancelProduct/{id}")
    public String cancel(@PathVariable Long id){
        return mainService.cancelProduct(id);
    }

    @PostMapping("/addFeedback")
    public String addFeedback(@RequestBody feedback feedback){
        return mainService.addFeedback(feedback);
    }

    @GetMapping("/getFeedbacks")
    public List<feedback> getFeedbacks(){
        return mainService.getFeedbacks();
    }

    @PutMapping("/setFeedbackState/{id}/{status}")
    public String setFeedbackAdminStatus(@PathVariable Long id , @PathVariable String status){
        return mainService.setFeedbackStatus(id, status);
    }
}
