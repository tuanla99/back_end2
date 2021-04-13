package com.it5420.api.controller;

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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/it5420/api")
//@CrossOrigin(origins = "http://localhost:8081")
@Tag(name = "news")
public class NewsController {

    @Autowired
    private NewsService newsService ;

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
    public ResponseEntity<List<News>> getAllNewsByNews(){
        return new ResponseEntity<>(newsService.getAll(), HttpStatus.OK) ;
    }


    @GetMapping("/news/{newspaper}")

    public ResponseEntity<List<News>> getAllNewsByNews(
            @Parameter(description = "newspaper : Zing, ..", required = true)
            @PathVariable("newspaper") String newspaper){

        return new ResponseEntity<>(newsService.findByNewspaper(newspaper), HttpStatus.OK) ;
    }
}
