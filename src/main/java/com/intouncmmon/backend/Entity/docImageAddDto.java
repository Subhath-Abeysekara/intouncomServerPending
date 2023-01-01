package com.intouncmmon.backend.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class docImageAddDto {

    private Long docId;
    private String url;
}
