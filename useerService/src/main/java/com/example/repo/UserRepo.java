package com.example.repo;

import com.example.entities.UserInfoDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<UserInfoDto , String> {

    UserInfoDto findByUserId(String userId);

}
