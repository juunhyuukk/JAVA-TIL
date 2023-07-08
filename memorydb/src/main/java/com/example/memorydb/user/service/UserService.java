package com.example.memorydb.user.service;


import com.example.memorydb.user.db.UserRepository;
import com.example.memorydb.user.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity save(UserEntity user){
        // save
        return userRepository.save(user);
    }

    public List<UserEntity> findAll(){
        return userRepository.findAll();
    }

    public void delete(Long id){
        // userRepository.delete(id);
    }

    public Optional<UserEntity> findById(Long id){

        return userRepository.findById(id);
    }

    public List<UserEntity> filterScore(int score){

        return userRepository.findAllByScoreGreaterThanEqual(score);
    }

    public List<UserEntity> filterScore(int min, int max){

        return userRepository.findAllByScoreGreaterThanEqualAndScoreLessThanEqual(min, max);
    }


}
