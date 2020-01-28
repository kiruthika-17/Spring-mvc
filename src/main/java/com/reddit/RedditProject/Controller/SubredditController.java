package com.reddit.RedditProject.Controller;
import com.reddit.RedditProject.ErrorClass.JsonErrorClass;
import com.reddit.RedditProject.Exception.DataNotFoundException;
import com.reddit.RedditProject.Service.SubredditServiceInterface;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class SubredditController {

    @Autowired
    private SubredditServiceInterface subredditService;

    @RequestMapping(value="/savesubreddit/{subreddit_name}",method = RequestMethod.GET)
    public ResponseEntity<String> saveSubreddit(@PathVariable String subreddit_name) throws JSONException, IOException {
        return subredditService.saveSubreddit(subreddit_name);
    }
    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<JsonErrorClass> toResponse(DataNotFoundException e) throws Exception{
        JsonErrorClass ec=new JsonErrorClass(404,e.getMessage());
        System.out.println("ccc");
        return new ResponseEntity<JsonErrorClass>(ec, HttpStatus.NOT_FOUND);
    }

}
