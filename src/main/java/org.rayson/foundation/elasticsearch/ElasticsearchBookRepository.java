package org.rayson.foundation.elasticsearch;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-11-28
 *  Time: 10:34 AM
 *  Description:
 **/
@Repository
public interface ElasticsearchBookRepository
    extends ElasticsearchRepository<ElasticsearchBook, String> {

  Page<ElasticsearchBook> findByAuthor(String author, Pageable pageable);

  List<ElasticsearchBook> findByTitle(String title);
}
