package se.nackademin.java20.lab1.Application;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Daniel Bojic
 * Date: 2021-08-26
 * Time: 17:36
 * Project: Lab1
 * Copyright: MIT
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pass {

    private final String pass;

    @JsonCreator
    public Pass(@JsonProperty("pass") String pass) {
        this.pass = pass;
    }

    public String getPass() {
        return pass;
    }
}
