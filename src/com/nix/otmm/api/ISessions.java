package com.nix.otmm.api;

public interface ISessions {
    //Retrieve the Session
    void retrieveSession();

    //Create a Session
    void createSession();

    //Delete the Session
    void deleteSession();

    //Request otds ticket for given resource
    void requestOTDSTicket();

}
