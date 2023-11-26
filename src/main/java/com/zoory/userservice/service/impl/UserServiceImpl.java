package com.zoory.userservice.service.impl;

import com.zoory.userservice.dto.UserRequestDTO;
import com.zoory.userservice.dto.UserResponseDTO;
import com.zoory.userservice.entity.User;
import com.zoory.userservice.exception.NotFoundException;
import com.zoory.userservice.repo.UserRepo;
import com.zoory.userservice.service.UserService;
import com.zoory.userservice.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;
    @Override
    public void saveUser(UserRequestDTO userRequestDTO) {
        IdGenerator ids= new IdGenerator();
        String id = ids.generateID();
        if (!userRepo.existsById(id)){
            User user=new User(
                    id, userRequestDTO.getUserName(),userRequestDTO.getNicNo(),userRequestDTO.getNicImg(),
                    userRequestDTO.getPaymentSlipImg(),userRequestDTO.getAge(),userRequestDTO.getGender(),userRequestDTO.getEmail(),
                    userRequestDTO.getContactNo(),userRequestDTO.getAddress(),userRequestDTO.getPassword()
            );

            userRepo.save(user);
            System.out.println("UserSaved!!!");

        }else {
            throw new IllegalArgumentException("Id Is Already Exists");
        }

    }

    @Override
    public User updateUser(String id,UserRequestDTO userRequestDTO) {
        User userVar = userRepo.findById(id).get();
        if (userRepo.existsById(id)){
            userVar.setUserName(userRequestDTO.getUserName());
            userVar.setNicNo(userRequestDTO.getNicNo());
            userVar.setNicImg(userRequestDTO.getNicImg());
            userVar.setPaymentSlipImg(userRequestDTO.getPaymentSlipImg());
            userVar.setAge(userRequestDTO.getAge());
            userVar.setGender(userRequestDTO.getGender());
            userVar.setEmail(userRequestDTO.getEmail());
            userVar.setContactNo(userRequestDTO.getContactNo());
            userVar.setAddress(userRequestDTO.getAddress());
            userVar.setPassword(userRequestDTO.getPassword());

            userRepo.save(userVar);
            return userVar;

        }else {
            throw new NotFoundException("User Not Found To update");
        }

    }

    @Override
    public User deleteUser(String id) {

        User user=new User();
        if (userRepo.existsById(id)){
            userRepo.deleteById(id);
            return user;
        }else {
            throw new NotFoundException("User not found");
        }
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
}
