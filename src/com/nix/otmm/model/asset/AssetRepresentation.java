package com.nix.otmm.model.asset;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by katya on 09/18/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AssetRepresentation {

    @JsonProperty("asset")
    private Asset asset;

    public AssetRepresentation() {
           this.asset = new Asset();
    }

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }
}

/**
 * Created by katya on 09/19/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class Asset {
    @JsonProperty("access_control_descriptor")
    private AccessControlDescriptor accessControlDescriptor;
    @JsonProperty("version")
    private Integer version;
    @JsonProperty("subscribed_to")
    private Boolean subscribedTo;
    @JsonProperty("original_asset_id")
    private String originalAssetId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("metadata_state_user_name")
    private String metadataStateUserName;
    @JsonProperty("metadata_model_id")
    private String metadataModelId;
    @JsonProperty("metadata_lock_state_user_name")
    private String metadataLockStateUserName;
    @JsonProperty("locked")
    private Boolean locked;
    @JsonProperty("legacy_model_id")
    private Integer legacyModelid;
    @JsonProperty("latest_version")
    private Boolean latestVersion;
    @JsonProperty("import_user_name")
    private String importUserName;
    @JsonProperty("deleted")
    private Boolean deleted;
    @JsonProperty("date_last_updated")
    private String dateLastUpdated;
    @JsonProperty("date_imported")
    private String dateImported;
    @JsonProperty("creator_id")
    private String creatorId;
    @JsonProperty("content_type")
    private String contentType;
    @JsonProperty("content_state")
    private String contentState;
    @JsonProperty("content_lock_state_user_name")
    private String contentLockStateUserName;
    @JsonProperty("content_lock_state_user_id")
    private String contentLockStateUserId;
    @JsonProperty("content_lock_state_last_update_date")
    private String contentLockStateLastUpdateDate;
    @JsonProperty("content_editable")
    private Boolean contentEditable;
    @JsonProperty("checked_out")
    private Boolean checkedOut;
    @JsonProperty("asset_state_user_id")
    private String assetStateUserId;
    @JsonProperty("asset_state_last_update_date")
    private String assetStateLastUpdateDate;
    @JsonProperty("asset_state")
    private String assetState;
    @JsonProperty("asset_lock_state_user_id")
    private String assetLockStateUserId;
    @JsonProperty("asset_lock_state_last_update_date")
    private String assetLockStateLastUpdateDate;
//    @JsonProperty("asset_content_info")
//    private String assetContentInfo;


    public Asset() {
        this.version = new Integer(1);
        this.subscribedTo = Boolean.FALSE;
        this.originalAssetId = "";
        this.name = "";
        this.metadataStateUserName = "tsuper ?";
        this.metadataModelId = "ARTESIA.MODEL.DEFAULT";
        this.metadataLockStateUserName = "tsuper";
        this.locked = Boolean.FALSE;
        this.legacyModelid = new Integer(1);
        this.latestVersion = Boolean.TRUE;
        this.importUserName = "tsuper";
        this.deleted = Boolean.FALSE;
        this.dateLastUpdated = "";
        this.dateImported = "";
        this.creatorId = "1001";
        this.contentType = "ACROBAT";
        this.contentState = "NORMAL";
        this.contentLockStateUserName = "tsuper";
        this.contentLockStateUserId = "1001";
        this.contentLockStateLastUpdateDate = "";
        this.contentEditable = Boolean.TRUE;
        this.checkedOut = Boolean.FALSE;
        this.assetStateUserId = "1001";
        this.assetStateLastUpdateDate = "";
        this.assetState = "NORMAL";
        this.assetLockStateUserId = "1001";
        this.assetLockStateLastUpdateDate = "";
//        this.assetContentInfo = "{}";
        this.accessControlDescriptor = new AccessControlDescriptor();

    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Boolean getSubscribedTo() {
        return subscribedTo;
    }

    public void setSubscribedTo(Boolean subscribedTo) {
        this.subscribedTo = subscribedTo;
    }

    public String getOriginalAssetId() {
        return originalAssetId;
    }

    public void setOriginalAssetId(String originalAssetId) {
        this.originalAssetId = originalAssetId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMetadataStateUserName() {
        return metadataStateUserName;
    }

    public void setMetadataStateUserName(String metadataStateUserName) {
        this.metadataStateUserName = metadataStateUserName;
    }

    public String getMetadataModelId() {
        return metadataModelId;
    }

    public void setMetadataModelId(String metadataModelId) {
        this.metadataModelId = metadataModelId;
    }

    public String getMetadataLockStateUserName() {
        return metadataLockStateUserName;
    }

    public void setMetadataLockStateUserName(String metadataLockStateUserName) {
        this.metadataLockStateUserName = metadataLockStateUserName;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public Integer getLegacyModelid() {
        return legacyModelid;
    }

    public void setLegacyModelid(Integer legacyModelid) {
        this.legacyModelid = legacyModelid;
    }

    public Boolean getlatestVersion() {
        return latestVersion;
    }

    public void setlatestVersion(Boolean latestVersion) {
        this.latestVersion = latestVersion;
    }

    public String getImportUserName() {
        return importUserName;
    }

    public void setImportUserName(String importUserName) {
        this.importUserName = importUserName;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getDateLastUpdated() {
        return dateLastUpdated;
    }

    public void setDateLastUpdated(String dateLastUpdated) {
        this.dateLastUpdated = dateLastUpdated;
    }

    public String getDateImported() {
        return dateImported;
    }

    public void setDateImported(String dateImported) {
        this.dateImported = dateImported;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getContentState() {
        return contentState;
    }

    public void setContentState(String contentState) {
        this.contentState = contentState;
    }

    public String getContentLockStateUserName() {
        return contentLockStateUserName;
    }

    public void setContentLockStateUserName(String contentLockStateUserName) {
        this.contentLockStateUserName = contentLockStateUserName;
    }

    public String getContentLockStateUserId() {
        return contentLockStateUserId;
    }

    public void setContentLockStateUserId(String contentLockStateUserId) {
        this.contentLockStateUserId = contentLockStateUserId;
    }

    public String getContentLockStateLastUpdateDate() {
        return contentLockStateLastUpdateDate;
    }

    public void setContentLockStateLastUpdateDate(String contentLockStateLastUpdateDate) {
        this.contentLockStateLastUpdateDate = contentLockStateLastUpdateDate;
    }

    public Boolean getContentEditable() {
        return contentEditable;
    }

    public void setContentEditable(Boolean contentEditable) {
        this.contentEditable = contentEditable;
    }

    public Boolean getCheckedOut() {
        return checkedOut;
    }

    public void setCheckedOut(Boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    public String getAssetStateUserId() {
        return assetStateUserId;
    }

    public void setAssetStateUserId(String assetStateUserId) {
        this.assetStateUserId = assetStateUserId;
    }

    public String getAssetStateLastUpdateDate() {
        return assetStateLastUpdateDate;
    }

    public void setAssetStateLastUpdateDate(String assetStateLastUpdateDate) {
        this.assetStateLastUpdateDate = assetStateLastUpdateDate;
    }

    public String getAssetState() {
        return assetState;
    }

    public void setAssetState(String assetState) {
        this.assetState = assetState;
    }

    public String getAssetLockStateUserId() {
        return assetLockStateUserId;
    }

    public void setAssetLockStateUserId(String assetLockStateUserId) {
        this.assetLockStateUserId = assetLockStateUserId;
    }

    public String getAssetLockStateLastUpdateDate() {
        return assetLockStateLastUpdateDate;
    }

    public void setAssetLockStateLastUpdateDate(String assetLockStateLastUpdateDate) {
        this.assetLockStateLastUpdateDate = assetLockStateLastUpdateDate;
    }

//    public String getAssetContentInfo() {
//        return assetContentInfo;
//    }
//
//    public void setAssetContentInfo(String assetContentInfo) {
//        this.assetContentInfo = assetContentInfo;
//    }

    public AccessControlDescriptor getAccessControlDescriptor() {
        return accessControlDescriptor;
    }

    public void setAccessControlDescriptor(AccessControlDescriptor accessControlDescriptor) {
        this.accessControlDescriptor = accessControlDescriptor;
    }
}

/**
 * Created by katya on 09/19/17.
 */
class AccessControlDescriptor {
    @JsonProperty("permissions_map")
    private PermissionsMap permissionsMap;

    public AccessControlDescriptor() {
        this.permissionsMap = new PermissionsMap();
    }

    public PermissionsMap getPermissionsMap() {
        return permissionsMap;
    }

    public void setPermissionsMap(PermissionsMap permissionsMap) {
        this.permissionsMap = permissionsMap;
    }
}
