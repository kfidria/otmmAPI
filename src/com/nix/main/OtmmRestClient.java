package com.nix.main;

/**
 * Created by kfidria on 09/13/17.
 */
public class OtmmRestClient extends com.nix.otmm.OtmmRestClient {
    public OtmmRestClient() {
    }

    public OtmmRestClient(String otmmUrl, String username, String password) {
        super(otmmUrl, username, password);
    }

    public OtmmRestClient(String csUrl, String username, String password, String workDir) {
        super(csUrl, username, password, workDir);
    }
}
