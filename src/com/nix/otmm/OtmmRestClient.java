package com.nix.otmm;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nix.otmm.constants.OTMMConstants;
import com.nix.otmm.model.asset.AssetRepresentation;
import com.nix.otmm.model.asset.Manifest;
import com.nix.otmm.model.UploadReport;
import com.nix.otmm.model.UploadResponse;
//import com.nix.strs.javaconnectors.OtmmFileMover;
//import com.nix.strs.util.StrsUtils;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.media.multipart.*;
import org.glassfish.jersey.media.multipart.file.FileDataBodyPart;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.*;
import javax.xml.bind.JAXBException;
import java.io.*;
import java.nio.file.Files;
import java.util.Date;
import java.util.concurrent.Callable;

/**
 * Created by kfidria on 09/13/17.
 *
 * @version 1.0
 * @author kfidria
 */
public class OtmmRestClient {
    private Client client;
    private String otmmUrl;
    private String username;
    private String password;
    private String workDir;
    private String repDir;
    private String Jsession;

//    private static final String OTMM_USERNAME = "tsuper";
//    private static final String OTMM_PASSWORD = "0pentext!";
//    private static final String OTMM_SESSION_COOKIE = "JSESSIONID";
//    private static final String OTMM_URL = "http://192.168.82.68:11090";
//
//    private static final String SESSION_URL = "otmmapi/v4/sessions";
//    private static final String ASSETS_URL  = "otmmapi/v4/assets";
//
//    private static final String PARENT_FOLDER_ID = "6fbdf080aad53eeffabd7cea57371045b8f74f54";
//
//    private static final String LOCAL_PDF_PATH = "D:\\Southwire\\PDF\\";
//    private static final String LOCAL_PDF_NAME = "SPEC47210.pdf";


    public static final String STRS_SUCCESS = "0";
    public static final String STRS_ERROR = "-1";
//    public static final String REPORT_PREFIX = "report_";



    static {
//        try {
//            StrsUtils.acquireStreamServeContext();
//        } catch (NoClassDefFoundError | UnsatisfiedLinkError e) {
//            System.out.println("Running in standalone mode.");
//        }
//        if ("true".equals(System.getProperty("debug"))) {
//            proxyHost = "localhost";
//            proxyPort = "8888";
//        }
    }

    public OtmmRestClient() {
        init();
    }

    public OtmmRestClient(String otmmUrl, String username, String password) {
        this.otmmUrl = otmmUrl;
        this.username = username;
        this.password = password;
        this.workDir = System.getProperty("user.dir");
        this.repDir = workDir;
        init();
    }


    public OtmmRestClient(String otmmUrl, String username, String password, String workDir) {
        this(otmmUrl, username, password);
        this.workDir = workDir;
    }

    public OtmmRestClient(String otmmUrl, String username, String password, String workDir, String repDir) {
        this(otmmUrl, username, password, workDir);
        this.repDir = repDir;
    }

    private void init() {
        if ("true".equals(System.getProperty("debug"))) {
            System.setProperty("http.proxyHost", "127.0.0.1");
            System.setProperty("http.proxyPort", "8888");
            this.otmmUrl = OTMMConstants.OTMM_URL;
            this.username = OTMMConstants.OTMM_USERNAME;
            this.password = OTMMConstants.OTMM_PASSWORD;
        }

        client = ClientBuilder.newBuilder()
                .register(MultiPartFeature.class)
                .register(JacksonFeature.class)
                .build();

    }

    private Integer getSessionStatus() {
        Response response = client.target(otmmUrl).path(OTMMConstants.SESSION_URL).
                request(MediaType.APPLICATION_JSON_TYPE).
                get();
//        logDebug("GetSessionStatus Server Response: " +
//                response.getStatusInfo().getStatusCode() +
//                " " +
//                response.getStatusInfo().getReasonPhrase());

        return response.getStatusInfo().getStatusCode();
    }

    private void setSession() {

        Form form = new Form();
        form.param("username", username);
        form.param("password", password);
//        logInfo("URL  " + otmmUrl);

        Response response = client.target(otmmUrl).path(OTMMConstants.SESSION_URL).
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

    private void delSessionStatus() {

        Response response = client.target(otmmUrl).path(OTMMConstants.SESSION_URL).
                request().
                delete();

//        logDebug("OTMM del session: " +
//                response.getStatusInfo().getStatusCode() +
//                " " +
//                response.getStatusInfo().getReasonPhrase());

    }

    private String createAssetInternal(String parentId, String fileName, String externalId, String dstDir, File m_tempFile)
            throws JsonProcessingException, UnsupportedEncodingException, JAXBException {

        setSession();

        File newFile = new File(m_tempFile.getParent(), fileName);
        try {
            Files.move(m_tempFile.toPath(), newFile.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileDataBodyPart f = new FileDataBodyPart("files",  newFile,
                new MediaType("application", "pdf").withCharset("UTF-8")) {
            @Override
            public void setFileEntity(File fileEntity, MediaType mediaType) {
                super.setFileEntity(fileEntity, mediaType);
                if(fileEntity != null) {
                    FormDataContentDisposition.FormDataContentDispositionBuilder builder = FormDataContentDisposition.name(this.getName());
                    builder.fileName(fileEntity.getName());
                    if(fileEntity.exists()) {
                        builder.size(fileEntity.length());
                        builder.modificationDate(new Date(fileEntity.lastModified()));
                    }
                    this.setFormDataContentDisposition(builder.build());
                }
            }
        };

        //manifest = "{"upload_manifest":{"master_files":[{"file":{"file_name":""+LOCAL_PDF_NAME+"","file_type":"application/pdf"}}]}}"
        MultiPart multiPart = new FormDataMultiPart()
                .field("asset_representation", String.valueOf(new AssetRepresentation()))
                .field("parent_folder_id", OTMMConstants.PARENT_FOLDER_ID)
                .field("no_content", "false")
                .field("manifest", new Manifest(fileName, "application/pdf"), MediaType.APPLICATION_JSON_TYPE.withCharset("utf-8"))
                .bodyPart(f);

        Response response = client.target(otmmUrl).path(OTMMConstants.ASSETS_URL)
                .request()
                .cookie(OTMMConstants.OTMM_SESSION_COOKIE, Jsession)
                .post(Entity.entity(multiPart,multiPart.getMediaType().withCharset("utf-8")));

        String nodeId = null;
        String errorMessage = null;
        if ( response.getStatusInfo().getStatusCode()  == 200) {
            nodeId = response.readEntity(UploadResponse.class).getId();
        } else {
            errorMessage = response.getStatusInfo().getReasonPhrase();
        }

        //createReport(nodeId, externalId, errorMessage, dstDir);
//        logInfo("Server Response: " +
//                response.getStatusInfo().getStatusCode() +
//                " " +
//                response.getStatusInfo().getReasonPhrase()
//        );

        delSessionStatus();

        return (response.getStatusInfo().getStatusCode() == 200) ? STRS_SUCCESS : STRS_ERROR;
    }
//
//    private String createReport(String nodeId, String externalId, String errorMessage, String dstDir) throws JAXBException {
//        JAXBContext jaxbContext = JAXBContext.newInstance(UploadReport.class);
//        Marshaller marshaller = jaxbContext.createMarshaller();
//
//        marshaller.marshal(new UploadReport(nodeId, externalId, errorMessage), new File(dstDir, REPORT_PREFIX + externalId + ".xml"));
//        return STRS_SUCCESS;
//    }

    private String handleErrors(Callable<String> method) {
        String result = STRS_ERROR;
        try {
            result = method.call();
        } catch (Exception e) {
//            logSevere("Fatal error: " + e.getMessage());
        }
        return result;
    }


    // The following method will be called from StreamServe, so it must always return String result.
    public String createAsset(String parentId, String name, String externalId, String repDir, File m_tempFile) {
        return handleErrors(() -> createAssetInternal(parentId, name, externalId,repDir, m_tempFile));
    }

    public static void main(String[] args) throws JAXBException {

        OtmmRestClient otmmServerClient = new OtmmRestClient(OTMMConstants.OTMM_URL, OTMMConstants.OTMM_USERNAME, OTMMConstants.OTMM_PASSWORD, null);
        otmmServerClient.createAsset(OTMMConstants.PARENT_FOLDER_ID,  OTMMConstants.LOCAL_PDF_NAME, "extId", null, new File(OTMMConstants.LOCAL_PDF_PATH+OTMMConstants.LOCAL_PDF_NAME));
    }

//    private void logSevere(String message) {
//        StrsUtils.logSevere(OtmmFileMover.class.getSimpleName(), message);
//    }
//
//    private void logError(String message) {
//        StrsUtils.logError(OtmmServerClient.class.getSimpleName(), message);
//    }
//
//    private void logInfo(String message) {
//        StrsUtils.logInfo(OtmmFileMover.class.getSimpleName(), message);
//    }
//
//    private void logDebug(String message) {
//        StrsUtils.logDebug(OtmmFileMover.class.getSimpleName(), message);
//    }


}
