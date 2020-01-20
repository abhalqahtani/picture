//package com.sa.example.picture.rest;
//
//import com.sa.example.picture.domain.exception.RequiredInputException;
//import com.sa.example.picture.domain.exception.UnknownException;
//import com.sa.example.picture.rest.dto.UserInformation;
//import io.swagger.annotations.ApiOperation;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/users")
//@Log4j2
//public class UserRegistrationController {
//
//    private UserRegistrationService userRegistrationService;
//
//    @Autowired
//    public UserRegistrationController(UserRegistrationService userRegistrationService) {
//        this.userRegistrationService = userRegistrationService;
//    }
//
//    @RequestMapping(path = "/register/",method = RequestMethod.POST)
//    @ApiOperation(value = "Register User ... ")
//    public ResponseEntity<String> registerUser(@RequestBody UserInformation userInformation) throws RequiredInputException, UnknownException {
//        log.info("Rest: start registering user ... ");
//        this.userRegistrationService.storeUser(userInformation.getEmail(),userInformation.getPassword());
//        return new ResponseEntity<>( HttpStatus.OK);
//    }
//
//    @RequestMapping(path = "/logIn/",method = RequestMethod.POST)
//    @ApiOperation(value = "logIn User ... ")
//    public ResponseEntity<Boolean> LogIn(@RequestBody UserInformation userInformation) {
//        log.info("Rest: start login in user ... ");
//        return new ResponseEntity<>( this.userRegistrationService.logIn(userInformation.getEmail(), userInformation.getPassword()), HttpStatus.OK);
//    }
//}
//
