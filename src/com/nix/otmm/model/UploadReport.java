package com.nix.otmm.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by ash on 7/12/17.
 */

@XmlRootElement
public class UploadReport {
    private String nodeId;
    private String externalId;
    private String errorMessage;

    public UploadReport() {
    }

    public UploadReport(String nodeId, String externalId, String errorMessage) {
        this.nodeId = nodeId;
        this.externalId = externalId;
        this.errorMessage = errorMessage;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
