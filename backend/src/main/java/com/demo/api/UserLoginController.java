package com.demo.api;

import com.demo.entity.User;
import com.demo.repository.UserRepository;
import com.demo.security.Tokenization;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Api(value="User Management System", description="backend swagger implementation")

public class UserLoginController {

    @Autowired
    private UserRepository userRepository;


    BCryptPasswordEncoder bCryptPasswordEncoder =new BCryptPasswordEncoder();

    @PostConstruct
    public void init() {
        User user = new User();
        user.setId("1");
        user.setName("Ali");
        user.setSurname("kayim");
        userRepository.save(user);

    }

    @ApiOperation(value = "View a list of users", response = List.class)
    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    //@PostMapping(path="/checkUser" )
    //public ResponseEntity setUser(@RequestBody User user){
    //    User asd = userRepository.findUserByName(user.getName());
    //    return ResponseEntity.ok(asd.getId());
    //}

    @ApiOperation(value = "Generate user token", response = String.class)
    @PostMapping(path = "/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody User user) {
        User checkUsername  = userRepository.findUserByUsername(user.getUsername());
        String checkPassword = checkUsername.getPassword();
        boolean result = bCryptPasswordEncoder.matches(user.getPassword(), checkPassword);
        if (result == true){
            String ali = Tokenization.createJWT("1","Ali","deneme",300000, user.getUsername());
            System.out.println(Tokenization.decodeJWT(ali));

            Map<String, Object> responseMessage = new HashMap<String, Object>();
            responseMessage.put("username", user.getUsername());
            responseMessage.put("token", ali);


            Map<String, Object> json = new HashMap<String, Object>();
            json.put("message", responseMessage);


            return (new ResponseEntity<Map<String, Object>>(json, HttpStatus.OK));
            //return ali  ;
        }
        else {
            Map<String, Object> json = new HashMap<String, Object>();
            json.put("message", "Wrong password");
            return (new ResponseEntity<Map<String, Object>>(json,HttpStatus.BAD_REQUEST));
        }
    }
    @ApiOperation(value = "Add an user")
    @PostMapping(path = "/sign-up")
    public String signUp(@RequestBody User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "Success";
    }


}
