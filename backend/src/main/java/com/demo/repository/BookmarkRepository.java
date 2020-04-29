package com.demo.repository;

import com.demo.entity.Bookmark;
import com.demo.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface BookmarkRepository extends MongoRepository<Bookmark, String> {

    @Query("{username : ?0}")
    public List findBookmarkByUsername(String username);
}
