package com.it5420.api.controller;

import com.it5420.api.repository.NewsRepository;
import com.it5420.api.service.NewsService;
import com.it5420.api.entity.News;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/it5420/api")
@CrossOrigin(origins = "*")
@Tag(name = "newspaper")
public class NewsController {

    @Autowired
    private NewsService newsService ;
    private NewsRepository repository ;
    @Operation(description = "xem tất cả bài báo trong database",
            responses = {
                    @ApiResponse(content = @Content(array = @ArraySchema(schema = @Schema(implementation = News.class))), responseCode = "200")
            })
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = "Thành công"),
            @ApiResponse(responseCode  = "403", description = "Truy cập bị cấm"),
            @ApiResponse(responseCode  = "404", description = "Không tìm thấy")
    })
    @GetMapping("/news")
    public ResponseEntity<Page<News>> getAllNews(
            @Parameter(description = "offset: trang bat dau, limit: so bai lay")
            @RequestParam("offset") int offset ,
            @RequestParam("limit") int limit
    ){
       // return new ResponseEntity<>(newsService.getAll(offset, limit), HttpStatus.OK) ;
    //    System.out.println(repository.findDistinctByTitleContainingOrDescriptionContainingAllIgnoreCase("covid"));
        return new ResponseEntity<>(newsService.getAll(offset, limit), HttpStatus.OK) ;
    }


    @GetMapping("/news/newspaper")

    public ResponseEntity<Page<News>> getAllNewsByNewspaper(
            @Parameter(description = "newspaper : Zing, ... , offset: trang bat dau, limit: so bai lay  ", required = true)
            @RequestParam("newspaper") String newspaper,
            @RequestParam("offset") int offset ,
            @RequestParam("limit") int limit
    ){

        return new ResponseEntity<>(newsService.findByNewspaper(newspaper,offset,limit), HttpStatus.OK) ;
    }

    @GetMapping("/news/category")

    public ResponseEntity<Page<News>> getNewsByTopic(
            @Parameter(description = "category : Thoi su, ... , offset: trang bat dau, limit: so bai lay  ", required = true)
            @RequestParam("category") String category,
            @RequestParam("offset") int offset ,
            @RequestParam("limit") int limit
    ){

        return new ResponseEntity<>(newsService.findByTopic(category, offset, limit), HttpStatus.OK) ;
    }

    @GetMapping("/news/search")
    public ResponseEntity<List<News>> search(
            @Parameter(description = "tìm kiếm trên description, title", required = true)
            @RequestParam(name = "text") String text,
            @RequestParam("offset") int offset ,
            @RequestParam("limit") int limit
    ){
        return new ResponseEntity<>(newsService.search(text, offset, limit),HttpStatus.OK) ;
    }

    @GetMapping("/news/similar")
    public ResponseEntity<List<News>> similar(
            @Parameter(description = "Danh sách các bài tương tự, params la news_id", required = true)
            @RequestParam(name = "news_id") String news_id
    ){
        return new ResponseEntity<>(newsService.similarNews(news_id),HttpStatus.OK) ;
    }
}
