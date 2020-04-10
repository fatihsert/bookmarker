package com.demo.api;

import com.demo.entity.User;
import com.demo.repository.UserRepository;
import com.demo.security.Tokenization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/users")
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

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    //@PostMapping(path="/checkUser" )
    //public ResponseEntity setUser(@RequestBody User user){
    //    User asd = userRepository.findUserByName(user.getName());
    //    return ResponseEntity.ok(asd.getId());
    //}
    @PostMapping(path = "/login")
    public String login(@RequestBody User user) {
        User checkUsername  = userRepository.findUserByUsername(user.getUsername());
        String checkPassword = checkUsername.getPassword();
        boolean result = bCryptPasswordEncoder.matches(user.getPassword(), checkPassword);
        if (result == true){
            String ali = Tokenization.createJWT("1","Ali","deneme",10000000);
            System.out.println(Tokenization.decodeJWT(ali));
            return ali;
        }
        else {
            return "Password wrong";
        }
    }

    @PostMapping(path = "/sign-up")
    public String signUp(@RequestBody User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "Success";
    }


}
