package com.reddit.RedditProject.Repository;

import com.reddit.RedditProject.Model.Model;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SubredditRepo extends CrudRepository<Model,Integer> {


    Optional<Model> findByName(String name);
}
