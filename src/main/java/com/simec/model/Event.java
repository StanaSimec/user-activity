package com.simec.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Event {

    private final String type;
    private final Repository repository;
    private final Payload payload;

    @JsonCreator
    Event(@JsonProperty("type") String type, @JsonProperty("repo") Repository repository,
          @JsonProperty("payload") Payload payload) {
        this.type = type;
        this.repository = repository;
        this.payload = payload;
    }

    public String getType() {
        return type;
    }

    public Repository getRepository() {
        return repository;
    }

    public Payload getPayload() {
        return payload;
    }
}
