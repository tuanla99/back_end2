package com.it5420.api.repository;


import com.it5420.api.entity.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends MongoRepository<News, String> {
    Page<News> findByNewspaperAllIgnoreCase(String newspaper, Pageable date) ; // dựa theo tên của trang báo
    Page<News> findAll(Pageable pageable) ; // lấy ra tất cả
    News getById(String id) ;
    List<News> getAllByNewspaper(String newspaper) ;
    Page<News> findByTopicAllIgnoreCase(String topic, Pageable date) ; // dựa theo thể loại : thể thao, thời sự, ...
    List<News> findByTitleContainingAllIgnoreCase(String text) ; // Tìm kiếm dựa trên title
    List<News> findDistinctByTitleContainingOrDescriptionContainingAllIgnoreCase(String title, String description) ; //Tìm kiếm dựa trên title và description
}
