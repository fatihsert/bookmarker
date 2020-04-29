package com.demo.api;


import com.demo.entity.Bookmark;
import com.demo.repository.BookmarkRepository;
import com.demo.security.Tokenization;
import com.fasterxml.jackson.databind.util.JSONPObject;
import io.jsonwebtoken.Claims;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bookmarks")
public class BookmarkController {

    //Bookmark bookmark = new Bookmark();

    @Autowired
    private BookmarkRepository bookmarkRepository;

    @PostConstruct
    public void init(){
        Bookmark bookmark =new Bookmark();
        bookmark.setUsername("fsert");
        bookmark.setName("google");
        bookmark.setUrl("http://google.com");
        bookmarkRepository.save(bookmark);

        bookmark.setUsername("fsert");
        bookmark.setName("facebook");
        bookmark.setUrl("http://facebook.com");
        bookmarkRepository.save(bookmark);
    }


    @GetMapping
    public ResponseEntity<List> getBookmarks(String jwt){
        Claims result = Tokenization.decodeJWT(jwt);


        Date expiresAt = result.getExpiration();
        String audience = result.getAudience();


        List bookmarks = bookmarkRepository.findBookmarkByUsername(audience);
        System.out.println(bookmarks);

        return ResponseEntity.ok(bookmarks);
    }



}
