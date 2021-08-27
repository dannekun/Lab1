package se.nackademin.java20.lab1.Application;

import org.springframework.web.client.RestTemplate;

/**
 * Created by Daniel Bojic
 * Date: 2021-08-26
 * Time: 17:17
 * Project: Lab1
 * Copyright: MIT
 */
public class Serialize {

    RestTemplate restTemplate = new RestTemplate();

    Pass pass;

    String chosenUser = "1";

    String URL = "http://localhost:8082/risk/1";

    public Boolean smashOrPass(String url, String userId){

        return Boolean.parseBoolean(restTemplate.getForEntity("http://"+url+"/risk/"+ userId, Pass.class).getBody().getPass());

    }


}
