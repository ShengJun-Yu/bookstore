package com.jun.domain;

import lombok.Data;

/**
 * @author : Bojack
 * @date : Created in 15:45 2022.10.29
 */
//@TableName("tbl_book")
//替代get set toString  hashcode  @Data
@Data
public class Book {
    private Integer id;
    private String type;
    private String name;
    private String description;

}
