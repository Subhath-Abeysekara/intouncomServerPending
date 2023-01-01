package com.intouncmmon.backend.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class productUncomAddObject {

    private productionDto productionDto;
    private String url1;
    private String url2;
}
