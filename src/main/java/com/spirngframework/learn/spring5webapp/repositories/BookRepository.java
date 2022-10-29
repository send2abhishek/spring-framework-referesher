package com.spirngframework.learn.spring5webapp.repositories;

import com.spirngframework.learn.spring5webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
