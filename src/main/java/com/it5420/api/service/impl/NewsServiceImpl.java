package com.it5420.api.service.impl;

import com.it5420.api.repository.NewsRepository;
import com.it5420.api.entity.News;
import com.it5420.api.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    NewsRepository newsRepository ;

    @Override
    public Page<News> getAll( int offset, int limit) {
        return  newsRepository.findAll(PageRequest.of(offset, limit,Sort.by("date").descending()));
    }

    @Override
    public Page<News> findByNewspaper(String newspaper, int offset, int limit) {
        return newsRepository.findByNewspaperContainingAllIgnoreCase(newspaper,PageRequest.of(offset,limit,Sort.by("date").descending()));
    }

    @Override
    public Page<News> findByTopic(String topic, int offset, int limit) {
        return newsRepository.findByTopicContainingAllIgnoreCase(topic,PageRequest.of(offset,limit,Sort.by("date").descending()));
    }

    @Override
    public Page<News> search(String text, int offset, int limit) {
        return newsRepository.findDistinctByTitleContainingOrDescriptionContainingAllIgnoreCase(text, text,PageRequest.of(offset,limit,Sort.by("date").descending()));
    }

    @Override
    public List<News> similarNews(String id) {
        News news = newsRepository.getById(id) ;
        List<String> similar_id = news.getSimilar() ;
        if (similar_id.size()>0){
            List<News> similar = new ArrayList<>();
            for (int i=0;i<similar_id.size();i++){
                similar.add(newsRepository.getById(similar_id.get(i))) ;
            }
            return similar;
        }else {
            return null ;
        }
    }

}
