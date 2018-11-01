package com.nix.otmm.model.asset;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by katya on 09/18/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Manifest {
    @JsonProperty("upload_manifest")
    private UploadManifest uploadManifest;

    public Manifest(String fileName, String fileType) {
        this.uploadManifest = new UploadManifest(fileName, fileType);
    }

    public UploadManifest getUploadManifest() {
        return uploadManifest;
    }

    public void setUploadManifest(UploadManifest uploadManifest) {
        this.uploadManifest = uploadManifest;
    }
}

class UploadManifest {
    @JsonProperty("master_files")
    private MasterFiles masterFiles;


    public UploadManifest(String fileName, String fileType) {
        this.masterFiles = new MasterFiles(fileName, fileType);
    }

    public MasterFiles getMasterFiles() {
        return masterFiles;
    }

    public void setMasterFiles(MasterFiles masterFiles) {
        this.masterFiles = masterFiles;
    }
}

class MasterFiles{
    @JsonProperty("file")
    private ManifestFile file;

    public MasterFiles(String fileName, String fileType) {
        this.file = new ManifestFile(fileName, fileType);
    }

    public ManifestFile getFile() {
        return file;
    }

    public void setFile(ManifestFile file) {
        this.file = file;
    }
}

class ManifestFile {
    @JsonProperty("file_name")
    private String fileName;
    @JsonProperty("file_type")
    private String fileType;

    public ManifestFile(String fileName, String fileType) {
        this.fileName = fileName;
        this.fileType = fileType;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
