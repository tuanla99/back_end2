package com.it5420.api.service;

import com.it5420.api.entity.News;
import org.springframework.data.domain.Page;

import java.util.List;

public interface NewsService {
    Page<News> getAll( int offset, int limit) ;  // Lấy ra tất cả
    Page<News> findByNewspaper(String newspaper, int offset, int limit) ; // Tìm theo tên báo : Zing, ...
    Page<News> findByTopic(String topic, int offset, int limit) ; // Tìm theo chủ đề : thời sự, thể thao, ...
    Page<News> search( String text, int offset, int limit) ;
    List<News> similarNews(String id) ;
}
