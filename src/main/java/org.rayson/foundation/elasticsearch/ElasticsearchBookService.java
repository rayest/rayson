package org.rayson.foundation.elasticsearch;

import java.util.List;
import java.util.Optional;
import javax.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-11-28
 *  Time: 10:38 AM
 *  Description:
 **/
@Service
public class ElasticsearchBookService {

  @Resource
  private ElasticsearchBookRepository elasticsearchBookRepository;

  public ElasticsearchBook save(ElasticsearchBook elasticsearchBook) {
    return elasticsearchBookRepository.save(elasticsearchBook);
  }

  public void delete(ElasticsearchBook elasticsearchBook) {
    elasticsearchBookRepository.delete(elasticsearchBook);
  }

  public Optional<ElasticsearchBook> findOne(String id) {
    return elasticsearchBookRepository.findById(id);
  }

  public Iterable<ElasticsearchBook> findAll() {
    return elasticsearchBookRepository.findAll();
  }

  public Page<ElasticsearchBook> findByAuthor(String author, PageRequest pageRequest) {
    return elasticsearchBookRepository.findByAuthor(author, pageRequest);
  }

  public List<ElasticsearchBook> findByTitle(String title) {
    return elasticsearchBookRepository.findByTitle(title);
  }
}
