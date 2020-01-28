package com.reddit.RedditProject.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.reddit.RedditProject.DTO.AllSubredditDTO;
import com.reddit.RedditProject.DTO.SubredditDTO;
import com.reddit.RedditProject.Exception.DataNotFoundException;
import com.reddit.RedditProject.Model.Model;

import com.reddit.RedditProject.Model.SubredditModel;
import com.reddit.RedditProject.Repository.SubredditRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class SubredditService implements SubredditServiceInterface{

    @Autowired
    private SubredditRepo repo;

   // private Logger logger;

    @Value("${access_token}")
    private String access_token;

    public ResponseEntity<String> saveSubreddit(String subreddit_name)  throws JSONException, IOException,DataNotFoundException {
        final String uri = "https://oauth.reddit.com/r/"+subreddit_name+".json";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("user-agent","aaa");
        headers.set("authorization","bearer"+access_token) ;
        HttpEntity<String> entity=new HttpEntity<String>("parameters",headers);




                    ResponseEntity<String> response
                            = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);

                    if (Objects.nonNull(response)) {
                        JSONObject result = new JSONObject(response.getBody());

                        if (Objects.nonNull(result)) {

                            JSONObject data = (JSONObject) result.get("data");

                            if (Objects.nonNull(data)) {

                                JSONArray children = data.getJSONArray("children");
                                int postlength = children.length();

                                String output;

                                List<SubredditDTO> subredditList = new ArrayList<SubredditDTO>();

                                ObjectMapper objectMapper = new ObjectMapper();
                                for (int postCount = 0; postCount < postlength; postCount++) {
                                    JSONObject post = children.getJSONObject(postCount);
                                    JSONObject ans = (JSONObject) post.get("data");
                                    output = ans.toString();
                                    subredditList.add(objectMapper.readValue(output, SubredditDTO.class));
                                }

                                List<Model> model = new ArrayList<Model>();

                                for (SubredditDTO d : subredditList) {
                                    Model m = new Model();
                                    BeanUtils.copyProperties(d, m);
                                    model.add(m);
                                    saveUniqueRecord(m);

                                }

                            } else {
                                throw new DataNotFoundException("There exists no post under this Subreddit");
                            }

                        } else {
                            throw new DataNotFoundException("There exists no post under this Subreddit");
                        }
                    } else {
                        throw new DataNotFoundException("There exists no post under this Subreddit");
                    }

        return new ResponseEntity<String>("Posts are stored successfully", HttpStatus.OK);

    }

    private void saveUniqueRecord(Model m) {
        Optional<Model> model= repo.findByName(m.getName());
        if(!model.isPresent()) {

            try {
                repo.save(m);
               // logger= (Logger) LogManager.getLogger(SubredditService.class);
                //logger.info("Successfully saved subreddit to db");
            }
            catch(Exception e){
               // logger= (Logger) LogManager.getLogger(SubredditService.class);
               // logger.error("Exception occurs while saving subreddit to db");
                e.printStackTrace();
            }
        }

    }



}
