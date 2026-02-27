package com.example.repo;

import com.example.entities.UserInfo;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface UserRepo extends CrudRepository<UserInfo , Long> {

    Optional<UserInfo> findByUserId(String userId);

}