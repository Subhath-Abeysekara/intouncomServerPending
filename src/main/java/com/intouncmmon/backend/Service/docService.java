package com.intouncmmon.backend.Service;

import com.intouncmmon.backend.Entity.docCategories;
import com.intouncmmon.backend.Entity.docImage;
import com.intouncmmon.backend.Entity.docImageAddDto;

import java.util.List;

public interface docService {


    String addDocCategory(docCategories docCategories);

    String addDocImage(docImageAddDto docImage);

    List<docCategories> getDocCats();

    List<docImage> getDocImagesByCat(Long id);
}
