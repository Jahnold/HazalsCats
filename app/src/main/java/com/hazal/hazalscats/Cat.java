package com.hazal.hazalscats;

import com.google.gson.annotations.SerializedName;

public class Cat {

    @SerializedName("name")
    private String name;

    @SerializedName("image")
    private String url;

    @SerializedName("desc")
    private String desc;

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getDesc() {
        return desc;
    }
}
