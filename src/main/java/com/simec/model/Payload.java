package com.simec.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Payload {

    private final String refType;
    private final String action;
    private final Commit[] commits;

    @JsonCreator
    Payload(@JsonProperty("ref_type") String refType, @JsonProperty("action") String action,
            @JsonProperty("commits") Commit[] commits){
        this.refType = refType;
        this.action = action;
        this.commits = commits;
    }

    public String getRefType() {
        return refType;
    }

    public String getAction() {
        return action;
    }

    public Commit[] getCommits() {
        return commits;
    }
}
