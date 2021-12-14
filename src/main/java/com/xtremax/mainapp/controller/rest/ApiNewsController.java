package com.xtremax.mainapp.controller.rest;

import com.xtremax.mainapp.model.News;
import com.xtremax.mainapp.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/news")
public class ApiNewsController {

  @Autowired
  private NewsService newsService;

  @GetMapping(value = {"", "/", "/news"})
  public List<News> getListNews() {
    return newsService.getListNews();
  }

  @GetMapping(value = "/{id}")
  public News getNews(@PathVariable("id") Long id) {
    return newsService.getNews(id);
  }

  @PostMapping(value = {"", "/"})
  public boolean createNews(@RequestBody News news) {
    return newsService.createNews(news);
  }
}
