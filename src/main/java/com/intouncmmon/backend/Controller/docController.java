package com.intouncmmon.backend.Controller;

import com.intouncmmon.backend.Entity.docCategories;
import com.intouncmmon.backend.Entity.docImage;
import com.intouncmmon.backend.Entity.docImageAddDto;
import com.intouncmmon.backend.Service.docService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/intouncommon")
@CrossOrigin
public class docController {

    @Autowired
    private docService docService;

    @PostMapping("/add/docCat")
    public String addDocCat(@RequestBody docCategories docCategories){
        return docService.addDocCategory(docCategories);
    }

    @PostMapping("/add/docImage")
    public String addDocImage(@RequestBody docImageAddDto docImageAddDto){
        return docService.addDocImage(docImageAddDto);
    }

    @GetMapping("/get/docCats")
    public List<docCategories> getDocCats(){
        return docService.getDocCats();
    }

    @GetMapping("/get/docCatImages/{id}")
    public List<docImage> getDocImages(@PathVariable Long id){
        return docService.getDocImagesByCat(id);
    }

    @GetMapping("/getLastId")
    private Long getLatest(){
        return docService.getLastImageId();
    }

    @DeleteMapping("/doc/delete/{id}")
    private String deleteDoc(@PathVariable Long id){
        return docService.deleteDocCat(id);
    }

}
