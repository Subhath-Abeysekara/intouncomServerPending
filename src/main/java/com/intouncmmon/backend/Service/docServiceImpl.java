package com.intouncmmon.backend.Service;

import com.intouncmmon.backend.Entity.docCategories;
import com.intouncmmon.backend.Entity.docImage;
import com.intouncmmon.backend.Entity.docImageAddDto;
import com.intouncmmon.backend.Repository.exception.docCategoryRepo;
import com.intouncmmon.backend.Repository.exception.docImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class docServiceImpl implements docService{

    @Autowired
    private docCategoryRepo docCategoryRepo;

    @Autowired
    private docImageRepo docImageRepo;


    @Override
    public String addDocCategory(docCategories docCategories) {

        try {
            docCategoryRepo.save(docCategories);
            return "success";
        }
        catch (Exception e){
            return "Error";
        }
    }

    @Override
    public String addDocImage(docImageAddDto docImage) {
       try {
           Optional<docCategories> docCategories = docCategoryRepo.findById(docImage.getDocId());
           if (docCategories.isPresent()){
               com.intouncmmon.backend.Entity.docImage docImage1 = new docImage();
               docImage1.setUrl(docImage.getUrl());
               docImage1.setDocCategory(docCategories.get());
               docImageRepo.save(docImage1);
               return "success";
           }
           return "Error";
       }
       catch (Exception e){
           return "Error"+e;
       }
    }

    @Override
    public List<docCategories> getDocCats() {
        try{
            return docCategoryRepo.findAll();
        }
        catch (Exception e){
            return null;
        }
    }

    @Override
    public List<docImage> getDocImagesByCat(Long id) {
        try{
            Optional<docCategories> docCategories = docCategoryRepo.findById(id);
            return docCategories.map(com.intouncmmon.backend.Entity.docCategories::getDocImages).orElse(null);
        }
        catch (Exception e){
            return null;
        }
    }
}
