package com.kodilla.library.repository;

import com.kodilla.library.domain.BookCopy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface BookCopyRepository extends CrudRepository<BookCopy, Long> {


}
