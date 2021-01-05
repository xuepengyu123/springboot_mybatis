package com.sys.manage.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.util.Date;

@Document(indexName = "es_book_index", type = "es_book_type")
@Getter
@Setter
public class Book {
    @Id
    @Field
    private String id;
    @Field
    private String name;
    @Field
    private Integer pageNum;
    @Field
    private Double price;
    @Field
    private String introduction;
    @Field
    private Date date;

}