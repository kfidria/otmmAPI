package com.nix.otmm;

/**
 * Created by kfidria on 09/13/17.
 */
public class OtmmServerUploader {
    public static void main(String[] args) {
        if (args != null && args.length !=0 ) {
            OtmmRestClient otmmServerClient = new OtmmRestClient(args[0], args[1], args[2]);
         //   otmmServerClient.upload(args[3], args[4], args[5], args[6], args[7], args[8], args[9], args[10]);
        }
    }
}
