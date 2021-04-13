package com.it5420.api.service.impl;

import com.it5420.api.repository.NewsRepository;
import com.it5420.api.entity.News;
import com.it5420.api.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    NewsRepository newsRepository ;

    @Override
    public List<News> getAll() {
        return newsRepository.findAll();
    }

    @Override
    public List<News> findByNewspaper(String newspaper) {
        return newsRepository.findByNewspaperContaining(newspaper);
    }
}
