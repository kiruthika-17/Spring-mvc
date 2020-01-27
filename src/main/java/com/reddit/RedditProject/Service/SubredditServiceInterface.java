package com.reddit.RedditProject.Service;

import org.json.JSONException;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public interface SubredditServiceInterface {

    public ResponseEntity<String> saveSubreddit(String subreddit_name) throws JSONException, IOException;

}
