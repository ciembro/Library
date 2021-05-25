package com.kodilla.library.repository;

import com.kodilla.library.domain.BookCopy;
import com.kodilla.library.domain.BookCopyDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface BookCopyRepository extends CrudRepository<BookCopy, Long> {

    @Override
    BookCopy save(BookCopy bookCopy);

    @Override
    Optional<BookCopy> findById(Long id);

    @Query(nativeQuery = true)
    List<BookCopyDto> getCopiesByBookId(@Param("id") Long bookId);

    @Query(nativeQuery = true)
    int getNumberOfAvailableCopies(@Param("id") Long bookId);
}



