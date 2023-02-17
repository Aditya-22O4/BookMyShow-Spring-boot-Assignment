package com.bookmyshow.BMS.services;

import com.bookmyshow.BMS.model.User;
import com.bookmyshow.BMS.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServicesImp implements UserServices {

    @Autowired
    private UserRepository userRepository;


    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        Optional<User> userObj = this.userRepository.findById(user.getUserId());
        if(userObj.isPresent()){
            User userUpdate = userObj.get();
            userUpdate.setUserId(user.getUserId());
            userUpdate.setUsername(user.getUsername());
            userUpdate.setPhonenumber(user.getPhonenumber());
            userUpdate.setEmail(user.getEmail());
            return this.userRepository.save(userUpdate);
        }else {
            throw new RuntimeException("No User found with + " + user.getUserId());
        }
    }

    @Override
    public List<User> getAllUser() {
        return this.userRepository.findAll();
    }

    @Override
    public User getUserById(long id) {
        Optional<User> pcObj = this.userRepository.findById(id);
        if(pcObj.isPresent()){
            return pcObj.get();
        }
        else {
            throw new RuntimeException("No User found with id " + id);
        }
    }


    @Override
    public void deleteUser(long userid) {
        Optional<User> pcObj = this.userRepository.findById(userid);
        if(pcObj.isPresent()){
            userRepository.delete(getUserById(userid));
        }
        else {
            throw new RuntimeException("No User found with id " + userid);
        }
    }
}






