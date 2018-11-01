package com.nix.otmm.model.session;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by katya on 09/13/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OtmmSession {
    @JsonProperty("session_resource")
    private SessionResource sessionResource;

    public SessionResource getSessionResource() {
        return sessionResource;
    }

    public void setSessionResource(SessionResource sessionResource) {
        this.sessionResource = sessionResource;
    }
}
