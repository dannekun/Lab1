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

    String chosenUser = "1";

    String URL = "http://localhost:8080/risk/1";

    public void smashOrPass(){
        try {
            System.out.println(restTemplate.getForEntity(URL, Pass.class).getBody());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }


}
