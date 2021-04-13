package com.it5420.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "news")
public class News {
    @Id
    private String id ;

    private String topic ;
    private String newspaper ;

    @Field(value = "publish_date")
    private String publishDate ;

    @Field(value = "created_date")
    private String createdDate ;

    private String language ;
    private String sapo ;
    private List<Content> contents ;

    @Field(value = "feature_images")
    private List<FeatureImage> featureImages ;

    private String avatar ;
}
