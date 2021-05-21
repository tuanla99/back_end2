package com.it5420.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "newspaper")
public class News {
    @Id
    private String id ;

    @Field(value = "Trang")
    private String newspaper ;

    @Field(value = "Category")
    private String topic ;

    @Field(value = "Title")
    private String title ;

    @Field(value = "Hour")
    private String hour ;

    @Field(value = "Total_second")
    private int totalSecond ;

    @Field(value = "Date")
    private Date date ;

//    @Field(value = "NoiDung")
//    private List<Content> contents ;

    @Field(value = "Description")
    private String description ;

    @Field(value = "Imagelink")
    private String imageLink ;

    @Field(value = "NewspaperLink")
    private String newspaperLink ;

    @Field(value = "similar")
    private List<String> similar ;
}
