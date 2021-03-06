package com.kodilla.library.repository;

import com.kodilla.library.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User save(User user);

    Optional<User> getUserById(Long id);


}
