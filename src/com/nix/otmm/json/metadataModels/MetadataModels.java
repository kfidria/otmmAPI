package com.nix.otmm.json.metadataModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MetadataModels {
    @JsonProperty("metadata_models_resource")
    private MetadataModelsResource metadataModelsResource;

    public MetadataModelsResource getMetadataModelsResource() {
        return metadataModelsResource;
    }

    public void setMetadataModelsResource(MetadataModelsResource metadataModelsResource) {
        this.metadataModelsResource = metadataModelsResource;
    }

    public MetadataModels(MetadataModelsResource metadataModelsResource) {
        this.metadataModelsResource = new MetadataModelsResource();
    }
}

class MetadataModelsResource {
    @JsonProperty("metadata_model_list")
    private MetadataModelList[] metadataModelList;

    public MetadataModelsResource() {
        this.metadataModelList = metadataModelList;
    }

    public MetadataModelList[] getMetadataModelList() {
        return metadataModelList;
    }


}

class MetadataModelList{
    @JsonProperty("id")
    private String id;

    public MetadataModelList() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}