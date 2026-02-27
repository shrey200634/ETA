package com.example.service;

import com.example.entities.UserInfo;
import com.example.entities.UserInfoDto;
import com.example.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private final UserRepo userRepo;

    public UserInfoDto createOrUpdateUser(UserInfoDto userInfoDto) { // Change String to UserInfoDto

        // 1. Define how to update if user exists
        UnaryOperator<UserInfo> updatingUser = user -> {
            // Map fields from DTO to the existing Entity
            user.setFirstName(userInfoDto.getFirstName());
            user.setLastName(userInfoDto.getLastName());
            user.setEmail(userInfoDto.getEmail());
            user.setPhoneNumber(userInfoDto.getPhoneNumber());
            user.setProfilePic(userInfoDto.getProfilePic());
            return userRepo.save(user);
        };

        // 2. Define how to create if user is new
        Supplier<UserInfo> createUser = () -> {
            return userRepo.save(userInfoDto.transformToUserInfo());
        };

        // 3. Execute logic
        UserInfo userInfo = userRepo.findByUserId(userInfoDto.getUserId())
                .map(updatingUser)
                .orElseGet(createUser);

        // 4. Return the result as a DTO
        return UserInfoDto.builder()
                .userId(userInfo.getUserId())
                .firstName(userInfo.getFirstName())
                .lastName(userInfo.getLastName())
                .phoneNumber(userInfo.getPhoneNumber())
                .email(userInfo.getEmail())
                .profilePic(userInfo.getProfilePic())
                .build();
    }

    public UserInfoDto getUser(UserInfoDto userInfoDto) throws Exception{
        Optional<UserInfo> userInfoDtoOpt = userRepo.findByUserId(userInfoDto.getUserId());
        if(userInfoDtoOpt.isEmpty()){
            throw new Exception("User not found");
        }
        UserInfo userInfo = userInfoDtoOpt.get();
        return new UserInfoDto(
                userInfo.getUserId(),
                userInfo.getFirstName(),
                userInfo.getLastName(),
                userInfo.getPhoneNumber(),
                userInfo.getEmail(),
                userInfo.getProfilePic()
        );
    }





}