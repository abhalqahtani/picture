//package com.sa.example.picture.domain.service;
//
//import com.sa.example.picture.domain.data.User;
//import com.sa.example.picture.domain.data.UserRepository;
//import com.sa.example.picture.domain.exception.RequiredInputException;
//import com.sa.example.picture.domain.exception.UnknownException;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//@Log4j2
//public class UserRegistrationServiceImpl implements UserRegistrationService {
//
//    private UserRepository userRepository;
//
//    @Autowired
//    public UserRegistrationServiceImpl(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public void storeUser(String email, String password) throws RequiredInputException, UnknownException {
//
//        if (email.isEmpty() || password.isEmpty()) {
//            // TODO throw required input exception here
//            log.error("You need email and password to register user to store in db");
//            throw new RequiredInputException();
//        }
//        log.info("Storing user with email : {}  to database", email);
//        try {
//            userRepository.save(new User(email, password));
//        } catch (IllegalArgumentException e) {
//            log.info("Ops!, something happen when trying to store user with email: {}  to db full message: {} ",
//                    email, e.getMessage());
//            // TODO throw Exception with cause for client
//            throw new UnknownException(e);
//        }
//        log.info("User successfully registered and stored to database");
//    }
//
//    @Override
//    public boolean logIn(String username, String password) {
//        Optional<User> user = userRepository.findById(username);
//        if (user.isPresent()) {
//            log.info("Validating password ...");
//            if (user.get().getPassword().equals(password)) {
//                log.info("User authenticated");
//                return true;
//            } else {
//                log.error("Wrong password");
//                return false;
//            }
//        } else {
//            log.error("User is not registered");
//            return false;
//        }
//    }
//}
