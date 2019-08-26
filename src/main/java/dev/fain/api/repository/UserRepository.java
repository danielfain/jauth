package dev.fain.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.fain.api.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
  public List<User> findAll();
}