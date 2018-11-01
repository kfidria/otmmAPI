package com.nix.otmm.model.asset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PermissionsMap {

    private List<HashMap> entry;

    public PermissionsMap() {
        List<HashMap> entry = new ArrayList<HashMap>();

        HashMap mMap = new HashMap();
        mMap.put("key","text.securityPolicy.permission.Custom04Permission");
        mMap.put("value",Boolean.TRUE);
        entry.add(mMap);

        mMap = new HashMap(); // create a new one!
        mMap.put("key","text.securityPolicy.permission.ContentEditPermission");
        mMap.put("value",Boolean.TRUE);
        entry.add(mMap);

        mMap = new HashMap(); // create a new one!
        mMap.put("key","text.securityPolicy.permission.AssetViewPermission");
        mMap.put("value",Boolean.TRUE);
        entry.add(mMap);

        mMap = new HashMap(); // create a new one!
        mMap.put("key","text.securityPolicy.permission.ProjectViewPermission");
        mMap.put("value",Boolean.TRUE);
        entry.add(mMap);

        mMap = new HashMap(); // create a new one!
        mMap.put("key","text.securityPolicy.permission.MembershipEditPermission");
        mMap.put("value",Boolean.TRUE);
        entry.add(mMap);

        mMap = new HashMap(); // create a new one!
        mMap.put("key","text.securityPolicy.permission.Custom03Permission");
        mMap.put("value",Boolean.TRUE);
        entry.add(mMap);

        mMap = new HashMap(); // create a new one!
        mMap.put("key","text.securityPolicy.permission.CommentsPermission");
        mMap.put("value",Boolean.TRUE);
        entry.add(mMap);

        mMap = new HashMap(); // create a new one!
        mMap.put("key","text.securityPolicy.permission.MetaDataEditPermission");
        mMap.put("value",Boolean.TRUE);
        entry.add(mMap);

        mMap = new HashMap(); // create a new one!
        mMap.put("key","text.securityPolicy.permission.EditParentsPermission");
        mMap.put("value",Boolean.TRUE);
        entry.add(mMap);

        mMap = new HashMap(); // create a new one!
        mMap.put("key","text.securityPolicy.permission.Custom02Permission");
        mMap.put("value",Boolean.TRUE);
        entry.add(mMap);

        mMap = new HashMap(); // create a new one!
        mMap.put("key","text.securityPolicy.permission.ExportPermission");
        mMap.put("value",Boolean.TRUE);
        entry.add(mMap);

        mMap = new HashMap(); // create a new one!
        mMap.put("key","text.securityPolicy.permission.SummaryViewPermission");
        mMap.put("value","true");
        entry.add(mMap);

        mMap = new HashMap(); // create a new one!
        mMap.put("key","text.securityPolicy.permission.PreviewViewPermission");
        mMap.put("value",Boolean.TRUE);
        entry.add(mMap);

        mMap = new HashMap(); // create a new one!
        mMap.put("key","text.securityPolicy.permission.SubscribePermission");
        mMap.put("value",Boolean.TRUE);
        entry.add(mMap);

        mMap = new HashMap(); // create a new one!
        mMap.put("key","text.securityPolicy.permission.DeleteAssetPermission");
        mMap.put("value",Boolean.TRUE);
        entry.add(mMap);

        mMap = new HashMap(); // create a new one!
        mMap.put("key","text.securityPolicy.permission.Custom01Permission");
        mMap.put("value",Boolean.TRUE);
        entry.add(mMap);

        this.entry = entry;
    }

    public  List<HashMap> getEntry() {
        return entry;
    }

    public void setEntry( List<HashMap> entry) {
        this.entry = entry;
    }
}
