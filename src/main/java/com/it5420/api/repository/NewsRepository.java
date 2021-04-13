package com.it5420.api.repository;


import com.it5420.api.entity.News;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends MongoRepository<News, String> {
    List<News> findByNewspaperContaining(String newspaper) ;
    List<News> findAll() ;
}
