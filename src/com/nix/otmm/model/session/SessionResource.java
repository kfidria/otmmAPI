package com.nix.otmm.model.session;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by katya on 09/13/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SessionResource {

    private Session session;

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
