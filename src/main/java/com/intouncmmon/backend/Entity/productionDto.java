package com.intouncmmon.backend.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class productionDto {

    private productions productions;
    private Long categoryId=1L;
    private Long producerId=1L;

    public productionDto() {
    }


}
