package com.nix.otmm.model.session;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by katya on 09/13/17.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Session {
    @JsonProperty("domain_name")
    private String domainName;
    @JsonProperty("id")
    private String id;
    @JsonProperty("message_digest")
    private String messageDigest;

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessageDigest() {
        return messageDigest;
    }

    public void setMessageDigest(String messageDigest) {
        this.messageDigest = messageDigest;
    }
}
