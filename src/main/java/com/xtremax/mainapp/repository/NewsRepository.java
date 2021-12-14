package com.xtremax.mainapp.repository;

import com.xtremax.mainapp.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
  News findByTitle(String title);
  News findByAuthor(String author);
}
