package com.nix.main;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.File;
import java.io.IOException;

public class MainRun {

    public static void main(String[] args) {
        MainRun obj = new MainRun();
        obj.run();
    }

    private void run() {
    //    ObjectMapper mapper = new ObjectMapper();
//
//        try {
//
//            // Convert JSON string from file to Object
//            MetadataModels staff = mapper.readValue(new File("test.json"), MetadataModels.class);
//            System.out.println(staff);
//            //Pretty print
//            String prettyStaff1 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(staff);
//            System.out.println(prettyStaff1);
//
//        } catch (JsonGenerationException e) {
//            e.printStackTrace();
//        } catch (JsonMappingException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

}
