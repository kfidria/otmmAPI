package com.nix.otmm.api.impl;

import com.nix.otmm.api.ISessions;
import com.nix.otmm.constants.OTMMConstants;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class Session implements ISessions{
    private Client client;
    private String Jsession;

    @Override
    public void retrieveSession() {

    }

    @Override
    public void createSession() {
        Form form = new Form();
        form.param("username", OTMMConstants.OTMM_USERNAME);
        form.param("password", OTMMConstants.OTMM_PASSWORD);
//        logInfo("URL  " + otmmUrl);

        Response response = client.target(OTMMConstants.OTMM_API_URL).path(OTMMConstants.SESSION_URL).
                request(MediaType.APPLICATION_JSON_TYPE).
                post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE));

        Jsession =  response.getCookies().get(OTMMConstants.OTMM_SESSION_COOKIE).getValue();

//        logInfo("OTMM set session: " +
//                response.getStatusInfo().getStatusCode() +
//                " " +
//                response.getStatusInfo().getReasonPhrase());
//
//        logInfo("Jsession: " + Jsession);
    }

    @Override
    public void deleteSession() {
        Response response = client.target(OTMMConstants.OTMM_API_URL).path(OTMMConstants.SESSION_URL).
                request().
                delete();

//        logDebug("OTMM del session: " +
//                response.getStatusInfo().getStatusCode() +
//                " " +
//                response.getStatusInfo().getReasonPhrase());

    }

    @Override
    public void requestOTDSTicket() {

    }
}
