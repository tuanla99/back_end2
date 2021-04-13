package com.it5420.api.service;

import com.it5420.api.entity.News;

import java.util.List;

public interface NewsService {
    List<News> getAll() ;
    List<News> findByNewspaper(String newspaper) ;
}
